public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private int experienceYears;

    public Doctor(int doctorId, String name, String specialization, int experienceYears) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    public Doctor() {
        this.doctorId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {if (doctorId >= 0) {
        this.doctorId = doctorId;
    } else {
        System.out.println("Warning: Id cannot be negative! Setting to 0.");
        this.doctorId = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Warning: Specialization cannot be empty!");
        }
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("Warning: Experience years cannot be negative! Setting to 0.");
            this.experienceYears = 0;
    }

    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    public boolean canPerformSurgery() {
        return experienceYears >= 5;
    }

    @Override
    public String toString() {
        return "Doctor{doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears + '}';
    }
}
