
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;
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
public class LightController {
    private static final int PORT = 5555;
    
    public static void main(String[] args) {
       
        try {
            InetAddress groupAddress = InetAddress.getByName("230.0.0.1");
            MulticastSocket multicastSocket = new MulticastSocket();
            
            String[] colors = {"","Red","Pink","Yellow"};
            
            Scanner sc = new Scanner(System.in);
            
            while(true){
                System.out.println("--- Light Controller ---");
                System.out.println("Choose a color: ");
                System.out.println("1. Red");
                System.out.println("2. Pink");
                System.out.println("3. Yellow");
                System.out.println("0. Exit");
                System.out.println("------------------------");

                int colorIndex = sc.nextInt();
                if(colorIndex == 0){
                    break;
                }
                sc.nextLine();
                String color = colors[colorIndex];

                byte[] sendData = color.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, groupAddress, PORT);
                multicastSocket.send(sendPacket);
                Thread.sleep(500);
            }
            
  
            
        } catch (UnknownHostException ex) {
            System.out.println("Host is unknown");
        } catch (IOException | InterruptedException ex) {
//            Logger.getLogger(LightController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something's wrong, unable to start server");
        }
        
    }
}
