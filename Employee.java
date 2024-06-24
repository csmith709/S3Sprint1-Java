public class Employee extends Patron {
    private String employeeId;

    public Employee(String patronId, String name, String address, String phoneNumber, String employeeId) {
        super(patronId, name, address, phoneNumber); // Pass patronId to the super constructor
        this.employeeId = employeeId;
    }

    // Getter for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    // Setter for employeeId
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // toString method
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", patronId='" + getPatronId() + '\'' + // Include patronId
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
    }
}
