
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class Receiver {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            MulticastSocket socket = new MulticastSocket(1234);
            socket.joinGroup(group);
            
            while(true){
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
                socket.receive(receivePacket);
                
                String receiveMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Message: "+ receiveMessage);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
  
}
