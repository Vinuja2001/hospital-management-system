package oop_cw;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    static ArrayList<Doctor> DoctorList = new ArrayList<Doctor>(5);
    static boolean b = true;
    static WestminsterSkinConsultationManager w1 = new WestminsterSkinConsultationManager();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (b) {
            System.out.println("Enter a number to continue");
            System.out.println("1 : Add doctor");
            System.out.println("2 : Delete doctor");
            System.out.println("3 : View all doctors");
            System.out.println("4 : View GUI");
            System.out.println("5 : Save File");
            System.out.println("6 : Exit");
            System.out.println("Enter a number to continue");
            String option = input.next();
            switch (option) {
                case "1":
                    w1.addDoctor(input);
                    break;
                case "2":
                    w1.deleteDoctor(input);
                    break;
                case "3":
                    w1.viewAll();
                    break;
                case "4":
                    w1.viewGUI();
                    break;
                case "5":
                    saveFile();
                    break;
                case "6":
                    exit();
                    break;
            }
        }
    }

    public void addDoctor(Scanner input) {
        String doc_fname = null;
        String doc_sname = null;
        String doc_dob;
        int doc_mobileNum = 0;
        int doc_licenceNum = 0;
        String doc_specialization = null;
        LocalDate dateOfBirth = null;
        while (b) {
            try {
                System.out.println("Enter first name here : ");
                doc_fname = input.next();
                System.out.println("Enter surname here : ");
                doc_sname = input.next();
                System.out.println("Enter DOB here(YYYY-MM-DD) : ");
                doc_dob = input.next();
                dateOfBirth = dateValidator(doc_dob);
                System.out.println("Enter Licence number here : ");
                doc_licenceNum = input.nextInt();
                System.out.println("Enter Doctor mibile number here : ");
                doc_mobileNum = input.nextInt();
                System.out.println("Enter Doctor specialization here : ");
                doc_specialization = input.next();
                break;
            } catch (Exception e) {
                System.out.println("Enter a valid input");
                return;
            }
        }
        if (DoctorList.size() < 5) {
            DoctorList.add(new Doctor(doc_fname, doc_sname, dateOfBirth, doc_mobileNum, doc_licenceNum, doc_specialization));
            System.out.println("--------------[Doctor added successfully!]--------------");
        } else {
            System.out.println("--------------[Doctor list is full!]--------------");
        }
    }

    public void deleteDoctor(Scanner input) {
        if (DoctorList.isEmpty()) {
            System.out.println("--------------[There no Doctors in the list!]--------------");
        } else {
            System.out.println("Enter the doctor's licence number here : ");
            int rem_licence = input.nextInt();
            for (int x = 0; x < DoctorList.size(); x++) {
                Doctor dl = DoctorList.get(x);
                if (dl.getLicenceNum() == rem_licence) {
                    System.out.println(dl.getFirstname() + " " + dl.getSurname() + " is removing from the list");
                    DoctorList.remove(x);
                    System.out.println("Remove successfull!");
                }
            }
        }
    }

    public void viewAll() {
        if (DoctorList.isEmpty()) {
            System.out.println("--------------[There no Doctors in the list!]--------------");
        } else {
            sortDoc(DoctorList);
            for (Doctor dl : DoctorList) {
                System.out.println("---------------------------------------------");
                System.out.println("Doctor firstname : " + dl.getFirstname());
                System.out.println("Doctor surname : " + dl.getSurname());
                System.out.println("Doctor DOB : " + dl.getDate());
                System.out.println("Doctor licence Number : " + dl.getMobileNumber());
                System.out.println("Doctor mobile number : " + dl.getLicenceNum());
                System.out.println("Doctor Specialization : " + dl.getSpecialization());
                System.out.println("---------------------------------------------");
            }
        }
    }

    public void viewGUI() {
//        GUI gui = new GUI();
        SkinConsultationGUI skinGui = new SkinConsultationGUI(DoctorList);
    }

    private static LocalDate dateValidator(String doc_dob) {
        LocalDate dateOfBirth = LocalDate.parse(doc_dob, DateTimeFormatter.ISO_DATE);
        return dateOfBirth;
    }

    private static void sortDoc(ArrayList<Doctor> DoctorList) {
        DoctorList.sort((o1, o2)
                -> o1.getSurname().compareTo(
                        o2.getSurname()));
    }

    private static void saveFile() {
        try ( FileWriter writer = new FileWriter("oop-doctorList")) {
            for (Doctor dl : DoctorList) {
                writer.write("First Name : " + dl.getFirstname());
                writer.write("Surname : " + dl.getSurname());
                String dr_licence = String.valueOf(dl.getLicenceNum());
                writer.write("Licence No : " + dr_licence);
                writer.write("Specialisation : " + dl.getSpecialization());
                String S_telno = String.valueOf(dl.getMobileNumber());
                writer.write("Mobile-Number : " + S_telno);
                String S_DOB = String.valueOf(dl.getDate());
                writer.write("  Date of Birth (YYYY-MM-DD) : " + S_DOB + "\n");
            }
        } catch (Exception e) {

        }
    }

    private static void exit() {
        System.exit(0);
    }
}
