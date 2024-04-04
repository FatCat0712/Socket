
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
    private static final int PORT = 7777;
    public static void main(String[] args) {
        try {
            try (DatagramSocket datagramSocket = new DatagramSocket(PORT)) {
                byte[] receivedData = new byte[1024];
                
                int count = 0;
                while(true){
                    // create UDP socket
                    DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
                    try {
                        // receive data from socket
                        datagramSocket.receive(receivePacket);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // get date from socket and print out
                    String receiveMessage = new String(receivePacket.getData(),0,receivePacket.getLength());
                    System.out.println("Sender: "+ receiveMessage);
                    Thread.sleep(1000);
                    if(count == 100)
                        break;
                    count++;
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SocketException  ex) {
            System.out.println("Cannot start server");
        }
        
    }
}
