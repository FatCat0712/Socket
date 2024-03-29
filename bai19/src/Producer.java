
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
public class Producer extends Thread{
    
    private final int producerId;
    private final Buffer buffer;
    
    public Producer(int producerId, Buffer buffer){
        this.producerId = producerId;
        this.buffer = buffer;
    }
    @Override
    public void run() {
        int i = 1;
       
        while(true){
            try {
                sleep((long) (Math.random()*100));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(buffer.getCapacity() > buffer.getSize()){
                buffer.addProduct(i++,producerId); 
            }
        }
    }
    
}
