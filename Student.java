

public class Student extends Patron{
    private int studentId;

    public Student(String name, String address, String phoneNumber, int studentId) {
        //super calls from Patron
        super(name, address, phoneNumber);
        this.studentId = studentId;
    }

    //get
    public int getStudentId() {
        return studentId;
    }

    //set
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //to string
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", borrowedItems=" + getBorrowedItems() +
                '}';
}
}