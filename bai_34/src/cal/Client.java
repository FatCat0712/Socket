/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author maiso
 */
public class Client {
    public static void main(String[] args) {
        try {
            // Lookup registry from server based on hostname, port
            Registry registry = LocateRegistry.getRegistry("localhost",1111);
           
            
            // Get the object from registry 
            CalculatorInterface calculatorStub =  (CalculatorInterface)registry.lookup("Calculator");
            
            // Execute
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println("---------------");
                System.out.println("Choose operator");
                System.out.println("1. + ");
                System.out.println("2. -");
                System.out.println("3. *");
                System.out.println("4. /");
                System.out.println("---------------");
                System.out.println("Enter your choice");
                String choice = sc.next();
                
               
                
                System.out.println("Enter a");
                double a = sc.nextDouble();
                
                System.out.println("Enter b");
                double b = sc.nextDouble();
                double result = 0;
                switch(choice){
                    case "+":
                        result = calculatorStub.add(a, b);
                        break;
                    case "-":
                        result = calculatorStub.subtract(a, b);
                        break;
                    case "*":
                        result = calculatorStub.multiply(a, b);
                        break;
                    case "/":
                        result = calculatorStub.divide(a, b);
                        break;   
                }
                System.out.println("Result: "+ result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
