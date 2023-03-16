package oop_cw;

import java.time.LocalDate;

public class Patient extends Person{
    private int uniqueId;
    
    public Patient(String Firstname,String Surname,LocalDate Date,int MobileNumber,int uniqueId){
        super(Firstname,Surname,Date,MobileNumber);
        this.uniqueId = uniqueId;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public LocalDate getDate() {
        return Date;
    }

    public int getMobileNumber() {
        return MobileNumber;
    }
    
    
}
