/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_21;

import java.util.ArrayList;

/**
 *
 * @author maiso
 */
public class Library {
    private ArrayList<Book> bookList;
    
    public Library(){
        bookList = new ArrayList<>();
    }
    
    public void addBook(Book b){
        bookList.add(b);
    }
    
    public synchronized void borrowBook(int studentId,String bookTitle){
        for(Book book : bookList){
            if(book.getTitle().equals(bookTitle)){
                if(book.isAvailable()){
                    book.setAvailabiliy(false);
                    System.out.println("Student "+studentId + " borrowed " + bookTitle);
                    return;
                }
            }
        }
        System.out.println(studentId + " cannot borrow "+ bookTitle);
    }
    
    public synchronized void returnBook(int studentId,String bookTitle){
       for(Book book : bookList){
            if(book.getTitle().equals(bookTitle)){
                if(!book.isAvailable()){
                    book.setAvailabiliy(true);
                    System.out.println("Student "+studentId + " returned " + bookTitle);
                    return;
                }
            }
        }
       System.out.println(studentId + " cannot return "+ bookTitle);
        
    }
    
    public void displayBooks(){
        for(Book b : bookList){
            System.out.println(b);
        }
    }
    
    
    
    
}
