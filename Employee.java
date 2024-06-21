public class Employee extends Patron{
    private String employeeId;

    public Employee(String name, String address, String phoneNumber, String employeeId) {
        super(name, address, phoneNumber);
        this.employeeId = employeeId;
    }

    //get
    public String getEmployeeId() {
        return employeeId;
    }

    //set
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    //to String
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
    }
}
