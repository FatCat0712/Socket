/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_18;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class TaskB implements Runnable{

    @Override
    public void run() {
       while(true){
           System.out.println("Thread B is running");
           try {
               Thread.sleep(500);
           } catch (InterruptedException ex) {
               Logger.getLogger(TaskB.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
