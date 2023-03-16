package oop_cw;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class Consultation {

//    Frame frame = new Frame();
//    JLabel lbl = new JLabel();
//    private JButton jb1 = new JButton("Add Consultation");
//    JPanel jp1 = new JPanel();
//    TableModel tableModel = new TableModel(WestminsterSkinConsultationManager.DoctorList);
//
//    public Consultation() {
//        jb1.setSize(100, 600);
//        JTable docTbl = new JTable(tableModel);
//        JScrollPane scPane = new JScrollPane(docTbl);
//        jp1.setLayout(new BorderLayout());
//        jp1.add(scPane, BorderLayout.NORTH);
//        jp1.add(jb1, BorderLayout.SOUTH);
//        frame.add(jp1);
//        frame.setVisible(true);
//    }
    private String name;
    private String surname;
    private String dob;
    private String mobileNumber;
    private String id;
    private Doctor doctor;
    private String dateTime;
    private int cost;

    Consultation(String name, String surname, String dob, String mobileNumber, String id, Doctor doctor, String dateTime, int cost) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.mobileNumber = mobileNumber;
        this.id = id;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getCost() {
        return cost;
    }
}
