
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
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
public class DomainNameSystemServer {
    private static final int PORT = 1221;
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(PORT);
            byte[] receiveData = new byte[1024];
            
            while(true){
                //receive data from client
                DatagramPacket receivePacket = new DatagramPacket(receiveData,0, receiveData.length);
                datagramSocket.receive(receivePacket);
                
                System.out.println("Received on port : " + receivePacket.getPort());
                
                String query = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("Query: "+query);

                
                //DNS table
                HashMap<String,String> dnsTable = new HashMap<>();
                dnsTable.put("www.example1.com", "1.1.1.1");
                dnsTable.put("www.example2.com", "2.2.2.2");
                dnsTable.put("www.google.com","8.8.8.8");


                
                String responseIP = "";
                if(dnsTable.containsKey(query)){
                       responseIP += dnsTable.get(query);
                }
                else{
                      responseIP += "IP is not found. Check hostname";
                }
                
                // response IP to client

                byte[] responseData = responseIP.getBytes();
                InetAddress ipQuery = receivePacket.getAddress();
                int portConnected = receivePacket.getPort();
                
                
                DatagramPacket sendPacket = new DatagramPacket(responseData, responseData.length, ipQuery, portConnected);
                datagramSocket.send(sendPacket);
                System.out.println("Sent on port : " + sendPacket.getPort());
            }
            
            
        } catch (SocketException ex) {
            ex.printStackTrace();
            System.out.println("Unable to start server");
        } catch (IOException ex) {
            Logger.getLogger(DomainNameSystemServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
