package oop_cw;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DoctorTable {

    private static String name;
    private static String surname;
    private static String dob;
    private static String id;
    private static Doctor doc;
    private static String dateTime;
    private static String cost;
    private static String mobile;

    Frame frame = new Frame();
    JLabel lbl = new JLabel();
    private JButton jb1 = new JButton("Add Consultation");
    JPanel jp1 = new JPanel();
    TableModel tableModel = new TableModel(WestminsterSkinConsultationManager.DoctorList);

    DoctorTable() {
        jb1.setSize(700, 600);
        JTable docTbl = new JTable(tableModel);
        JScrollPane scPane = new JScrollPane(docTbl);
        jp1.setLayout(new BorderLayout());
        jp1.add(scPane, BorderLayout.NORTH);
        jp1.add(jb1, BorderLayout.SOUTH);
        frame.add(jp1);
        frame.setVisible(true);
    }

}
