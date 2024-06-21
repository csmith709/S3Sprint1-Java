public abstract class Periodical extends LibraryItem{
    //nothing new to initialize

    public Periodical(String itemId, String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status) {
        //inherting
        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
    }

    @Override
    public abstract boolean borrowItem(int numberOfCopies);

    @Override
    public abstract boolean returnItem(int numberOfCopies);
}
