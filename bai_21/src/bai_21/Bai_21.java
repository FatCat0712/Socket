/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai_21;

/**
 *
 * @author maiso
 */
public class Bai_21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Library lib = new Library();
        
        
        Book b1 = new Book("Harry Potter", "Me");
        Book b2 = new Book("First rule","Hai");
        Book b3 = new Book("Nothing","Crack");
        Book b4 = new Book("Something out there","One");
        
        lib.addBook(b1);
        lib.addBook(b2);
        lib.addBook(b3);
        lib.addBook(b4);
        
        lib.displayBooks();
        
        
        System.out.println();
        System.out.println();
        
        Student s1 = new Student(1,"Nothing",lib);
        Student s2 = new Student(2,"First rule",lib);
        Student s3 = new Student(3,"Something out there",lib);
        Student s4 = new Student(4, "First rule",lib);
        
        s1.start();
        s2.start();
        s3.start();
        s4.start();
        
      
        
//        lib.borrowBook(1, "Harry Potter");
//        lib.borrowBook(2, "Harry Potter");
//        
//        lib.returnBook(1, "Harry Potter");
//        lib.borrowBook(2, "Harry Potter");
        
        
        
    }
    
}
