
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
public class RemoteServer{
    private static final int PORT = 1234;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static RequestHandler requestHandler;
    
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(PORT);
            while(true){
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress()+ " connected");
                requestHandler = new RequestHandler(socket);
                Thread handler = new Thread(requestHandler);
                handler.start();
                
            } 
        } catch (IOException ex) {
            Logger.getLogger(RemoteServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

    
    
     
}
