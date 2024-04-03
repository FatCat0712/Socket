
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class RemoteClient {
    private static final String URL = "10.10.10.6";
    private static final int PORT = 1234;
    private static Socket socket;
    
    
    
    public static void main(String[] args) {
        try {  
          
                PrintWriter writer; 
                BufferedReader reader;
                boolean flag = true;
                Scanner sc = new Scanner(System.in);
                int choice;
                while(flag){
                    System.out.println("----------MENU----------");
                    System.out.println("1. Shutdown");
                    System.out.println("2. Restart");
                    System.out.println("3. Cancel shutdown");
                    System.out.println("4. Take screenshot");
                    System.out.println("5. See system infor");
                    System.out.println("6. Upload file");
                    System.out.println("7. Download file");
                    System.out.println("8. Open browser");
                    System.out.println("0. Exit");
                    System.out.println("------------------------");
                   
                    choice = sc.nextInt();
                    sc.nextLine();
                    switch(choice){
                        case 1:
                            System.out.println("You chose shutdown");
                            socket = new Socket(URL, PORT);
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.println("shutdown");
                            writer.flush();
                            System.out.println(reader.readLine());
                            socket.close();
                            break;
                        case 2:
                            System.out.println("You chose restart");
                            socket = new Socket(URL, PORT);
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.println("restart");
                            writer.flush();
                            System.out.println(reader.readLine());
                            socket.close();
                            break;
                        case 3:
                            System.out.println("You chose cancel");
                            socket = new Socket(URL, PORT);
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.println("cancel");
                            writer.flush();
                            System.out.println(reader.readLine());
                            socket.close();
                            break;
                        case 4:
                            System.out.println("You chose taking screenshot");
                            socket = new Socket(URL, PORT);
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.println("screenshot");
                            writer.flush();
                            
                            
                            int imageSize = Integer.parseInt(reader.readLine());
                            byte[] imageByte = new byte[imageSize];
                            int byteRead = socket.getInputStream().read(imageByte);
                            if(byteRead > 0){
                                System.out.println("Enter picture name: ");
                                String pictureName = sc.nextLine();
                                Path picturePath = Path.of("E:\\test\\image\\"+pictureName+".png");
                                Files.write(picturePath, imageByte);
                                System.out.println("Picture was saved at "+picturePath.toString());
                            }
                            
                            socket.close();
                            break;
                            
                        case 5:
                            System.out.println("Checking system info");
                            socket = new Socket(URL, PORT);
                           
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            writer.println("checkinfo");
                            writer.flush();

                           
                            
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            String lines;
                            String content = "";
                            while((lines = reader.readLine()) != null){
                                content += lines+"\n";
                            }
                            System.out.println("Enter a name to save file");
                            String saveName = sc.nextLine();
                            File saveFile = new File("E:\\"+saveName+".txt");
                            FileWriter fileWriter = new FileWriter(saveFile);
                            fileWriter.write(content);
                            fileWriter.flush();
                            fileWriter.close();
                            System.out.println("File was saved at: "+saveFile.toString());
                            socket.close();
                            break;
                        
                            
                        case 6:
                            System.out.println("You chose upload file");
                            socket = new Socket(URL,PORT);
                            
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            writer.println("upload");
                            writer.flush();
                            
                            System.out.println("Enter the local path of upload file: ");
                            String filePath = sc.nextLine();
                            File uploadFile = new File(filePath);
                            FileInputStream fis = new FileInputStream(uploadFile.getAbsoluteFile());
                            
                         
                            String fileName = uploadFile.getName();
                            byte[] fileContent = new byte[(int)uploadFile.length()];
                            fis.read(fileContent);
                            
                            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
                            
                            os.writeInt(fileName.length());
                            os.write(fileName.getBytes());
                            
                            
                            os.writeInt(fileContent.length);
                            os.write(fileContent);
                            break;
                            
                            
                        case 7:
                            System.out.println("You chose download file");
                            socket = new Socket(URL,PORT);
                            
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            writer.println("download");
                            writer.flush();
                            
                            System.out.println("Enter the remote path of download file: ");
                            String downloadFilePath = sc.nextLine();
                            writer.println(downloadFilePath);
                            writer.flush();
                            
                            //get download from inputstream
                            DataInputStream dis = new DataInputStream(socket.getInputStream());
                            // read the download file name
                            int fileNameLength = dis.readInt();
                            if(fileNameLength > 0){
                                byte[] fileNameByte = new byte[fileNameLength];
                                dis.readFully(fileNameByte);
                                String fileDownloadName = new String(fileNameByte);
                                //read download file content
                                int fileDownloadContent = dis.readInt();
                                if(fileDownloadContent > 0){
                                    byte[] fileContentByte =new byte[fileDownloadContent];
                                    dis.readFully(fileContentByte,0,fileContentByte.length);
                                    try ( // write content to file
                                        FileOutputStream downloadFile = new FileOutputStream("E:\\test\\download\\"+fileDownloadName)) {
                                        downloadFile.write(fileContentByte);
                                        downloadFile.flush();
                                        downloadFile.close();
                                    }
                                    
                                }
                                
                            }
                            
                            break;
                        case 8:
                            System.out.println("You chose open browser");
                            socket = new Socket(URL,PORT);
                            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            writer.println("browser");
                            writer.flush();
                            System.out.println(reader.readLine());
                            break;
                        case 0:
                            System.out.println("bye");
                            flag = false;
                            break;

                    }
                }
            }   
                
                
                
           
         catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Cannot connect to server");
        }
        
        
    }
}   

