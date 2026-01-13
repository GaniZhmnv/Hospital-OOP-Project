public class Stuff {

    protected int stuffId;
    protected String name;
    protected String specialization;
    protected int experienceYears;
    protected double salary;

    public Stuff(int stuffId, String name, String specialization, int experienceYears, double salary) {
        this.stuffId = stuffId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.salary = salary;
    }

    public Stuff() {
        this.stuffId = 0;
        this.name = "Unknown";
        this.specialization = "General";
        this.experienceYears = 0;
        this.salary = 0;
    }

    public int getStuffId() {
        return stuffId;
    }

    public void setStuffId(int doctorId) {if (doctorId >= 0) {
        this.stuffId = doctorId;
    } else {
        System.out.println("Warning: Id cannot be negative! Setting to 0.");
        this.stuffId = 0;
        }
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

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("Warning: Experience years cannot be negative! Setting to 0.");
            this.experienceYears = 0;
        }
    }
        public void setSalary ( double salary){
            if (salary >= 0) {
                this.salary = experienceYears;
            } else {
                System.out.println("Warning: Salary cannot be negative! Setting to 0.");
                this.salary = 0;
            }
        }

    public double getSalary() { return salary; }
    public boolean isExperienced() {
        return experienceYears >= 10;
    }

    public boolean mildlyExperienced() {
        return experienceYears >= 5;
    }

    public void work() {
        System.out.println(name + " is working.");
    }
    public String getRole() {
        return " Stuff Member";
    }

    @Override
    public String toString() {
        return "Stuff{stuffId=" + stuffId +
                ", name=' " + name + '\'' +
                getRole() +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", salary=" + salary +
                '}';
    }
}
