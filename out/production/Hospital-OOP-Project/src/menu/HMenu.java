package menu;

import database.DoctorDAO;
import exception.InvalidInputException;
import model.Doctor;
import model.Medicine;
import model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HMenu implements Menu {

    private final DoctorDAO doctorDAO = new DoctorDAO();

    private final ArrayList<Patient> patients = new ArrayList<>();
    private final ArrayList<Medicine> medicines = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new HMenu().run();
    }

    public HMenu() {
        patients.add(new Patient(1001, "Ali Yerzhanuly", 18, "A+", "HIV"));
        patients.add(new Patient(1002, "Dana Bogenbay", 30, "B-", "Flu"));
        patients.add(new Patient(1003, "Miras Rinatuly", 18, "B+", "Shizophreny"));

        medicines.add(new Medicine(101, "Paracetamol", 4500, false));
        medicines.add(new Medicine(102, "Zodak", 3000, true));
        medicines.add(new Medicine(103, "Ibuprofen", 4000, false));
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewAllPatients();
                case 3 -> addDoctorToDB();
                case 4 -> viewAllDoctorsFromDB();
                case 5 -> updateDoctorFlow();
                case 6 -> deleteDoctorSafeFlow();
                case 7 -> searchDoctorByNameFlow();
                case 8 -> searchDoctorBySalaryRangeFlow();
                case 9 -> searchDoctorByMinSalaryFlow();


                case 10 -> addMedicine();
                case 11 -> viewAllMedicine();

                case 0 -> running = false;
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addPatient() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Blood type: ");
            String blood = scanner.nextLine();

            System.out.print("Diagnosis: ");
            String diagnosis = scanner.nextLine();

            patients.add(new Patient(id, name, age, blood, diagnosis));
            System.out.println("Patient added ");

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void viewAllPatients() {
        System.out.println("\n--- ALL PATIENTS ---");
        if (patients.isEmpty()) {
            System.out.println("No patients.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
    private void addDoctorToDB() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Specialization: ");
            String spec = scanner.nextLine();

            System.out.print("Experience years: ");
            int exp = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Department: ");
            String dep = scanner.nextLine();

            System.out.print("Patients per day: ");
            int ppd = Integer.parseInt(scanner.nextLine().trim());

            Doctor doctor = new Doctor(0, name, spec, exp, salary, dep, ppd);
            boolean ok = doctorDAO.insertDoctor(doctor);

            System.out.println(ok ? "Doctor inserted " : "Insert failed ");

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void viewAllDoctorsFromDB() {
        List<Doctor> list = doctorDAO.getAllDoctors();

        System.out.println("\n--- ALL DOCTORS FROM DATABASE ---");
        if (list.isEmpty()) {
            System.out.println("No doctors in database.");
            return;
        }

        for (Doctor d : list) {
            System.out.println(d);
            System.out.println("---");
        }
    }

    private void updateDoctorFlow() {
        try {
            System.out.print("Enter Doctor ID to update: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Doctor existing = doctorDAO.getDoctorById(id);
            if (existing == null) {
                System.out.println("No doctor found with ID: " + id);
                return;
            }

            System.out.println("Current info:");
            System.out.println(existing);

            System.out.print("New Name [" + existing.getName() + "]: ");
            String newName = scanner.nextLine();
            if (newName.trim().isEmpty()) newName = existing.getName();

            System.out.print("New Specialization [" + existing.getSpecialization() + "]: ");
            String newSpec = scanner.nextLine();
            if (newSpec.trim().isEmpty()) newSpec = existing.getSpecialization();

            System.out.print("New ExperienceYears [" + existing.getExperienceYears() + "]: ");
            String expIn = scanner.nextLine();
            int newExp = expIn.trim().isEmpty()
                    ? existing.getExperienceYears()
                    : Integer.parseInt(expIn.trim());

            System.out.print("New Salary [" + existing.getSalary() + "]: ");
            String salIn = scanner.nextLine();
            double newSalary = salIn.trim().isEmpty()
                    ? existing.getSalary()
                    : Double.parseDouble(salIn.trim());

            System.out.print("New Department [" + existing.getDepartment() + "]: ");
            String newDep = scanner.nextLine();
            if (newDep.trim().isEmpty()) newDep = existing.getDepartment();

            System.out.print("New Patients/Day [" + existing.getPatientsPerDay() + "]: ");
            String ppdIn = scanner.nextLine();
            int newPpd = ppdIn.trim().isEmpty()
                    ? existing.getPatientsPerDay()
                    : Integer.parseInt(ppdIn.trim());

            Doctor updated = new Doctor(id, newName, newSpec, newExp, newSalary, newDep, newPpd);
            boolean ok = doctorDAO.updateDoctor(updated);

            System.out.println(ok ? "Updated " : "Update failed ");

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void deleteDoctorSafeFlow() {
        try {
            System.out.print("Enter Doctor ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor == null) {
                System.out.println("No doctor found with ID: " + id);
                return;
            }

            System.out.println("Doctor to delete:");
            System.out.println(doctor);

            System.out.print("Are you sure? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                boolean ok = doctorDAO.deleteDoctor(id);
                System.out.println(ok ? "Deleted " : "Delete failed ");
            } else {
                System.out.println("Deletion cancelled ");
            }

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void searchDoctorByNameFlow() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        List<Doctor> list = doctorDAO.searchByName(name);

        System.out.println("Found: " + list.size());
        for (Doctor d : list) {
            System.out.println(d);
            System.out.println("---");
        }
    }

    private void searchDoctorBySalaryRangeFlow() {
        try {
            System.out.print("Min salary: ");
            double min = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Max salary: ");
            double max = Double.parseDouble(scanner.nextLine().trim());

            List<Doctor> list = doctorDAO.searchBySalaryRange(min, max);

            System.out.println("Found: " + list.size());
            for (Doctor d : list) {
                System.out.println(d);
                System.out.println("---");
            }

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void searchDoctorByMinSalaryFlow() {
        try {
            System.out.print("Min salary: ");
            double min = Double.parseDouble(scanner.nextLine().trim());

            List<Doctor> list = doctorDAO.searchByMinSalary(min);

            System.out.println("Found: " + list.size());
            for (Doctor d : list) {
                System.out.println(d);
                System.out.println("---");
            }

        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void addMedicine() {
        try {
            System.out.print("Id: ");
            int medicineId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Price: ");
            int price = Integer.parseInt(scanner.nextLine().trim());

            if (price < 0) {
                throw new InvalidInputException("Price cannot be negative: " + price);
            }

            System.out.print("Is prescription required (true/false): ");
            boolean req = Boolean.parseBoolean(scanner.nextLine().trim());

            medicines.add(new Medicine(medicineId, name, price, req));
            System.out.println("Medicine added ");

        } catch (InvalidInputException e) {
            System.out.println("Warning: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input ");
        }
    }

    private void viewAllMedicine() {
        System.out.println("\n--- ALL MEDICINES ---");
        if (medicines.isEmpty()) {
            System.out.println("No medicines.");
            return;
        }
        for (Medicine m : medicines) {
            System.out.println(m);
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");

        System.out.println("3. Add Doctor ");
        System.out.println("4. View All Doctors ");

        System.out.println("5. Update Doctor      ");
        System.out.println("6. Delete Doctor       ");
        System.out.println("7. Search Doctor by Name   ");
        System.out.println("8. Search by Salary Range  ");
        System.out.println("9. High Paid Doctors  ");

        System.out.println("10. Add Medicine");
        System.out.println("11. View All Medicine");

        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }
}
