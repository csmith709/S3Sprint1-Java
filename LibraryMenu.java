import java.util.Scanner;

public class LibraryMenu {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        addLibraryItem();

        do {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Add Library Item");
            System.out.println("2. Edit Library Item");
            System.out.println("3. Delete Library Item");
            System.out.println("4. Borrow Library Item");
            System.out.println("5. Return Library Item");
            System.out.println("6. View Available Items");
            System.out.println("7. View Checked-Out Items");
            System.out.println("8. View Items Borrowed by Specific Patron");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addLibraryItem();
                    break;
                case 2:
                    editLibraryItem();
                    break;
                case 3:
                    deleteLibraryItem();
                    break;
                case 4:
                    borrowLibraryItem();
                    break;
                case 5:
                    returnLibraryItem();
                    break;
                case 6:
                    viewAvailableItems();
                    break;
                case 7:
                    viewCheckedOutItems();
                    break;
                case 8:
                    viewItemsBorrowedByPatron();
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 9.");
            }
        } while (choice != 9);

        scanner.close();
    }

    private static void addLibraryItem() {
        System.out.println("Enter the type of Library item (PrintedBook, EBook, AudioBook, PrintedPeriodical, ElectronicPeriodical): ");
        String itemType = scanner.nextLine();

        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter author date of birth: ");
        String authorDob = scanner.nextLine();
        Author author = new Author(authorName, authorDob);

        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter total copies: ");
        int totalCopies = scanner.nextInt();
        System.out.print("Enter available copies: ");
        int availableCopies = scanner.nextInt();
        scanner.nextLine(); // consume newline

        LibraryItem item = null;

        switch (itemType.toLowerCase()) {
            case "printedbook":
                System.out.print("Enter page number: ");
                int pageNumber = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter cover style: ");
                String coverStyle = scanner.nextLine();
                item = new PrintedBook(title, author, ISBN, publisher, totalCopies, availableCopies, null, itemId, pageNumber, coverStyle);
                break;
            case "ebook":
                System.out.print("Enter file size: ");
                int fileSize = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter file format: ");
                String fileFormat = scanner.nextLine();
                item = new EBook(title, author, ISBN, publisher, totalCopies, availableCopies, null, itemId, fileFormat, fileSize);
                break;
            case "audiobook":
                System.out.print("Enter file size: ");
                fileSize = scanner.nextInt();
                scanner.nextLine(); // consume newline
                System.out.print("Enter audio format: ");
                String audioFormat = scanner.nextLine();
                item = new AudioBook(title, author, ISBN, publisher, totalCopies, availableCopies, null, itemId, fileSize, audioFormat);
                break;
            case "printedperiodical":
                System.out.print("Enter cover type: ");
                String coverType = scanner.nextLine();
                item = new PrintedPeriodical(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, Status.AVAILABLE, coverType);
                break;
            case "electronicperiodical":
                System.out.print("Enter file format: ");
                fileFormat = scanner.nextLine();
                item = new ElectronicPeriodical(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, Status.AVAILABLE, fileFormat);
                break;
            default:
                System.out.println("Invalid library item type.");
                return;
        }

        library.addLibraryItem(item);
        author.addWrittenItem(item);
        library.addAuthor(author);

        System.out.println("Library item added successfully.");
    }

    private static void editLibraryItem() {
        System.out.print("Enter the item ID of the library item to edit: ");
        String itemId = scanner.nextLine();
        LibraryItem item = library.getLibraryItem(itemId);

        if (item != null) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            item.setTitle(newTitle);

            System.out.print("Enter new total copies: ");
            int newTotalCopies = scanner.nextInt();
            item.setTotalCopies(newTotalCopies);

            System.out.print("Enter new available copies: ");
            int newAvailableCopies = scanner.nextInt();
            item.setAvailableCopies(newAvailableCopies);

            scanner.nextLine(); // consume newline

            System.out.println("Library item updated successfully.");
        } else {
            System.out.println("Library item not found.");
        }
    }

    private static void deleteLibraryItem() {
        System.out.print("Enter the item ID of the library item to delete: ");
        String itemId = scanner.nextLine();
        LibraryItem item = library.getLibraryItem(itemId);

        if (item != null) {
            library.removeLibraryItem(itemId);
            System.out.println("Library item deleted successfully.");
        } else {
            System.out.println("Library item not found.");
        }
    }

    private static void borrowLibraryItem() {
        System.out.print("Enter the item ID of the library item to borrow: ");
        String itemId = scanner.nextLine();
        LibraryItem item = library.getLibraryItem(itemId);

        if (item != null) {
            System.out.print("Enter your patron ID: ");
            String patronId = scanner.nextLine();
            Patron patron = library.getPatron(patronId);

            if (patron != null) {
                library.checkOut(item, patron);
                System.out.println("Library item borrowed successfully.");
            } else {
                System.out.println("Patron not found.");
            }
        } else {
            System.out.println("Library item not found.");
        }
    }

    private static void returnLibraryItem() {
        System.out.print("Enter the item ID of the library item to return: ");
        String itemId = scanner.nextLine();
        LibraryItem item = library.getLibraryItem(itemId);

        if (item != null) {
            System.out.print("Enter your patron ID: ");
            String patronId = scanner.nextLine();
            Patron patron = library.getPatron(patronId);

            if (patron != null) {
                library.checkIn(item, patron);
                System.out.println("Library item returned successfully.");
            } else {
                System.out.println("Patron not found.");
            }
        } else {
            System.out.println("Library item not found.");
        }
    }

    private static void viewAvailableItems() {
        System.out.println("Available Library Items:");
        for (LibraryItem item : library.getAvailableItems()) {
            System.out.println(item);
        }
    }

    private static void viewCheckedOutItems() {
        System.out.println("Checked-Out Library Items:");
        for (LibraryItem item : library.getCheckedOutItems()) {
            System.out.println(item);
        }
    }

    private static void viewItemsBorrowedByPatron() {
        System.out.print("Enter the patron ID to view borrowed items: ");
        String patronId = scanner.nextLine();
        Patron patron = library.getPatron(patronId);

        if (patron != null) {
            System.out.println("Items borrowed by " + patron.getName() + ":");
            for (LibraryItem item : library.getBorrowedItems(patron)) {
                System.out.println(item);
            }
        } else {
            System.out.println("Patron not found.");
        }
    }
}
