package model;

public class Nurse extends Stuff {

    private String shift;
    private int assistedDoctors;

    public Nurse(int stuffId, String name, String specialization,
                 int experienceYears, double salary,
                 String shift, int assistedDoctors) {

        super(stuffId, name, specialization, experienceYears, salary);
        this.shift = shift;
        this.assistedDoctors = assistedDoctors;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        if (shift != null && !shift.trim().isEmpty()) {
            this.shift = shift;
        }
    }

    public int getAssistedDoctors() {
        return assistedDoctors;
    }

    public void setAssistedDoctors(int assistedDoctors) {
        if (assistedDoctors >= 0) {
            this.assistedDoctors = assistedDoctors;
        } else {
            System.out.println("Warning. This number can't be negative! Setting to zero");
                    this.assistedDoctors = 0;
        }
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name +
                " is assisting doctors during " + shift + " shift.");
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public void assistDoctor(String doctorName) {
        System.out.println("Nurse " + name +
                " is assisting Doctor " + doctorName);
        assistedDoctors++;
    }

    public boolean isHeadNurse() {
        return experienceYears >= 10 && assistedDoctors >= 20;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", shift='" + shift + '\'' +
                ", assistedDoctors=" + assistedDoctors +
                '}';
    }
}
