public class Student extends Patron {
    private int studentId;

    public Student(String patronId, String name, String address, String phoneNumber, int studentId) {
        // Pass patronId to the super constructor
        super(patronId, name, address, phoneNumber);
        this.studentId = studentId;
    }

    // Getter for studentId
    public int getStudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", patronId='" + getPatronId() + '\'' + // Include patronId
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
    }
}
