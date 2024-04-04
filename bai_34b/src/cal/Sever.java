/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author maiso
 */
public class Sever {
    public static void main(String[] args) {
        try {
            //Create registry at server side
            Registry registry = LocateRegistry.createRegistry(1111);
            
            //Create a calculator object
            CalculatorInterface skeleton = new CalculatorImplement();
            
            //register a object in registry
            registry.rebind("Calculator", skeleton);
            
            while (true) {                
                System.out.println("Server is running ... ");
                Thread.sleep(2000);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
