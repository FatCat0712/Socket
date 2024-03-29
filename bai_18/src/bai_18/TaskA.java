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
public class TaskA extends Thread{

    @Override
    public void run() {
        while(true){
            System.out.println("Thread A is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(TaskA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
