public class Patient {

    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;

    public Patient(int patientId, String fullName, int age, String bloodType) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.bloodType = bloodType;
    }

    public Patient() {
        this.patientId = 0;
        this.fullName = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public String getAgeCategory() {
        if (age < 18) {
            return "Child";
        } else if (age < 60) {
            return "Adult";
        } else {
            return "Senior";
        }
    }

    @Override
    public String toString() {
        return "Patient{patientId=" + patientId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", bloodType='" + bloodType + '\'' + '}';
    }
}

