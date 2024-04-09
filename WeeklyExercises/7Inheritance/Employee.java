import java.util.Scanner;

public class Employee {

    private String employeeNo, name, department, workType, duties;
    private Scanner scan = new Scanner(System.in);

    public Employee() {
        setEmployeeNo(getUserInput("Employee number"));
        setName(getUserInput("Name"));
        setDepartment(getUserInput("Department (area of hospital e.g.: cardiology)"));
        setWorkType(getUserInput("Work Type (job type)"));
        setDuties(getUserInput("Duties (description of job tasks)"));
    }

    public Employee(String employeeNo, String name, String department, String workType, String duties) {
        this.employeeNo = employeeNo;
        this.name = name;
        this.department = department;
        this.workType = workType;
        this.duties = duties;
    }

    public String getUserInput(String inputText) {
        System.out.println("Enter " + inputText + " : ");
        return scan.nextLine();
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    @Override
    public String toString() {
        return "employeeNo='" + employeeNo + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", workType='" + workType + '\'' +
                ", duties='" + duties + "\', ";
    }
}
