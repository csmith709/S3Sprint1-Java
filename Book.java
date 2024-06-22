public abstract class Book extends LibraryItem{


    public Book(String itemId, String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status) {

        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
    }


    @Override
    public boolean borrowItem(int numberOfCopies) {
        return false;
    }

    public boolean returnItem(int numberOfCopies) {
        return false;
    }

}
