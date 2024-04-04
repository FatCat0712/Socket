
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class Client {
    private static final int PORT = 1221;
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress server = InetAddress.getByName("localhost");
      
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("Enter a domain name");
                String sendMessage = sc.nextLine();
                if(!sendMessage.equalsIgnoreCase("exit")){
                    byte[] sendData = sendMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, server, PORT);
                    System.out.println("Sent on port " + sendPacket.getPort());
                    datagramSocket.send(sendPacket);
                    
                    
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData,0, receiveData.length);
                    datagramSocket.receive(receivePacket);
                    
                    String response = new String(receivePacket.getData(), 0,receivePacket.getLength());
                    
                    System.out.println("IP "+response);
                    System.out.println("Received on port " + receivePacket.getPort());
                }
                else{
                    System.out.println("bye");
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
