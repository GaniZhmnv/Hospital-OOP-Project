import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Stuff> stuffs = new ArrayList<>();
    private static ArrayList<Medicine> medicines = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        patients.add(new Patient(1001, "Ali Yerzhanuly", 18, "A+", "HIV"));
        patients.add(new Patient(1002, "Dana Bogenbay", 30, "B-", "Flu"));
        patients.add(new Patient(1003, "Miras Rinatuly", 18, "B+", "Shizophreny"));

        medicines.add(new Medicine(101, "Paracetamol", 4500, false));
        medicines.add(new Medicine(102, "Zodak", 3000, true));
        medicines.add(new Medicine(103, "Ibuprofen", 4000, false));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewAllPatients();
                case 3 -> addDoctor();
                case 4 -> addNurse();
                case 5 -> viewAllStaff();
                case 6 -> makeAllStaffWork();
                case 7 -> addMedicine();
                case 8 -> viewAllMedicine();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. Add Nurse");
        System.out.println("5. View All Staff");
        System.out.println("6. Make All Staff Work");
        System.out.println("7. Add Medicine");
        System.out.println("8. View All Medicine");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addPatient() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Blood type: ");
        String blood = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        patients.add(new Patient(id, name, age, blood, diagnosis));
    }

    private static void viewAllPatients() {
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static void addDoctor() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Department: ");
        String dep = scanner.nextLine();

        System.out.print("Patients per day: ");
        int patients = scanner.nextInt();
        scanner.nextLine();

        stuffs.add(new Doctor(id, name, spec, exp, salary, dep, patients));
    }

    private static void addNurse() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Shift: ");
        String shift = scanner.nextLine();

        System.out.print("Assisted doctors: ");
        int assisted = scanner.nextInt();
        scanner.nextLine();

        stuffs.add(new Nurse(id, name, spec, exp, salary, shift, assisted));
    }

    private static void viewAllStaff() {
        for (Stuff s : stuffs) {
            System.out.println(s);
        }
    }

    private static void makeAllStaffWork() {
        for (Stuff s : stuffs) {
            s.work();
        }
    }

    private static void addMedicine() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Prescription required (true/false): ");
        boolean req = scanner.nextBoolean();
        scanner.nextLine();

        medicines.add(new Medicine(id, name, price, req));
    }

    private static void viewAllMedicine() {
        for (Medicine m : medicines) {
            System.out.println(m);
        }
    }
}
