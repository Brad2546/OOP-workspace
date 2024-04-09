public class Nurse extends Employee {

    private String patients;

    public Nurse() {
        super();
        setPatients(getUserInput("Patient (e.g.: list of patients under cover)"));
    }

    public Nurse(String employeeNo, String name, String department, String workType, String duties, String patients) {
        super(employeeNo, name, department, workType, duties);
        this.patients = patients;
    }

    public String getPatients() {
        return patients;
    }

    public void setPatients(String specialist) {
        this.patients = specialist;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                super.toString() +
                "patient='" + patients + '\'' +
                '}';
    }
}

