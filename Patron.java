import java.util.ArrayList;
import java.util.List;

public abstract class Patron {
    private String name;
    private String address;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber, List<LibraryItem> listOfItems) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
 
    publicvoidborrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }
 
    publicvoidreturnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }

}