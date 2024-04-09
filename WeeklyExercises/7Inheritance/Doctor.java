public class Doctor extends Employee {

    private String specialist;

    public Doctor() {
        super();
        setSpecialist(getUserInput("Speciality (e.g.: heart doctor)"));
    }

    public Doctor(String employeeNo, String name, String department, String workType, String duties, String specialist) {
        super(employeeNo, name, department, workType, duties);
        this.specialist = specialist;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                super.toString() +
                "specialist='" + specialist + '\'' +
                '}';
    }
}
