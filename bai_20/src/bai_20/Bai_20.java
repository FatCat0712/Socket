/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_20;

/**
 *
 * @author maiso
 */
public class Bai_20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Counter c = new Counter();
        
        Thread t1 = new Thread(
                ()->{
                    for(int i = 0; i < 2000; i++){
                        c.increment();
                    }
                }
        );
        
        Thread t2 = new Thread(
                ()->{
                    for(int i = 0; i < 2000; i++){
                        c.increment();
                    }
                }
        );
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        System.out.println("Count: "+c.getCount());
    }
    
}
