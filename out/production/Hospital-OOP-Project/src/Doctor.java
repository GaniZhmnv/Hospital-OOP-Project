public class Doctor extends Stuff {
    private String department;
    private int patientsPerDay;

    public Doctor(int stuffId, String name, String specialization,
                  int experienceYears, double salary,
                  String department, int patientsPerDay) {

        super(stuffId, name, specialization, experienceYears, salary);
        this.department = department;
        this.patientsPerDay = patientsPerDay;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        }
    }

    public int getPatientsPerDay() {
        return patientsPerDay;
    }

    public void setPatientsPerDay(int patientsPerDay) {
        if (patientsPerDay >= 0) {
            this.patientsPerDay = patientsPerDay;
        }
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name +
                " is treating patients in " + department + " department.");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }


    public void treatPatient(String patientName) {
        System.out.println("Doctor " + name +
                " is treating patient: " + patientName);
    }

    public boolean isSeniorDoctor() {
        return experienceYears >= 15;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", department='" + department + '\'' +
                ", patientsPerDay=" + patientsPerDay +
                '}';
    }
}
