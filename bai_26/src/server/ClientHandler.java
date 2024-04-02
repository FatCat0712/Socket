/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class ClientHandler extends Thread{
    private Socket socket;
    private String chatId;
    private InputStreamReader inputStream;
    private OutputStreamWriter outputStream;
    private ChatServer chatServer;
    
    public ClientHandler(Socket socket, String chatId, ChatServer chatServer){
        this.socket = socket;
        this.chatId = chatId;
        this.chatServer = chatServer;
        try {
            this.inputStream = new InputStreamReader(socket.getInputStream());
            this.outputStream = new OutputStreamWriter(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        chatServer.broadCast(chatId, chatId+" joined the chat");
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(inputStream);
        try {
            String lines;
            while((lines = reader.readLine()) != null){
                 chatServer.broadCast(chatId, chatId+" : "+lines);
            }
        }          
         catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String message){
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println(message);
        writer.flush();
    }

    public String getChatId() {
        return chatId;
    }

    
    
    
    
    
    
    
    
    
}
