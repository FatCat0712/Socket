/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_20;

/**
 *
 * @author maiso
 */
public class Counter {
    private int count = 0;
    
    //syncrhonized : dong bo, tai mot thoi diem chi co 1 thread goi
    public synchronized void increment(){
        count++;
    }
    
    public int getCount(){
        return count;
    }
}
