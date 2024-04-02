/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class ChatClient {
    private static final int PORT = 5000;
    private static final String URL = "localhost";
    
    
    public void startClient(){
        try {
            Socket socket = new Socket(URL, PORT);
            System.out.println("Connected to server ");
            
            // Listen continuously to the main stream and display in the console
            ClientListener listener = new ClientListener(socket);
            listener.start();
            
            
            // Write down message to outputStream and send to main stream
            OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
             PrintWriter writer = new PrintWriter(outputStream);
            Scanner sc = new Scanner(System.in);
           while(true){

               String message = sc.nextLine();
               writer.println(message);
               writer.flush();
           }
               
                
                
            
        } catch (IOException ex) {
            Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    
    
}
