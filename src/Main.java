public class Main {

    public static void main(String[] args) {

        System.out.println("=== Hospital Management System ===\n");

        Medicine med1 = new Medicine(101, "Paracetamol", 1200, false);
        Medicine med2 = new Medicine(102, "Insulin", 8500, true);
        Medicine med3 = new Medicine();

        Doctor doc1 = new Doctor(1, "Dr. Ivanov", "Cardiology", 12);
        Doctor doc2 = new Doctor(2, "Dr. Smith", "Surgery", 4);

        Patient pat1 = new Patient(1001, "Alex Brown", 16, "O+");
        Patient pat2 = new Patient(1002, "Maria Green", 45, "A-");

        System.out.println("--- MEDICINES ---");
        System.out.println(med1);
        System.out.println(med2);
        System.out.println(med3);

        System.out.println("\n--- DOCTORS ---");
        System.out.println(doc1);
        System.out.println(doc2);

        System.out.println("\n--- PATIENTS ---");
        System.out.println(pat1);
        System.out.println(pat2);

        System.out.println("\n--- TESTING METHODS ---");
        System.out.println(med2.getName() + " expensive: " + med2.isExpensive());
        med2.applyDiscount(10);
        System.out.println("New price: " + med2.getPrice());

        System.out.println(doc1.getName() + " experienced: " + doc1.isExperienced());
        System.out.println(doc2.getName() + " can perform surgery: " + doc2.canPerformSurgery());

        System.out.println(pat1.getFullName() + " minor: " + pat1.isMinor());
        System.out.println(pat2.getFullName() + " age category: " + pat2.getAgeCategory());

        System.out.println("\n=== Program Complete ===");
    }
}
