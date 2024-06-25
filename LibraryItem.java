import java.util.List;


public abstract class LibraryItem implements Borrowable {
    private String itemId;
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;
    private Status status;

    public LibraryItem(String itemId, String title, Author author, String ISBN, String publisher,
                       int totalCopies, int availableCopies, Status status) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.status = status;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Status getStatus() {
        return status;
    }

    protected void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public abstract boolean borrowItem(int numberOfCopies);

    @Override
    public abstract boolean returnItem(int numberOfCopies);

    @Override
    public String toString() {
        return "LibraryItem{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", ISBN='" + ISBN + '\'' +
                ", publisher='" + publisher + '\'' +
                ", totalCopies=" + totalCopies +
                ", availableCopies=" + availableCopies +
                ", status=" + status +
                '}';
    }
}
