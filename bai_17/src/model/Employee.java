/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author maiso
 */
public class Employee implements Serializable{
    private String fullName;
    private String dateOfBirth;
    private String position;
    private String birthPlace;
    private String phoneNumber;
    private String email;
    private String portrait;

    public Employee() {
        
    }

    public Employee(String fullName, String dateOfBirth, String position, String birthPlace, String phoneNumber, String email,String portrait) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.birthPlace = birthPlace;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.portrait = portrait;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Override
    public String toString() {
        return "Employee{" + "fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", position=" + position + ", birthPlace=" + birthPlace + ", phoneNumber=" + phoneNumber + ", email=" + email + ", portrait=" + portrait + '}';
    }
    
   
    
    
    
    
    
}
