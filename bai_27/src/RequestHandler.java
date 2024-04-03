
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class RequestHandler implements Runnable{
    private Socket socket;
    private OutputStreamWriter outputStream;
    private InputStreamReader inputStream;
    private PrintWriter writer;
    
    
    public RequestHandler(Socket socket){
        this.socket = socket;
        try {
            this.outputStream = new OutputStreamWriter(socket.getOutputStream());
            this.inputStream = new InputStreamReader(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
         try {
            writer = new PrintWriter(outputStream);
            BufferedReader reader = new BufferedReader(inputStream);
            
            String request = reader.readLine();
            if(request.equals("shutdown")){
                Runtime.getRuntime().exec("shutdown -s -t 3600");
                writer.println("PC is shutting down");
                writer.flush();
                System.out.println(request);
            }
            else if(request.equals("restart")){
                Runtime.getRuntime().exec("shutdown -r -t 3600");
                writer.println("PC is restarting");
                writer.flush();
                System.out.println(request);
            }
            else if(request.equals("cancel")){
                Runtime.getRuntime().exec("shutdown -a");
                writer.println("Cancelling");
                writer.flush();
                System.out.println(request);
            }
            else if(request.equals("screenshot")){
                try {
                    //take screenshot
                    BufferedImage screenshot = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                    
                    //push screenshot into byteoutputstream
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot,"png",baos);
                    
                   
                    //push outputstream into a byte array
                    byte[] imageByte = baos.toByteArray();
                    baos.close();
                    
                    // send the screenshot in binary shape
                    writer.println(imageByte.length);
                    writer.flush();
                    socket.getOutputStream().write(imageByte);
                    
                } catch (AWTException ex) {
                   writer.println("Cannot capture screen");
                   writer.flush();
                }
                
                System.out.println(request);
                
            }
            else if(request.equals("checkinfo")){
                Process proc = Runtime.getRuntime().exec("systeminfo");
                inputStream = new InputStreamReader(proc.getInputStream());
                reader = new BufferedReader(inputStream);
                String lines;
                while((lines = reader.readLine()) != null){
                        writer.println(lines);
                }
               
                writer.flush();
                writer.close();
                
                System.out.println(request);
        
            }
            else if(request.equals("upload")){
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                
                int fileNameLength = dis.readInt();
                if(fileNameLength > 0){
                    byte[] fileNameByte = new byte[fileNameLength];
                    dis.readFully(fileNameByte);
                    String fileName = new String(fileNameByte);
                    int fileContentLength = dis.readInt();
                    if(fileContentLength > 0){
                        byte[] fileContent = new byte[fileContentLength];
                        dis.readFully(fileContent,0,fileContent.length);
                        FileOutputStream fos = new FileOutputStream("E:\\"+fileName);
                        fos.write(fileContent);
                    }
                    
                }
                
            }
            else if(request.equals("download")){
                //Read file path from inputstream
                inputStream = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(inputStream);
                String lines;
                lines = reader.readLine();
                File downloadFile = new File(lines);
                
                //Read file from local
                FileInputStream fis = new FileInputStream(downloadFile.getAbsolutePath());
                
                String fileDownloadName = downloadFile.getName();
                
                
                
                byte[] fileContent = new byte[(int)downloadFile.length()];
                fis.read(fileContent);
                
         
                //Send file to ouputstream
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeInt(fileDownloadName.length());
                dos.write(fileDownloadName.getBytes());
                
                dos.writeInt(fileContent.length);
                dos.write(fileContent);
                
                System.out.println(request);
                
            }
            else if(request.equals("browser")){
                Runtime.getRuntime().exec("cmd.exe /c start msedge whitehat.vn");
                writer.println("Browser is opened");
                writer.flush();
                System.out.println(request);
            }
            
        } catch (IOException ex) {
             ex.printStackTrace();
             writer.println("Cannot execute command");
             writer.flush();
        }
    }
    
   
}
