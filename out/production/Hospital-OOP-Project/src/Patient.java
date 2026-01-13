public class Patient {

    private int patientId;
    private String fullName;
    private int age;
    private String bloodType;
    private String diagnosis;

    public Patient(int patientId, String fullName, int age, String bloodType, String diagnosis) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.bloodType = bloodType;
        this.diagnosis = diagnosis;
    }

    public Patient() {
        this.patientId = 1000;
        this.fullName = "Unknown";
        this.age = 0;
        this.bloodType = "Unknown";
        this.diagnosis = "Unknown";
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {if (diagnosis != null && !diagnosis.trim().isEmpty()) {
        this.diagnosis = diagnosis;
    } else {
        System.out.println("Warning: Diagnosis cannot be empty!");
    }
    }

    public void setPatientId(int patientId) {if (patientId >= 1000) {
        this.patientId = patientId;
    } else {
        System.out.println("Warning: Id cannot be less than 1000! Setting to 1000.");
        this.patientId = 1000;}
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {if (fullName != null && !fullName.trim().isEmpty()) {
        this.fullName = fullName;
    } else {
        System.out.println("Warning: Full name cannot be empty!");
    }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {if (age >= 0) {
        this.age = age;
    } else {
        System.out.println("Warning: Age cannot be negative! Setting to 0.");
        this.age = 0;
    }
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        if (bloodType.equals("A+") || bloodType.equals("A-") ||
                bloodType.equals("B+") || bloodType.equals("B-") ||
                bloodType.equals("O+") || bloodType.equals("O-") ||
                bloodType.equals("AB+") || bloodType.equals("AB-")) {

            this.bloodType = bloodType;
        } else {
            System.out.println("Warning: Blood type is invalid!");
        }
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
            return "Patient{" +
                    "patientId=" + patientId +
                    ", fullName='" + fullName + '\'' +
                    ", age=" + age +
                    ", bloodType='" + bloodType + '\'' +
                    ", diagnosis='" + diagnosis + '\'' +  '}';
    }
}

