package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static List<Doctor> doctors = new ArrayList<>(10);

    @Override
    public void addNewDoctor() {
        Scanner scan = new Scanner(System.in);
        if (doctors.size() == 10) {
            System.out.println("Maximum number of doctors have been allocated.");

        } else {
            System.out.println("Please enter the first name: ");
            String firstName = scan.nextLine().toUpperCase();
            while (!Pattern.matches("[a-zA-Z]+", firstName)) {
                System.out.println("Please provide a valid first name: ");
                firstName = scan.nextLine().toUpperCase();
                ///doctor.setName(firstName);
            }

            System.out.println("Please enter the surname: ");
            String surname = scan.nextLine().toUpperCase();

            while (!Pattern.matches("[a-zA-Z]+", surname)) {
                System.out.println("Please provide a valid surname: ");
                surname = scan.nextLine().toUpperCase();
                //////////////////////////////////////////////set
            }
            System.out.println("Please enter the date of birth: ");
            String dateOfBirth = scan.nextLine();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            while (!Pattern.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}", dateOfBirth)) {
                System.out.println("Please provide a valid birth date: ");
                dateOfBirth = scan.nextLine();
            }
            Date date = null;
            try {
                date = simpleDateFormat.parse(dateOfBirth);
            } catch (ParseException p) {
                System.out.println("Please enter in correct format");
            }
            dateOfBirth = simpleDateFormat.format(date);

            System.out.println("Please enter the mobile number: ");
            String mobileNo = scan.nextLine();
            while (!Pattern.matches("[0-9]{10}", mobileNo)) {
                System.out.println("Please enter a valid mobile number: ");
                mobileNo = scan.nextLine();
            }
            System.out.println("Please enter the medical Licence number: ");
            String medicalLicenseNumber = scan.nextLine();

            for (Doctor doctor : doctors) {
                if (doctor.getMedicalLicenseNumber().equals(medicalLicenseNumber)) {
                    System.out.println("This license number belongs to a doctor who already exists. Enter a correct licence number!");
                    System.out.println("Please enter the medical licence number: ");

                    medicalLicenseNumber = scan.nextLine();
                }
            }
            System.out.println("Enter specialisation: ");
            String specialization = scan.nextLine();

            while (!Pattern.matches("[a-zA-Z]+", specialization)) {
                System.out.println("Enter a valid specialization! Enter again:");
                specialization = scan.nextLine().toUpperCase();
            }
            //adding doctors
            doctors.add(new Doctor(firstName, surname, dateOfBirth, mobileNo, medicalLicenseNumber, specialization));
            System.out.println(doctors);
        }
    }
    @Override
    public void deleteDoctor() {
        if (doctors.size() == 0) {
            System.out.println("The centre doesn't have any doctor");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the licence number of the doctor which will be deleted: ");
            String licenceNo = sc.nextLine();

            boolean doc = false; //
            for (Doctor d:doctors){
                if(d.getMedicalLicenseNumber().equals(licenceNo)){
                    System.out.println(d);
                    doctors.remove(d);
                    System.out.println("The information of the doctor has been deleted!");
                    System.out.println("The number of doctors in the centre: "+doctors.size());
                    doc = true;
                    break;
                }
            }
            if (!doc)System.out.println("The doctor with licence number - "+licenceNo+" cannot be found!");
        }
    }
    class sortBySurname implements Comparator<Doctor> {
        @Override
        public int compare(Doctor doc1, Doctor doc2) {
            if (doc1.getSurname().equals(doc2.getSurname())) {
                return doc1.getName().compareTo(doc2.getName());
            }
            return doc1.getSurname().compareTo(doc2.getSurname());
        }
    }
    @Override
    public void displayDoctors() {
        if (doctors.size() == 0) {
            System.out.println("The centre doesn't have any doctor.");
        } else {
            doctors.sort(new sortBySurname());
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("+                                          Doctors Details                                             +");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.printf("+ %-10s | %-10s | %-15s | %-15s | %-15s | %-15s      +%n", "First Name", "Surname", "Date of Birth", "Mobile Number", "Licence Number", "Specialization");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            for (Doctor doctor : doctors) {
                System.out.printf("| %-10s | %-10s | %-15s | %-15s | %-15s | %-15s         %n", doctor.getName(), doctor.getSurname(), doctor.getDOB(), doctor.getMobileNumber(), doctor.getMedicalLicenseNumber(), doctor.getSpecialization());
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void saveInFile() {
        {
            try {
                FileWriter File = new FileWriter("C:\\Users\\HP\\IdeaProjects\\OOP 2nd Year Final\\src\\com\\company\\Doctor Information.txt", false);
                PrintWriter Print = new PrintWriter(File);
                if (doctors.size() == 0) {
                    System.out.println("The centre doesn't have any doctor to save.");
                } else {
                    for (Doctor doctor : doctors) {
                        String docDetails = doctor.getName() + "|" + doctor.getSurname() + "|" + doctor.getDOB() + "|" + doctor.getMobileNumber() + "|" + doctor.getMedicalLicenseNumber() + "|" + doctor.getSpecialization();
                        Print.println(docDetails);
                    }
                    Print.close();
                    System.out.println("Doctor details have been saved.");
                }

            } catch (IOException e) {
                System.out.println("File doesn't exist.");
            }
        }
    }
    public void readInformation(){
        try {
            FileReader Reader = new FileReader("C:\\Users\\HP\\IdeaProjects\\OOP 2nd Year Final\\src\\com\\company\\Doctor Information.txt");
            BufferedReader BufReader = new BufferedReader(Reader);
            String data = BufReader.readLine();
            while (data != null) {

                String[] info = data.split("\\|");
                String firstName = info[0];
                String surname = info[1];
                String dob = info[2];
                String mobileNo = info[3];
                String licenceNo = info[4];
                String specialization = info[5];

                doctors.add(new Doctor(firstName, surname, dob, mobileNo, licenceNo, specialization));
                data = BufReader.readLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("File doesn't exist.");
            throw new RuntimeException(e);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void saveCon(Consultations consultation) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\HP\\IdeaProjects\\OOP 2nd Year Final\\src\\com\\company\\ConsultationDetails.txt", false);
            PrintWriter pw = new PrintWriter(fw);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
            if (Consultations.getConsultations().size() == 0) {
                System.out.println("The centre doesn't have any consultation to save.");
            } else {
                for (Consultations c : Consultations.getConsultations()) {
                    Patient p = c.getPatient();
                    String ConsultationDetails = p.getId() + "|" + p.getName() + "|" + p.getSurname() + "|" + p.getDOB() + "|" + p.getMobileNumber() + "|" + c.getNotes() + "|" + formatter.format(c.getDate()) + "|" + c.getHours() +"|"+c.getDoctor().getName()+"|"+c.getDoctor().getSurname();
                    pw.println(ConsultationDetails);
                }
                pw.close();
                System.out.println("Consultation details have been saved.");
            }
        } catch (IOException e) {
            System.out.println("File doesn't exist.");
        }
    }
    public void readConsultationInformation() {
        try {
            FileReader fr = new FileReader("C:\\Users\\HP\\IdeaProjects\\OOP 2nd Year Final\\src\\com\\company\\ConsultationDetails.txt");
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm");
            while (data != null) {
                String[] info = data.split("\\|");
                String pId = info[0];
                String firstName = info[1];
                String surname = info[2];
                String dob = info[3];
                String mobileNo = info[4];
                String notes = info[5];
                Date date = formatter.parse(info[6]);
                int hours = Integer.parseInt(info[7]);
                String docName = info[8];
                String docSurname = info[9];
                String doctorFullName = docName + " " + docSurname;

                Consultations c;
                Doctor doctor = Doctor.findDoctorByFullName(doctorFullName);
                Patient patient = Patient.isCustomer(firstName, surname);
                if (patient != null) {
                    c = new Consultations(patient, doctor, date, hours, notes);
                } else {
                    c = new Consultations(firstName, surname, dob, mobileNo, notes, date, hours, doctor);
                }
                c.getPatient().setId(pId);
                data = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("File doesn't exist.");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

