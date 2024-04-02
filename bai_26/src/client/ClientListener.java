/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class ClientListener extends Thread{
    private Socket socket;
    private InputStreamReader inputStream;
    
    public ClientListener(Socket socket){
        this.socket = socket;
        try {
            this.inputStream = new InputStreamReader(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
         BufferedReader reader = new BufferedReader(inputStream);
         String lines;
        try {
            while((lines = reader.readLine()) != null){
                System.out.println(lines);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
