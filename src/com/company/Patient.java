package com.company;

import java.util.Objects;

// defines a class called Patient that extends the Person class
public class Patient extends com.company.Person {
    // The Patient class has a private field called Id that stores the patient's ID
    private String Id;

    // constructor for the Patient class that takes four parameters: firstName, surname, mobileNo, and dateOfBirth
    public Patient(String firstName, String surname, String mobileNo, String dateOfBirth) {
        // Patient constructor calls the Person constructor using the super keyword and passes the four parameters to it
        super(firstName, surname, mobileNo, dateOfBirth);

        // calls the setId method and prints the patient's ID
        setId();
        System.out.println("Patient ID :" + Id);
    }

    //takes a String parameter called Id and assigns it to the Id field using the this keyword
    public void setId(String Id) {
        this.Id = Id;
    }

    //generates a random ID for the patient
    void setId() {
        int min = 101;
        int max = 999;
        // casting the result to an int, and assigning it to the genPatientId variable
        int genPatientId = (int) (Math.random() * (max - min + 1) + min);
        //converts the genPatientId variable to a String and assigns it to the Id field.
        Id = String.valueOf(genPatientId);
    }

    public String getId() {
        //returns the value of the Id field
        return Id;
    }


    //static method that takes two String parameters called patientFirstName and patientSurName
    public static Patient isCustomer(String patientFirstName, String patientSurName) {
        //iterates through the Consultations objects in the Consultations class
        for (Consultations c : Consultations.getConsultations()) {
            // checks if the patient's first name and surname match the first name and surname of the patient in the current Consultation objec
            if (Objects.equals(c.getPatient().getName(), patientFirstName) &&
                    Objects.equals(c.getPatient().getSurname(), patientSurName)) {
                System.out.println("Previous Customer");
                return c.getPatient();
            }

        }
        //  If the patient's first name and surname do not match any of the patients in the Consultations objects, the method returns null
        return null;
    }

    @Override
    // toString method is an overridden method returns a string of the Patient object
    public String toString() {
        return "Classes.Patient{" +
                "id='" + Id + '\'' +
                '}';
    }

}



