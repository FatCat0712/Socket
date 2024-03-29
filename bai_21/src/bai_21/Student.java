/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_21;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiso
 */
public class Student extends Thread{
    private final int studentId;
    private final Library lib;
    private final String bookTitle;
    
    public Student(int studentId, String bookTitle,Library lib){
        this.studentId = studentId;
        this.bookTitle = bookTitle;
        this.lib = lib;
    }

    @Override
    public void run(){
        
            for(int i = 0; i < 10; i++){
                
                try {
                    lib.borrowBook(studentId, bookTitle);
                    sleep(1500);
                    lib.returnBook(studentId,bookTitle);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        
    }
    
}
