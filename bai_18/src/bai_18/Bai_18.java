/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_18;

/**
 *
 * @author maiso
 */
public class Bai_18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Begin");
        
        Thread t1 = new TaskA();
        t1.start();
        
        Thread t2 = new Thread(new TaskB());
        t2.start();
        
        
        System.out.println("End");
        
        
    }
    
}
