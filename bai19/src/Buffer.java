
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class Buffer {
    private int capacity;
    private ArrayList<Integer> productList = new ArrayList<>();
    
    public Buffer(int capacity){
        this.capacity = capacity;
        this.productList = new ArrayList<>();
    }
    
    public void addProduct(int productId,int producerId){
        System.out.println("Producer " + producerId +" add product: "+productId);
        productList.add(productId);
        System.out.println("Total products: "+productList.size());
        System.out.println("---------------------------------------");
    }
    
    public void removeProduct(int consumerId){
        System.out.println("Consumer "+consumerId+" buys product: "+productList.get(0));
        productList.remove(0);
        System.out.println("Remaining products: "+productList.size());
        System.out.println("---------------------------------------");
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getSize(){
        return productList.size();
    }
    
    
}
