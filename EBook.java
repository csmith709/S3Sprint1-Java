public class EBook extends Book {

    private int fileSize;
    private String fileFormat;

    public EBook(String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String itemId, String fileFormat, int fileSize) {
        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public boolean borrowItem(int numberOfCopies) {
        if (getAvailableCopies() >= numberOfCopies) {
            setAvailableCopies(getAvailableCopies() - numberOfCopies);
            if (getAvailableCopies() == 0) {
                setStatus(Status.CHECKED_OUT);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(int numberOfCopies) {
        setAvailableCopies(getAvailableCopies() + numberOfCopies);
        if (getAvailableCopies() > 0) {
            setStatus(Status.AVAILABLE);
        }
        return true;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "itemId='" + getItemId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + getAuthor() +
                ", ISBN='" + getISBN() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", totalCopies=" + getTotalCopies() +
                ", availableCopies=" + getAvailableCopies() +
                ", status=" + getStatus() +
                ", fileSize=" + fileSize +
                ", fileFormat='" + fileFormat + '\'' +
                '}';
    }
}
