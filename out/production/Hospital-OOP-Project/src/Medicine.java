public class Medicine {

    private int medicineId;
    private String name;
    private double price;
    private boolean prescriptionRequired;

    public Medicine(int medicineId, String name, double price, boolean prescriptionRequired) {
        setMedicineId(medicineId);
        setName(name);
        setPrice(price);
        setPrescriptionRequired(prescriptionRequired);
    }

    public Medicine() {
        this.medicineId = 100;
        this.name = "Unknown";
        this.price = 1.0;
        this.prescriptionRequired = false;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        if (medicineId >= 100) {
            this.medicineId = medicineId;
        } else {
            System.out.println("Warning: Id cannot be less than 100! Setting to 100.");
            this.medicineId = 100;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Warning: Price cannot be negative or equal to 0! Setting to 1.");
            this.price = 1.0;
        }
    }
        public boolean isPrescriptionRequired () {
            return prescriptionRequired;
        }

        public void setPrescriptionRequired ( boolean prescriptionRequired){
            this.prescriptionRequired = prescriptionRequired;
        }

        public void applyDiscount ( double percentage){
            if (percentage > 0 && percentage <= 100) {
                this.price = this.price * (1 - percentage / 100);
            } else {
                System.out.println("Invalid discount!");
            }
        }

        public boolean isExpensive () {
            return price > 5000;
        }

        @Override
        public String toString () {
            return "Medicine{medicineId=" + medicineId +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", prescriptionRequired=" + prescriptionRequired + '}';
        }
    }
