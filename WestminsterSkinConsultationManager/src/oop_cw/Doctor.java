package oop_cw;

import java.time.LocalDate;

public class Doctor extends Person{
    private int LicenceNum;
    private String specialization;
    
    public Doctor(String Firstname,String Surname,LocalDate Date,int MobileNumber,int LicenceNum,String specialization){
       super(Firstname,Surname,Date,MobileNumber);
       this.LicenceNum = LicenceNum;
       this.specialization = specialization;
    }

    public int getLicenceNum() {
        return LicenceNum;
    }

    public String getSpecialization() {
        return specialization;
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
