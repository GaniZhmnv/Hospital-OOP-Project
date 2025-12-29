import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        patients.add(new Patient(1, "Ali", 20, "A+"));
        patients.add(new Patient(2, "Dana", 30, "B-"));

        doctors.add(new Doctor(101, "Dr. Smith", "Cardiology", 10));
        doctors.add(new Doctor(102, "Dr. Brown", "Therapy", 5));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllDoctors();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("        HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addPatient() {
        System.out.println("\nADD PATIENT");

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter blood type: ");
        String bloodType = scanner.nextLine();

        Patient patient = new Patient(id, name, age, bloodType);
        patients.add(patient);

        System.out.println("\nPatient added successfully!");
    }

    private static void viewAllPatients() {
        System.out.println("           ALL PATIENTS");

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("Total patients: " + patients.size());
        System.out.println();

        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ". " + patients.get(i));
        }
    }

    private static void addDoctor() {
        System.out.println("\nADD DOCTOR");

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter experience years: ");
        int experience = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization, experience);
        doctors.add(doctor);

        System.out.println("\nDoctor added successfully!");
    }

    private static void viewAllDoctors() {
        System.out.println("            ALL DOCTORS");

        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("Total doctors: " + doctors.size());
        System.out.println();

        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i));
        }
    }
}
