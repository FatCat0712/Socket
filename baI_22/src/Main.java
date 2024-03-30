
import java.net.InetAddress;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class Main {
    public static void main(String[] args) {
        try{
             String domain = "huflit.edu.vn";
             InetAddress address = InetAddress.getByName(domain);
             System.out.println("IP address: "+address.getHostAddress());
             
             
             
             InetAddress localHost = InetAddress.getLocalHost();
             System.out.println("LocalHost: "+localHost.getHostAddress());
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    
    } 
   
}
   
    

