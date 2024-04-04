
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
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
public class Receiver2 {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket(1234);
//            socket.joinGroup(group);
            
           
            while(true){
                byte[] receivedData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
                
                socket.receive(receivePacket);
                
                String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message: "+ receiveMessage);
                
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Receiver2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receiver2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
