
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
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
public class Client {
    
    public static void main(String[] args) {
        try {
            int i = 1;
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 7777;
            while(true){
                

                String sendMessage = "";

                sendMessage += "Iam number "+i+"\n";
                 byte[] sendData = sendMessage.getBytes();
                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress,serverPort);
                 socket.send(sendPacket);
                 i++;
            }
            
             
            
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
