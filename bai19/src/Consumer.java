
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
public class Consumer extends Thread{
    private final int consumerId;
    private final Buffer buffer;

    public Consumer(int consumerId,Buffer buffer){
        this.consumerId = consumerId;
        this.buffer = buffer;
    }
   

    @Override
    public void run() {   
       
        while(true){
             try {
                   sleep((long) (Math.random()*100));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(buffer.getSize() > 0){
                 buffer.removeProduct(consumerId);
                
              
            }
        }
    }
    
    
    
    
}
