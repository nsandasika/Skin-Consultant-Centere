package com.company;

import java.text.ParseException;    //An error in the format of a string being parsed will result in a checked exception being thrown.
import java.text.SimpleDateFormat;  //a concrete class for locale-sensitive date formatting and parsing.
import java.util.ArrayList; //a List interface implementation using a resizable array.
import java.util.Calendar;  //An abstract base class for converting between a Date object and a set of integer fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR
import java.util.Date;  //A class representing a specific instant in time

public class Consultations {    //Declares a public class called 'Consultations'.

    private Date Date;  //The 'Date' field is of type 'Date'.
    private String Time;    //The 'Time' field is of type 'String'.
    private int cost;   //the 'cost' field is of type 'int'.
    private String notes;   //The 'notes' field is of type 'String'.
    private Patient patient;    //the 'patient' field is of type 'Patient'.
    private Doctor doctor;  //the 'doctor' field is of type 'Doctor'.
    private static final ArrayList<Consultations> consultations = new ArrayList<>();    //The 'consultations' field is an 'ArrayList' of 'Consultations' objects and is declared as 'static' and 'final'.

    public Consultations(Patient Patient, Doctor selectedDoctor, Date date, int hours, String notes) {  //Declares a constructor for the 'Consultations'.
        // Takes five arguments called a 'Patient' object, a 'Doctor' object, a 'Date' object, an 'int', and a 'String'.
        // The constructor initializes the 'patient', 'doctor', 'Date', 'hours', and 'notes' fields with the corresponding arguments.
        this.patient = Patient;
        this.doctor = selectedDoctor;
        this.Date = date;
        this.hours = hours;
        this.notes = notes;
        // //  Calls the 'setNotes' method and adds the 'Consultations' object to the 'consultations'.
        setNotes(notes);
        this.cost = (25 * hours);   // Sets the 'cost' field to '25 * hours'.
        consultations.add(this);
        System.out.println(this.cost + " " + hours);    //Finally it prints the 'cost' and 'hours' to the command line.


    }

    public Consultations(String firstName, String lastName, String DOB, String mobileNumber, String notes, Date date, int hours, Doctor doctor) {   // Declares a second constructor for the 'Consultations'.
        this.cost = (15 * hours);   // The constructor initializes the 'cost' field to '15 * hours'.
        this.Date = date;   // The 'Date' field to the 'date' argument.
        this.doctor = doctor;   // The 'doctor' field to the 'doctor' argument.
        this.patient = new Patient(firstName, lastName, DOB, mobileNumber); //The 'patient' field to a new 'Patient' object constructed with the 'firstName', 'lastName', 'DOB', and 'mobileNumber' arguments.
        this.hours = hours; // Initializes the 'hours' field to the 'hours' argument.
        setNotes(notes);    // Calls the setNotes method.
        consultations.add(this);    // Adds the 'Consultations' object to the 'consultations' list.
        System.out.println(this.cost + " " + hours);    //prints the 'cost' and 'hours' to the command line.
    }

    // Declares a getEndTime method that takes a Date object and an int as arguments and returns a Date object.
    public static Date getEndTime(Date date, int hours) throws ParseException {
        // The method uses a 'SimpleDateFormat' object to parse the 'date' argument.
        SimpleDateFormat parser = new SimpleDateFormat("dd:HH:mm");
        Date myDate = parser.parse(parser.format(date));
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        // Adds the number of 'hours' to the parsed 'Date' using a 'Calendar' object.
        cal.add(Calendar.HOUR_OF_DAY, hours);
        return cal.getTime();   // Returns the modified 'Date'.

    }



    public int getHours() { // Declare a 'getHours' method  the Consultations class.
        return hours;   // Returns the value of the 'hours' field
    }

    public void setHours(String hours) {    // Declare a 'setHours' method  the Consultations class.
        // Sets the value of the 'hours' field to the 'hours' argument if it is not an empty string, or to null if it is an empty string.
        if (notes.equals("")) this.notes = null;
        else this.notes = notes;
    }

    private int hours;  // Declares a private 'hours' field for the 'Consultations' class.


    public static ArrayList<Consultations> getConsultations() {
    // Declares a 'getConsultations' method that returns the 'consultations' list.
        return consultations;
    }

    // Declare a getDate method and a setDate method for the Consultations class.
    // The getDate method returns the value of the Date field.
    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        // The setDate method sets the value of the Date field to the date argument.
        Date = date;
    }
    // Declare a 'getTime' method and a 'setTime' method for the 'Consultations' class.
    // The getTime method returns the value of the Time field
    public String getTime() {
        return Time;
    }

    // The setTime method sets the value of the Time field to the time argument.
    public void setTime(String time) {
        Time = time;
    }

    // Declare a getPatient method and a setPatient method for the Consultations class.
    // The getPatient method returns the value of the patient field
    public Patient getPatient() {
        return patient;
    }

    // The setPatient method sets the value of the patient field to the patient argument.
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    // Declare a getDoctor method and a setDoctor method for the Consultations class
    // The getDoctor method returns the value of the doctor field
    public Doctor getDoctor() {
        return doctor;
    }

    // The setDoctor method sets the value of the doctor field to the doctor argument.
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    //  Declare a getNotes method and a setNotes method for the Consultations class
    // The getNotes method returns the value of the notes field
    public String getNotes() {
        return notes;
    }

    // The setNotes method sets the value of the notes field to the notes argument if it is not an empty string, or to null if it is an empty string.
    public void setNotes(String notes) {

        if (notes.equals("")) this.notes = null;
        else this.notes = notes;
    }

    // Declares a getCost method for the Consultations class that returns the value of the cost field.
    public double getCost() {
        return cost;
    }

    // Overrides the toString method inherited from the Object class.
    @Override
    public String toString() {
        // Returns this string
        return "Consultation{" +
                "Date='" + Date + '\'' +
                ", Cost='" + cost + '\'' +
                ", Notes='" + notes + '\'' +
                ", Patient=" + patient +
                ", Doctor=" + doctor +

                '}';
    }
}
