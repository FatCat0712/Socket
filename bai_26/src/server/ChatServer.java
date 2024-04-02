/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class ChatServer {
    private static final int PORT = 5000;
    private ArrayList<ClientHandler> clients= new ArrayList<>();
    
    public void startServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Binding on port " + PORT +" !");
            
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println(clientSocket.getInetAddress().getHostAddress()+" connected");
                ClientHandler client = new ClientHandler(clientSocket, System.currentTimeMillis()+"",this);
                clients.add(client);
                client.start();
                 
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void broadCast(String id,String message){
        for(ClientHandler c : clients){
            if(!c.getChatId().equals(id)){
                c.sendMessage(message);
            }
        }
    }
    
}
