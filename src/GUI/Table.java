package GUI;



import com.company.Consultations;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractTableModel {

    private final String[] columnNames = {"Patient ID","First Name", "Surname","Mobile No","Date Of Birth","Booking Date n Time","Doctor name","Doctor Specialization","Cost","Notes"};
    private List<Consultations> arrayList = new ArrayList<>();

    public Table(List<Consultations> consultationList){
        arrayList =consultationList;
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String pattern = "MM/dd/yyyy  HH:mm a";
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Object temp = null;
        if (columnIndex == 0) {
            temp = arrayList.get(rowIndex).getPatient().getId();
        }
        else if (columnIndex == 1) {
            temp = arrayList.get(rowIndex).getPatient().getName();
        }
        else if (columnIndex == 2) {
            temp = arrayList.get(rowIndex).getPatient().getSurname();
        }
        else if (columnIndex == 3) {
            temp = arrayList.get(rowIndex).getPatient().getMobileNumber();
        }
        else if (columnIndex == 4) {
            temp = arrayList.get(rowIndex).getPatient().getDOB();
        }
        else if (columnIndex == 5) {
            temp = dateFormat.format(arrayList.get(rowIndex).getDate());
        }
        else if (columnIndex == 6) {
            temp = arrayList.get(rowIndex).getDoctor().getName()+" "+ arrayList.get(rowIndex).getDoctor().getSurname();
        }
        else if (columnIndex == 7) {
            temp = arrayList.get(rowIndex).getDoctor().getSpecialization();
        }
        else if (columnIndex == 8) {
            temp = arrayList.get(rowIndex).getCost();
        }
        else if (columnIndex == 9) {
            temp = arrayList.get(rowIndex).getNotes();
        }
        return temp;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Class getColumnClass(int col) {
        return String.class;
    }

    public List<Consultations> getlist() {
        return arrayList;
    }

    public void setlist(List<Consultations> mylist) {
        this.arrayList = mylist;
    }
}