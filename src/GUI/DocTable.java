package GUI;


import com.company.Doctor;
import com.company.WestminsterSkinConsultationManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DocTable  extends AbstractTableModel {

    private final String[] columnNames = { "Name", "Medical Licence", "Specialisation"};
    private ArrayList<Doctor> myList = new ArrayList<>();

    public DocTable() {
        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
            if (WestminsterSkinConsultationManager.doctors.get(i) !=null){
                myList.add(WestminsterSkinConsultationManager.doctors.get(i));
            }
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return myList.size();
    }

    public Object getValueAt(int row, int col) {
        Object temp = null;

        if (col == 0) {
            temp = " "+myList.get(row).getName()+" "+myList.get(row).getSurname();
        }
        else if (col == 1) {
            temp = myList.get(row).getMedicalLicenseNumber();
        }
        else if (col == 2) {
            temp = myList.get(row).getSpecialization();
        }

        return temp;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        return String.class;
    }

    public ArrayList<Doctor> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Doctor> myList) {
        this.myList = myList;
    }


}

