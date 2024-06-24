import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> libraryItems;
    private List<Author> authors;
    private List<Patron> patrons;

    public Library() {
        this.libraryItems = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void removeLibraryItem(String itemId) {
        LibraryItem itemToRemove = null;
        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equals(itemId)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            libraryItems.remove(itemToRemove);
        }
    }

    public LibraryItem getLibraryItem(String itemId) {
        for (LibraryItem item : libraryItems) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null; // Return null if item with given ID is not found
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public boolean checkOut(LibraryItem item, Patron patron) {
        if (libraryItems.contains(item) && item.getStatus() == Status.AVAILABLE) {
            boolean success = item.borrowItem(1);
            if (success) {
                patron.borrowItem(item);
                return true;
            }
        }
        return false;
    }

    public boolean checkIn(LibraryItem item, Patron patron) {
        if (patron.getBorrowedItems().contains(item)) {
            boolean success = item.returnItem(1);
            if (success) {
                patron.returnItem(item);
                return true;
            }
        }
        return false;
    }

    public List<LibraryItem> getBorrowedItems(Patron patron) {
        return patron.getBorrowedItems();
    }

    public List<LibraryItem> getAvailableItems() {
        List<LibraryItem> availableItems = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getStatus() == Status.AVAILABLE) {
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public List<LibraryItem> getCheckedOutItems() {
        List<LibraryItem> checkedOutItems = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getStatus() == Status.CHECKED_OUT) {
                checkedOutItems.add(item);
            }
        }
        return checkedOutItems;
    }

    public List<LibraryItem> getBorrowedItems() {
        List<LibraryItem> borrowedItems = new ArrayList<>();
        for (Patron patron : patrons) {
            borrowedItems.addAll(patron.getBorrowedItems());
        }
        return borrowedItems;
    }

    public List<LibraryItem> getBorrowedItemsByPatron(Patron patron) {
        return patron.getBorrowedItems();
    }

    public Patron getPatron(String patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronId().equals(patronId)) {
                return patron;
            }
        }
        return null; // Return null if patron with given ID is not found
    }
}
