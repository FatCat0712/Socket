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
        
        
        Buffer bf = new Buffer(500);
        

        
        Producer p1 = new Producer(333,bf);
        Consumer c1 = new Consumer(712,bf);
        
         p1.start();
         c1.start();
        
       
        
       
       
        
        
       
        
        
       
        
    }
}
