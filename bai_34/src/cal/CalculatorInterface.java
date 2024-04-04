/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cal;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author maiso
 */
public interface CalculatorInterface extends Remote{
    public double add(double a, double b) throws RemoteException;
    public double subtract(double a, double b) throws RemoteException;
    public double multiply(double a,double b) throws RemoteException;
    public double divide(double a, double b) throws RemoteException;
    
}
