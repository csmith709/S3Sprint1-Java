public class PrintedBook extends Book {

    private int pageNumber;
    private String coverStyle;

    public PrintedBook(String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String itemId, int pageNumber, String coverStyle) {
        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
        this.pageNumber = pageNumber;
        this.coverStyle = coverStyle;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getCoverStyle() {
        return coverStyle;
    }

    public void setCoverStyle(String coverStyle) {
        this.coverStyle = coverStyle;
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
        return "PrintedBook{" +
                "itemId='" + getItemId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + getAuthor() +
                ", ISBN='" + getISBN() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", totalCopies=" + getTotalCopies() +
                ", availableCopies=" + getAvailableCopies() +
                ", status=" + getStatus() +
                ", pageNumber=" + pageNumber +
                ", coverStyle='" + coverStyle + '\'' +
                '}';
    }
}
