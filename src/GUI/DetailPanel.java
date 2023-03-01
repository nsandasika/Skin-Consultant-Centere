package GUI;

import com.company.Consultations;
import com.company.Doctor;
import com.company.Patient;
import com.company.WestminsterSkinConsultationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DetailPanel extends JPanel implements ActionListener, ItemListener {
    private JTextField name, surname, mobileNumber, address;
    private TextArea note;
    private JSpinner datePicker, DOB;
    private JButton submit, reset, back;
    private JLabel nameL, surnameL, mobileNumberL, addressL, dateL, numberOfHoursL, doctor, noteL, DOBL;
    private final JFrame container;
    private JComboBox<String> doctorDropDown, hoursDropDown;
    private Consultations updateConsultation;
    private Date date1,date2;

    public DetailPanel(JFrame container){
        this.container = container;
        componentInitialize();
        addDetailsForm();


        doctorDropDown.addItemListener(this);
        back.addActionListener(this);
        reset.addActionListener(this);
        submit.addActionListener(this);
    }

    private void addDetailsForm(){


        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Enter Your Details Here", SwingConstants.CENTER);

        title.setForeground(Color.BLACK);
        title.setFont(new Font("Serif", Font.BOLD, 20));

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;



        constraints.insets = new Insets(20,0,20,0);

        constraints.gridwidth = 4;
        constraints.gridheight =1;

        constraints.gridy =0;
        add(panel, constraints);

        constraints.insets = new Insets(10,30,10,30);
        constraints.gridwidth =1;
        constraints.gridx =0;
        constraints.gridy =1;
        add(doctor, constraints);

        constraints.gridx =1;
        add(doctorDropDown, constraints);

        constraints.gridx =0;
        constraints.gridy =2;
        add(nameL, constraints);

        constraints.gridx =1;
        add(name, constraints);

        constraints.gridx =0;
        constraints.gridy =3;
        add(surnameL, constraints);

        constraints.gridx =1;
        add(surname, constraints);

        constraints.gridx =0;
        constraints.gridy =5;
        add(mobileNumberL, constraints);

        constraints.gridx =1;
        add(mobileNumber, constraints);

        constraints.gridx =0;
        constraints.gridy =6;
        add(DOBL, constraints);

        constraints.gridx =1;
        add(DOB, constraints);

        constraints.gridx =0;
        constraints.gridy =7;
        add(dateL, constraints);

        constraints.gridx =1;
        add(datePicker, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        add(numberOfHoursL, constraints);

        constraints.gridx = 1;
        add(hoursDropDown, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        add(noteL, constraints);

        constraints.gridx = 1;
        add(note, constraints);


        constraints.gridx = 0;
        constraints.gridy = 11;
        add(submit, constraints);

        constraints.gridx = 1;
        add(reset, constraints);

        constraints.insets = new Insets(10,30,30,30);
        constraints.gridwidth = 4;
        constraints.gridx = 0;
        constraints.gridy = 12;
        add(back, constraints);
    }
    private Consultations makeNewAppointment() throws ParseException {
        boolean added=false;
        Consultations c = null;

        String doctorFullName = (String) doctorDropDown.getSelectedItem();
        String patientFirstName = name.getText();
        String patientSurName = surname.getText();

        String mobileNumberString = mobileNumber.getText();
        Date DOB_Date = (Date) DOB.getValue();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dob_Date =formatter.format(DOB_Date);
        Date date = (Date) datePicker.getValue();
        int hours = Integer.parseInt(String.valueOf(hoursDropDown.getSelectedIndex()));

        String notes = note.getText();



        WestminsterSkinConsultationManager manager= new WestminsterSkinConsultationManager();




        assert doctorFullName != null;
        try {
            if (!doctorFullName.equals("None") && mobileNumberString.trim().length()==10) {
                Doctor doctorSelectByCustomer = Doctor.findDoctorByFullName(doctorFullName);
                Doctor selectedDoctor = Doctor.randomlySelectAnotherDoctor(doctorSelectByCustomer, date, this);

                Date date1 = new Date();
                date1 = Consultations.getEndTime(date1, 1);

                if (selectedDoctor != null && hours != 0 && date.compareTo(date1) >= 0 && !patientSurName.equals("") && !patientFirstName.equals("")) {
                    Patient patient = Patient.isCustomer(patientFirstName, patientSurName);
                    if (patient != null) {
                        c = new Consultations(patient, selectedDoctor, date, hours, notes);
                        added = true;
                    } else {
                        c=new Consultations(patientFirstName,patientSurName,dob_Date,mobileNumberString, notes,date,hours,selectedDoctor);
                    }
                }

                else if (patientSurName.equals("") || patientFirstName.equals("")) {
                    JOptionPane.showConfirmDialog(this, "Required fields are empty", "Warning", JOptionPane.OK_CANCEL_OPTION);
                }
                else if (date.before(date1)) {
                    JOptionPane.showConfirmDialog(this, "Reservation should be made at least an hour from now.", "Warning", JOptionPane.OK_CANCEL_OPTION);
                }
                else if (hours == 0) {
                    JOptionPane.showConfirmDialog(this, "Please select hours you booking", "Warning", JOptionPane.OK_CANCEL_OPTION);
                }
                else {
                    JOptionPane.showConfirmDialog(this, "All doctors in that specialization category are reserved for that time range. Please select another time", "Warning", JOptionPane.OK_CANCEL_OPTION);
                }
                if (added) {
                    assert c != null;
                    System.out.println(c.getPatient().toString() + "\n" + c.getDoctor().toString() + "\n" +
                            "Date :" + c.getDate() + "\n" +
                            "Patient ID :" + c.getPatient().getId() + "\n" +
                            //"Cost :" + c.getCost() + "\n" +
                            "Note :" + c.getNotes() + "\n\n");
                }
            } else if (mobileNumberString.trim().length()!=10) {
                JOptionPane.showConfirmDialog(this, "Please enter correct mobile number", "Warning", JOptionPane.OK_CANCEL_OPTION);
            } else
                JOptionPane.showConfirmDialog(this, "Please select a doctor", "Warning", JOptionPane.OK_CANCEL_OPTION);
        }catch (NumberFormatException e){
            JOptionPane.showConfirmDialog(this, "Please enter correct mobile number", "Warning", JOptionPane.OK_CANCEL_OPTION);
        }

        return c;
    }
    public void setAppointmentDetails(Consultations c) {
        doctorDropDown.setSelectedItem(c.getDoctor().getName()+" "+c.getDoctor().getSurname());
        name.setText(c.getPatient().getName());
        surname.setText(c.getPatient().getSurname());
        mobileNumber.setText(c.getPatient().getMobileNumber());
        //DOB.setValue(c.getPatient().getDateOfBirth(true));
        datePicker.setValue(c.getDate());
        hoursDropDown.setSelectedIndex(c.getHours());
        note.setText(c.getNotes());
    }
    public void setUpdateConsultation(Consultations updateConsultation) {
        this.updateConsultation = updateConsultation;
    }
    private void resetAllInputField(){
        date2 = new Date();
        date1 = new Date();
        JSpinner.DateEditor de1 = new JSpinner.DateEditor(datePicker, "  yyyy : MM : dd || hh:mm a  ");
        doctorDropDown.setSelectedItem("None");
        name.setText("");
        surname.setText("");
        address.setText("");
        mobileNumber.setText("");
        DOB.setValue(new Date());
        datePicker.setValue(new Date());
        hoursDropDown.setSelectedIndex(0);
        note.setText("");
    }
    private void componentInitialize() {

        date1 = new Date();
        SpinnerDateModel sm1 = new SpinnerDateModel(date1, null, null, Calendar.DAY_OF_YEAR);
        datePicker = new JSpinner(sm1);
        JSpinner.DateEditor de1 = new JSpinner.DateEditor(datePicker, "  yyyy : MM : dd || hh:mm a  ");
        datePicker.setEditor(de1);

        date2 = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.DAY_OF_YEAR);
        DOB = new JSpinner(sm2);
        JSpinner.DateEditor de2 = new JSpinner.DateEditor(DOB, "  yyyy : MM : dd  ");
        DOB.setEditor(de2);

        String[] doctorList = new String[WestminsterSkinConsultationManager.doctors.size()+1];

        Doctor[] d = WestminsterSkinConsultationManager.doctors.toArray(new Doctor[0]);
        doctorList[0] = "None";
        for (int i=0;i< d.length;i++) {
            if (d[i] !=null) doctorList[i+1] = d[i].getName()+" "+d[i].getSurname();
        }
        doctorDropDown = new JComboBox<>(doctorList);

        String[] hour = new String[]{"0","1","2","3","4","5","6","7","8","9","10",};
        hoursDropDown = new JComboBox<>(hour);

        name = new JTextField(10);
        surname = new JTextField(10);
        mobileNumber = new JTextField(10);
        address = new JTextField(10);
        note = new TextArea(3,2);
        nameL = new JLabel(         "First Name     :", SwingConstants.LEFT);
        surnameL = new JLabel(      "Surname        :", SwingConstants.LEFT);
        mobileNumberL = new JLabel( "Mobile Number  :", SwingConstants.LEFT);
        dateL = new JLabel(         "Booking date and time:", SwingConstants.LEFT);
        DOBL = new JLabel(         "Date of Birth  :", SwingConstants.LEFT);
        submit = new JButton("Submit");
        reset = new JButton("Reset");
        back = new JButton("Back");
        doctor = new JLabel(        "Doctor         :");
        noteL = new JLabel(         "Notes about Patient    :");
        numberOfHoursL = new JLabel("Reservation period :");

        submit.setBackground(Color.cyan.darker());
        reset.setBackground(Color.red);
        back.setBackground(Color.magenta.darker());
        submit.setForeground(Color.WHITE);
        reset.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);

        nameL.setForeground(Color.BLACK);
        surnameL.setForeground(Color.BLACK);
        mobileNumberL.setForeground(Color.BLACK);
        dateL.setForeground(Color.BLACK);
        DOBL.setForeground(Color.BLACK);
        numberOfHoursL.setForeground(Color.BLACK);
        doctor.setForeground(Color.BLACK);
        noteL.setForeground(Color.BLACK);
        nameL.setFont(new Font("Serif", Font.BOLD , 12));
        DOBL.setFont(new Font("Serif", Font.BOLD, 12));
        surnameL.setFont(new Font("Serif", Font.BOLD, 12));
        mobileNumberL.setFont(new Font("Serif", Font.BOLD, 12));
        noteL.setFont(new Font("Serif", Font.BOLD, 12));

        AppointmentDetails.fontInitializer(surnameL, mobileNumberL, noteL, addressL, 12);
        sameInitializing(dateL, numberOfHoursL, doctor);
    }
    static void sameInitializing(JLabel dateL, JLabel numberOfHoursL, JLabel doctor) {
        dateL.setFont(new Font("Serif", Font.BOLD , 12));
        numberOfHoursL.setFont(new Font("Serif", Font.BOLD , 12));
        doctor.setFont(new Font("Serif", Font.BOLD , 12));


        UIManager.put("OptionPane.background", Color.lightGray);
        UIManager.put("Panel.background", Color.lightGray);
        UIManager.put("Panel.setForeground", Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();

        if (e.getSource()==submit) {
            try {
                Consultations c = makeNewAppointment();
                manager.saveCon(c);
                if (c!=null) {
                    JOptionPane.showMessageDialog(this, "Consultation was booked. Remember the ID to view consultation. ID: "+c.getPatient().getId(), "Warning", JOptionPane.WARNING_MESSAGE);
                    container.dispose();
                    try {
                        new MainGUI();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    //new AppointmentDetail(c);
                }
                else {
                    JOptionPane.showMessageDialog(this, "No reservation was made", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }

        }else if (e.getSource()==back){
            System.out.println("Back clicked");
            container.dispose();
            try {
                new MainGUI();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==reset) {
            resetAllInputField();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource()==doctorDropDown){
            String item  = String.valueOf(doctorDropDown.getSelectedItem());
            if (item.trim().equals("None")) {
                ArrayList<Consultations> c = Consultations.getConsultations();
//                c.sort(new AlphabeticComparatorUser());
//                userTableModel.setMyList(Consultation.getConsultations());
//                userTableModel.fireTableDataChanged();
            }else {

                //Doctor[] d = WestminsterSkinConsultationManager.doctors;
                ArrayList<Consultations> consultations = new ArrayList<>();
                boolean haveConsultations = false;

                for (Consultations selectedDoctorObject : Consultations.getConsultations()) {
                    String text = selectedDoctorObject.getDoctor().getName() + " " +
                            selectedDoctorObject.getDoctor().getSurname();
                    if ((item).equals(text)) {
                        if (text.equals(item.trim())) {
                            consultations.add(selectedDoctorObject);
                            haveConsultations = true;
                        }
                    }
                }
//                consultations.sort(new AlphabeticComparatorUser());
//                if (haveConsultations) {
//                    userTableModel.setMyList(consultations);
//                }else {
//                    userTableModel.setMyList(consultations);
//                }
//                userTableModel.fireTableDataChanged();
            }

        }

    }
}
