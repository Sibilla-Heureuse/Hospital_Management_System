import dao.AppointmentDAO;
import dao.DoctorDAO;
import dao.PatientDAO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        DoctorDAO doctorDAO = new DoctorDAO();
        PatientDAO patientDAO = new PatientDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        while(true){

            System.out.println("\n.............Hospital Management System++++++++++++");
            System.out.println("1 Add Doctor");
            System.out.println("2 Add Patient");
            System.out.println("3 Create Appointment");
            System.out.println("4 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    sc.nextLine();

                    System.out.print("First name: ");
                    String f = sc.nextLine();

                    System.out.print("Last name: ");
                    String l = sc.nextLine();

                    System.out.print("Specialty: ");
                    String s = sc.nextLine();

                    System.out.print("Phone: ");
                    String p = sc.nextLine();

                    System.out.print("Email: ");
                    String e = sc.nextLine();

                    doctorDAO.addDoctor(f,l,s,p,e);

                    break;

                case 2:

                    sc.nextLine();

                    System.out.print("First name: ");
                    String pf = sc.nextLine();

                    System.out.print("Last name: ");
                    String pl = sc.nextLine();

                    System.out.print("DOB yyyy-mm-dd: ");
                    String dob = sc.nextLine();

                    System.out.print("Gender: ");
                    String g = sc.nextLine();

                    System.out.print("Phone: ");
                    String ph = sc.nextLine();

                    System.out.print("Email: ");
                    String em = sc.nextLine();

                    patientDAO.addPatient(pf,pl,dob,g,ph,em);

                    break;

                case 3:

                    System.out.print("Doctor ID: ");
                    int d = sc.nextInt();

                    System.out.print("Patient ID: ");
                    int pa = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Date yyyy-mm-dd hh:mm:ss: ");
                    String date = sc.nextLine();

                    appointmentDAO.createAppointment(d,pa,date,"Scheduled");

                    break;

                case 4:

                    System.exit(0);
            }
        }
    }
}