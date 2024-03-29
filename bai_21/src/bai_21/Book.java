/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai_21;

/**
 *
 * @author maiso
 */
public class Book {

    private String title;
    private String authorName;
    private boolean availabiliy = true;

    public Book(String title, String authorName) {
        
        this.title = title;
        this.authorName = authorName;
    }


    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isAvailable() {
        return availabiliy;
    }

    public void setAvailabiliy(boolean availabiliy) {
        this.availabiliy = availabiliy;
    }
    
    @Override
    public String toString(){
        return String.format("%-20s%10s%10b",title,authorName,availabiliy);
    }
    
    
}
