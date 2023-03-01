package com.company;



import javax.swing.*;
import java.awt.*;
import java.text.ParseException;    // Represents an exception that is thrown when there is a problem in parsing a date string
import java.util.Date;  // Represents a specific instant in time,
import java.util.Objects;   // Provides utility methods for objects

public class Doctor extends com.company.Person {    // Defines a class called Doctor that extends the Person

    // private instance variables of the Doctor class called medicalLicenseNumber and specialization
    private String medicalLicenseNumber;
    private String specialization;



    public Doctor(String firstName, String surname, String dateOfBirth, String mobileNo, String medicalLicenseNumber, String specialization) {
        super(firstName,surname,mobileNo,dateOfBirth);  //Call the constructor of the superclass
        //Referring to the current object
        this.medicalLicenseNumber = medicalLicenseNumber ;
        this.specialization = specialization;
    }

    public Doctor(String firstName , String surname , String medicalLicenseNumber, String specialization) { //four parameters: firstName, surname, medicalLicenseNumber, and specialization
        // only initializes the firstName, surname, medicalLicenseNumber, and specialization instance variables
        super (firstName,surname);
        this.medicalLicenseNumber = medicalLicenseNumber ;
        this.specialization = specialization;
    }

    public Doctor(String licenceNumber, String specialization) {
        //Another constructor of the Doctor class
        //Two parameters called licenceNumber and specialization
    }



    public static Doctor findDoctorByFullName(String doctorFullName) {  //Static method called findDoctorByFullName
        for (Doctor doctor: WestminsterSkinConsultationManager.doctors ) {
            String value = doctor.getName()+" "+doctor.getSurname();    //Takes a doctorFullName string as a parameter and
            // returns a Doctor object
            if (doctorFullName.trim().equals(value)) return doctor; //method searches through the doctors array in the
            // WestminsterSkinConsultationManager
            // Returns the first Doctor object whose name and surname match the doctorFullName string
        }
        return null;    //If no such Doctor object is found, the method returns null
    }

    public static Doctor randomlySelectAnotherDoctor(Doctor doctorSelectByCustomer, Date date, Component component ) throws ParseException {
        // static method called randomlySelectAnotherDoctor
        if ( checkDoctorAvailable(doctorSelectByCustomer,date)==null) return doctorSelectByCustomer;
        // checks if the doctorSelectByCustomer object is available at the given date using the checkDoctorAvailable method
        else {
            for (Doctor d : WestminsterSkinConsultationManager.doctors) {
                if (d==null) continue;
                if (d != doctorSelectByCustomer && Objects.equals(d.getSpecialization(), doctorSelectByCustomer.getSpecialization())) {
                    Consultations c = checkDoctorAvailable(d, date);
                    if (c == null) {
                        JOptionPane.showMessageDialog(component, "The doctor is not available at this time.", "Info", JOptionPane.ERROR_MESSAGE);
                        JOptionPane.showConfirmDialog(component, "Added randomly another doctor that specializes category. " +
                                "If you want to change or delete a reservation now can do it.", "Warning", JOptionPane.OK_CANCEL_OPTION);
                        return d;
                    }
                }
            }
        }
        return null;
    }

    public static Consultations checkDoctorAvailable(Doctor doctorSelectByCustomer, Date date) {    //static method called checkDoctorAvailable

        // takes a Doctor object and a Date object as parameters and returns a Consultations object.
        for (Consultations c : Consultations.getConsultations()) {
            // The method searches through the Consultations objects in
            if (doctorSelectByCustomer.equals(c.getDoctor())) {
                if (date.equals(c.getDate())) {
                    return c;
                }
            }
        }
        return null;
    }


    //four public methods of the Doctor class: getMedicalLicenseNumber, setMedicalLicenseNumber, getSpecialization, and setSpecialization
    public String getMedicalLicenseNumber() {
        // return the value of the corresponding instance variable
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        //set the value of the corresponding instance variable to the value passed to them as a parameter
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialization() {
        //  return the value of the corresponding instance variable
        return specialization;
    }

    public void setSpecialization(String specialization) {
        // set the value of the corresponding instance variable to the value passed to them as a parameter
        this.specialization = specialization;
    }



    @Override   //override the toString method of the superclass Person

    public String toString() {  // toString method of the Doctor class
        // returns a string representation of the Doctor object, including the name, date of birth, mobile number, medical license number, and specialization of the doctor
        return "com.company.Doctor{" +
                "Name= " + getName() + " "+getSurname()+" "+
                ",Date Of Birth= " + getDOB() +" "+
                ",Mobile Number= " + getMobileNumber() +" "+
                "Medical LicenseNumber=" + medicalLicenseNumber +
                ", Specialization='" + specialization + '\'' +

                '}';
    }

}
