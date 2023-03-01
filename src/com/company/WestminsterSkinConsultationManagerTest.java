package com.company;

import org.junit.jupiter.api.DisplayName;   //specify a display name for a test class or method

import java.util.ArrayList; // provides an implementation of the List interface that uses an array to store the elements

import static junit.framework.TestCase.assertEquals;    //tests whether two values are equal

class WestminsterSkinConsultationManagerTest {  //defines a class called WestminsterSkinConsultationManagerTest

    // class has an ArrayList object called doctorArrayList that stores Doctor objects
    ArrayList<Doctor> doctorArrayList = new ArrayList<>();


    @org.junit.jupiter.api.Test
    @DisplayName("Add a doctor")
    void addNewDoctor() {
        //test method called addNewDoctor that has the @Test annotation and the @DisplayName annotation
        Person  person1 = new Person("Nadun","Peiris","0714528563","1998/02/25");
        Doctor doctor1 = new Doctor(person1.getName(), person1.getSurname(), person1.getDOB(), person1.getMobileNumber(),"D001","Paediatric");
        //adds the Doctor objects to the doctorArrayList object
        doctorArrayList.add(doctor1);
        // assertEquals method is used to test whether the size of the doctorArrayList objec
        assertEquals(1, doctorArrayList.size());

        Person  person2 = new Person("Ravi","Kannangara","0714589632","1998/02/17");
        Doctor doctor2 = new Doctor(person2.getName(), person2.getSurname(), person2.getDOB(), person2.getMobileNumber(),"D002","Paediatric");
        doctorArrayList.add(doctor2);
        assertEquals(2, doctorArrayList.size());
    }

    @org.junit.jupiter.api.Test // test method called deleteDoctor that has the @Test annotation
    void deleteDoctor() {
        // gets the medical license number of the first Doctor object in the doctorArrayList object
        String ID = doctorArrayList.get(0).getMedicalLicenseNumber();
        // removes the first Doctor object from the doctorArrayList object
        doctorArrayList.remove(0);
        // uses the assertEquals method to test whether the size of the doctorArrayList object
        assertEquals(1, doctorArrayList.size());
    }
}