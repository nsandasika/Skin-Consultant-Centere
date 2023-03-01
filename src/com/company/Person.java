package com.company;

// class called Person with four private fields called name, surname, DOB, and MobileNumber
public class Person {

    private String name;
    private String surname;
    private String DOB;
    private String MobileNumber;

    // constructor for the Person class that takes four parameters called firstName, surname, mobileNo, and dateOfBirth
    public Person(String firstName, String surname, String mobileNo, String dateOfBirth) {
        this.name = firstName;
        this.surname = surname;
        this.DOB = dateOfBirth;
        this.MobileNumber = mobileNo;

    }

    // constructor for the Person class
    public Person() {

    }

    // another constructor for the Person class that takes two parameters called firstName and surname
    public Person(String firstName, String surname) {
    }


    //return the value of the corresponding field
    public String getName() {
        return name;
    }

    //set the value of the corresponding field
    public void setName(String name) {
        this.name = name;
    }

    //return the value of the corresponding field
    public String getSurname() {
        return surname;
    }

    //set the value of the corresponding field
    public void setSurname(String surname) {
        this.surname = surname;
    }

    //return the value of the corresponding field
    public String getDOB() {
        return DOB;
    }

    //set the value of the corresponding field
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    //return the value of the corresponding field
    public String getMobileNumber() {
        return MobileNumber;
    }

    //set the value of the corresponding field
    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    @Override
    //returns a string representation of the Person object
    // string includes the person's name, surname, date of birth, and mobile number
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", DOB=" + DOB +
                ", mobileNumber=" + MobileNumber +
                '}';
    }

}
