
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;
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
public class Sender {
    public static void main(String[] args) {
        try {
            System.out.println("Server is sending ... ");
            InetAddress multiCastAddress = InetAddress.getByName("230.0.0.1");
            MulticastSocket multiCastSocket = new MulticastSocket();
            
            String message = "Welcome to the party !";
            byte[] sendData = message.getBytes();
            
            while(true){
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, multiCastAddress, 1234);
                multiCastSocket.send(sendPacket);
                Thread.sleep(1000);
                
            }
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
