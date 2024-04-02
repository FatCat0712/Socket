/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    private String username;
    private OutputStreamWriter outputStream;
    private InputStreamReader inputStream;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            this.outputStream = new OutputStreamWriter(socket.getOutputStream());
            this.inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);
            this.username = reader.readLine();
            clients.add(this);
            broadCast(username,"Server: "+username+" joined the chat");
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Override
    public void run() {
        String lines;
        BufferedReader reader = new BufferedReader(inputStream);
       
        try {
            while((lines = reader.readLine()) != null){
                 broadCast(username, username + " : " + lines);
            }
                
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void sendMessage(String message){
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(message);
        writer.flush();
    }

    public String getUsername() {
        return username;
    }
    
    public static void broadCast(String username, String message){
        for(ClientHandler c: clients){
            if(!c.getUsername().equals(username)){
                c.sendMessage(message);
            }
        }
    }
    
    public void removeClient(){
        clients.remove(this);
        broadCast(this.username,username+" has left");
        
    }
    
   
    
    
    
    
    
    
}
