package com.company;

// interface called SkinConsultationManager
public interface SkinConsultationManager {



    //methods>>> addNewDoctor, deleteDoctor, displayDoctors, saveInFile, and saveCon.
    // The saveCon method takes a Consultations object as a parameter
    void addNewDoctor();
    void deleteDoctor();
    void displayDoctors();
    void saveInFile();
    void saveCon(Consultations c);
}

