import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String patronId; // Add patronId field
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    // Constructor now includes patronId
    public Patron(String patronId, String name, String address, String phoneNumber) {
        this.patronId = patronId; // Initialize patronId
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public String getPatronId() { // Add getPatronId method
        return patronId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setPatronId(String patronId) { // Add setPatronId method if needed
        this.patronId = patronId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBorrowedItems(List<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "patronId='" + patronId + '\'' + // Include patronId in toString
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedItems=" + borrowedItems.stream()
                    .map(LibraryItem::getTitle) // Assuming LibraryItem has a getTitle() method
                    .toList() +
                '}';
    }
}
