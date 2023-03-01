package com.company;
import GUI.MainGUI; //Imports the class 'MainGUI' from the package 'GUI'.


import java.io.IOException; //Import the 'IOException' class from the 'java.io' package
import java.util.Scanner;   //import the 'Scanner' class from the 'java.util' package

public class Main {     // Declares public class called 'Main'.
    public static void main(String[] args) throws IOException { //The throws IOException clause indicates that the main method may throw an IOException if an input or output error occurs.
        Scanner scan = new Scanner(System.in);  //Creates new 'Scanner' object called 'scan' .
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();  //Creates a new object of the class 'WestminsterSkinConsultationManager' called 'manager'.
        manager.readInformation();  //Calls the 'readInformation' method on the 'manager' object.
        manager.readConsultationInformation();  //Calls the 'readConsultationInformation' method on the 'manager' object.
        while (true){   //Starts an infinite loop will continue until the program is terminated.
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"); //Print Menu options.
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("                     Select an option from the given menu                   ");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("     1. Add a Doctor                                                      ");
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("     2. Delete a Doctor                                                   ");
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("     3. Display list of Doctors                                           ");
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("     4. Save data to the file                                             ");
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("     5. Open GUI                                                          ");
            System.out.println(" ------------------------------------------------------------------------ ");
            System.out.println("     6. Exit                                                              ");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

            System.out.print("Enter your selection :"); //
            String choice = scan.next();    //Read the user's input using the scan object.
            switch (choice){    //'switch' statement that will execute different code blocks based on the value of the 'choice' variable.

                case "1" :
                    manager.addNewDoctor(); //If the value of 'choice' is "1", the 'addNewDoctor' method is called on the 'manager' object.
                    break;
                case "2" :
                    manager.deleteDoctor(); //If the value of 'choice' is "2", the 'deleteDoctor' method is called on the 'manager' object.
                    break;
                case "3" :
                    manager.displayDoctors();   //If the value of 'choice' is "3", the 'displayDoctors' method is called on the 'manager' object.
                    break;
                case "4" :
                    manager.saveInFile();   //If the value of 'choice' is "4", the 'saveInFile' method is called on the 'manager' object.
                    break;
                case "5" :
                    new MainGUI();  //f the value of 'choice' is "5", a new MainGUI object is created.
                    break;
                case "6" :
                    System.exit(0); //If the value of 'choice' is "6", the program terminates.
                    break;
                default :
                    System.out.println("Invalid input. Try again!\n");  //If the value of 'choice' is none of these options, an error message is printed to the command line.

            }
        }
    }
}
