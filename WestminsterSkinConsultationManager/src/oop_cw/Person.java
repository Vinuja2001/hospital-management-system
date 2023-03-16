package oop_cw;

import java.time.LocalDate;

public class Person {
    String Firstname;
    String Surname;
    LocalDate Date;
    int MobileNumber;

    public Person(String Firstname, String Surname, LocalDate Date, int MobileNumber) {
        this.Firstname = Firstname;
        this.Surname = Surname;
        this.Date = Date;
        this.MobileNumber = MobileNumber;
    }
}
