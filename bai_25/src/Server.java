
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Server {
    public static void main(String[] args){
        int port = 1234;
        try {
            //Create server socket and listen
            ServerSocket serverSocket = new ServerSocket(port);
            
            
            
            while(true){
                //Accept connection
               Socket clientSocket = serverSocket.accept();
               System.out.println(clientSocket.getInetAddress().getHostAddress()+" connected");
               MyProcess process = new MyProcess(clientSocket);
               process.start();
            }
            
           
                //Commnunicate
           
            
          
            
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
    
