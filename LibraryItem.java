import java.util.List;

public abstract class LibraryItem implements Borrowable{
    private String itemId;
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int totalCopies;
    private int availableCopies;
    private Status status;

    public LibraryItem(String itemId, String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status) {
    this.itemId = itemId;
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
    this.publisher = publisher;
    this.totalCopies = totalCopies;
    this.availableCopies = availableCopies;
    this.status = status;
}

//get and set
//get

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
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

    public int getAvailableCopies() {
        return availableCopies;
    }

    public Status getStatus() {
        return status;
    }

    //set
    protected void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    protected void setStatus(Status status) {
        this.status =  status;
    }

    public abstract boolean borrowItem(int numberOfCopies);

    public abstract boolean returnItem(int numberOfCopies);

    //to string
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