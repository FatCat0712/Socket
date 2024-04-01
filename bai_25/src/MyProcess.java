
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class MyProcess extends Thread{
    private Socket socket;
    
    public MyProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
              InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
               OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
                 Scanner sc = new Scanner(System.in);
                 String sendMessage;
                  BufferedReader br = new BufferedReader(inputStream);
                  PrintWriter writer = new PrintWriter(outputStream);
             while(true){
                    // Receive and display message
                   
                  
                   String receivedMessage = br.readLine();
                   System.out.println(receivedMessage);


                   // Write and send message
                 sendMessage = sc.nextLine();
                  
                   
                       writer.println("Server: "+sendMessage);
                       writer.flush();
                   
            }
           
         
            
        } catch (IOException ex) {
            Logger.getLogger(MyProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
        
    }
    
    
}
