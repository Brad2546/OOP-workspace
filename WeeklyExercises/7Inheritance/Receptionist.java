public class Receptionist extends Employee{

    private String phoneNumber;

    public Receptionist() {
        super();
        setPhoneNumber(getUserInput("Phone Number"));
    }

    public Receptionist(String employeeNo, String name, String department, String workType, String duties, String phoneNumber) {
        super(employeeNo, name, department, workType, duties);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String specialist) {
        this.phoneNumber = specialist;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                super.toString() +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


