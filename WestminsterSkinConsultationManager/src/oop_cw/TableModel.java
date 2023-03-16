package oop_cw;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Surname", "Mobile No", "Licence No", "Specialization"};
    private ArrayList<Doctor> list;

    public TableModel(ArrayList<Doctor> docList) {
        this.list = docList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getFirstname();
        } else if (columnIndex == 1) {
            temp = list.get(rowIndex).getSurname();
        } else if (columnIndex == 2) {
            temp = list.get(rowIndex).getMobileNumber();
        } else if (columnIndex == 3) {
            temp = list.get(rowIndex).getLicenceNum();
        } else if (columnIndex == 4) {
            temp = list.get(rowIndex).getSpecialization();
        }
        return temp;
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
}
