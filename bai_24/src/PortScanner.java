
import java.net.InetAddress;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class PortScanner {
    public static void main(String[] args) {
//        checkPort("localhost");
 //       checkPort("titv.vn");
            checkPort("127.0.0.1");
            
    }
    
    public static void checkPort(String urlString){
        int startPort = 1;
        int endPort = 65535;
        
        System.out.println("Scanning: " + urlString);
        
        for(int i = startPort; i <= endPort; i++){
            try {
                Socket socket = new Socket(urlString, i);
                System.out.println(i + " open ");
                socket.close();
            } catch (Exception e) {
                
            }
        }
        
        System.out.println("Done");
        
    }
    
  
}
