package oop_cw;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class SkinConsultationGUI extends JFrame {

    static ArrayList<Consultation> arr = new ArrayList<>();

    private static ArrayList<Doctor> docarr = new ArrayList<>();

    private JTable consultTable;
    private JButton addConsultation;
    private JButton showConsultation;

    public SkinConsultationGUI(ArrayList<Doctor> docArr) {
        this.docarr = docArr;

        setLayout(new BorderLayout());

        String[] columnNames = {"Name", "Surname", "Medical License Number", "Mobile No", "Specialization"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        consultTable = new JTable(tableModel);
        for (Doctor doctor : docarr) {
            Object[] rowData = {doctor.getFirstname(), doctor.getSurname(), doctor.getLicenceNum(), doctor.getMobileNumber(), doctor.getSpecialization()};
            tableModel.addRow(rowData);
        }
        add(new JScrollPane(consultTable), BorderLayout.CENTER);
        //setting properties for the GUI
        addConsultation = new JButton("Consultant a doctor");
        addConsultation.addActionListener((ActionEvent ae) -> {
            AddConsultationDialog dialog = new AddConsultationDialog(SkinConsultationGUI.this);
            dialog.setVisible(true);
        });

        add(addConsultation, BorderLayout.SOUTH);

        showConsultation = new JButton("Show Consultations");
        showConsultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showConsultationTable consultationTable = new showConsultationTable();
                consultationTable.setVisible(true);
            }
        }
        );
        add(showConsultation, BorderLayout.NORTH);

        setTitle("View Doctors");
        setSize(600,500);
        setFont(new Font("Calibri", Font.PLAIN, 12));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private static class AddConsultationDialog extends JDialog {

        private JTextField nameField;

        // Text field to enter the patient surname
        private JTextField surnameField;

        // Text field to enter the patient date of birth
        private JTextField dobField;

        // Text field to enter the patient mobile number
        private JTextField mobileNumberField;

        // Text field to enter the patient ID
        private JTextField idField;

        // Combo box to select the doctor for the consultation
        private JComboBox<String> doctorComboBox;

        // Text field to enter the date and time of the consultation
        private JTextField dateTimeField;

        // Text area to enter the notes for the consultation
        private JTextArea notesArea;

        // Button to save the consultation
        private JButton saveButton;

        public AddConsultationDialog(JFrame frame) {

            super(frame, "Add Consultation", true);

            // Set up the layout of the dialog
            setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(5, 5, 5, 5);

            // Add the label and text field for the patient name
            constraints.gridx = 0;
            constraints.gridy = 0;

            add(new JLabel("Name:"), constraints);
            nameField = new JTextField(20);
            constraints.gridx = 1;

            add(nameField, constraints);

            // Add the label and text field for the patient surname
            constraints.gridx = 0;
            constraints.gridy = 1;

            add(new JLabel("Surname:"), constraints);
            surnameField = new JTextField(20);
            constraints.gridx = 1;

            add(surnameField, constraints);

            // Add the label and text field for the patient date of birth
            constraints.gridx = 0;
            constraints.gridy = 2;

            add(new JLabel("Date of Birth (dd/mm/yyyy):"), constraints);
            dobField = new JTextField(20);
            constraints.gridx = 1;

            add(dobField, constraints);

            // Add the label and text field for the patient mobile number
            constraints.gridx = 0;
            constraints.gridy = 3;

            add(new JLabel("Mobile Number:"), constraints);
            mobileNumberField = new JTextField(20);
            constraints.gridx = 1;

            add(mobileNumberField, constraints);
            // Add the label and text field for the patient ID
            constraints.gridx = 0;
            constraints.gridy = 4;

            add(new JLabel("ID:"), constraints);
            idField = new JTextField(20);
            constraints.gridx = 1;

            add(idField, constraints);
            // Add the label and combo box to select the doctor
            constraints.gridx = 0;
            constraints.gridy = 5;

            add(new JLabel("Available Doctors:"), constraints);
            doctorComboBox = new JComboBox<>();

            for (Doctor doctor : docarr) {
                doctorComboBox.addItem(doctor.getFirstname() + " " + doctor.getSurname());
            }
            constraints.gridx = 1;

            add(doctorComboBox, constraints);

            // Add the label and text field for the date and time of the consultation
            constraints.gridx = 0;
            constraints.gridy = 6;

            add(new JLabel("Date and Time (dd/mm/yyyy hh:mm):"), constraints);
            dateTimeField = new JTextField(20);
            constraints.gridx = 1;

            add(dateTimeField, constraints);

            // Add the label and text area for the notes
            constraints.gridx = 0;
            constraints.gridy = 7;

            add(new JLabel("Notes:"), constraints);
            notesArea = new JTextArea(5, 20);

            notesArea.setLineWrap(true);
            constraints.gridx = 1;

            add(new JScrollPane(notesArea), constraints);

            // Add the button to save the consultation
            saveButton = new JButton("Save");

            saveButton.addActionListener((ActionEvent e) -> {
                saveConsultation();
            });
            constraints.gridx = 1;
            constraints.gridy = 8;

            add(saveButton, constraints);

            // Set up the properties of the dialog
            pack();

            setLocationRelativeTo(frame);
        }

        public void saveConsultation() {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String dob = dobField.getText();
            String mobileNumber = mobileNumberField.getText();
            String id = idField.getText();

            // Get the selected doctor from the combo box
            Doctor doctor = getSelectedDoctor();

            // Get the date and time of the consultation from the text field
            String dateTime = dateTimeField.getText();

            // Get the notes for the consultation from the text area
            String notes = notesArea.getText();

            // Calculate the cost of the consultation
            int cost = 15; // First consultation is £15 per hour
            double consultationLength = 0;
            cost = +10 * (int) Math.ceil(1.0 * consultationLength / 60); // Subsequent consultations are £25 per hour

            // Create a new consultation object with the entered information
            Consultation consultation = new Consultation(name, surname, dob, mobileNumber, id, doctor, dateTime, cost);

            // Save the consultation to the system (e.g. to a database, file, etc.)
//            saveConsultation(consultation);
            arr.add(consultation);
            // Close the dialog
            setVisible(true);
        }

        public AddConsultationDialog() {
        }

//        private AddConsultationDialog(SkinConsultationGUI aThis) {
//        }
        private Doctor getSelectedDoctor() {
            int index = doctorComboBox.getSelectedIndex();
            return docarr.get(index);
        }
    }

    private class showConsultationTable extends JFrame {

        public showConsultationTable() {
            setLayout(new BorderLayout());
            DefaultTableModel consul = new DefaultTableModel();
            // Add columns to the model
            consul.addColumn("ID");
            consul.addColumn("First Name");
            consul.addColumn("SurName");
            consul.addColumn("Doctor");
            consul.addColumn("Cost");

            for (Consultation c : arr) {
                consul.addRow(new Object[]{c.getId(), c.getName(), c.getSurname(), c.getDoctor().getFirstname(), c.getCost()});
            }
            JTable table = new JTable(consul);
            JPanel panel = new JPanel();
            add(new JScrollPane(table), BorderLayout.CENTER);
            setTitle("Skin Consultation Centre");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        }
    }
}
