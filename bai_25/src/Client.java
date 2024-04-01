
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class Client {
    public static void main(String[] args) {
        try {
            // Connect to server
            int port = 1234;
            Socket socket = new Socket("localhost",port);
            System.out.println("Connected server: ");
            
             OutputStreamWriter outputStream = new OutputStreamWriter(socket.getOutputStream());
             InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
             
        Scanner sc = new Scanner(System.in);
        String sendMessage;
        
         PrintWriter writer = new PrintWriter(outputStream);
         BufferedReader br = new BufferedReader(inputStream);
            while(true){
               
                
                // Send the message
                
               
               
                sendMessage = sc.nextLine();
                writer.println("Client: "+sendMessage);
                writer.flush();
                
                // Receive the message
                
                
                String receivedMessage  = br.readLine();
                System.out.println(receivedMessage);
            }
           
        } catch (Exception e) {
            System.out.println("Cannot connect to server");
        }
    }
}
