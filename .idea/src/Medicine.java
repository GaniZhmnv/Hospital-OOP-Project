public class Medicine {

    private int medicineId;
    private String name;
    private double price;
    private boolean prescriptionRequired;

    public Medicine(int medicineId, String name, double price, boolean prescriptionRequired) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.prescriptionRequired = prescriptionRequired;
    }

    public Medicine() {
        this.medicineId = 0;
        this.name = "Unknown";
        this.price = 0.0;
        this.prescriptionRequired = false;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public void applyDiscount(double percentage) {
        price = price * (1 - percentage / 100);
    }

    public boolean isExpensive() {
        return price > 5000;
    }

    @Override
    public String toString() {
        return "Medicine{medicineId=" + medicineId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", prescriptionRequired=" + prescriptionRequired + '}';
    }
}
