public class PrintdBook extends Book{

    private int pageNumber;
    private String coverStyle;

    public PrintdBook(String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String itemId, int pageNumber, String coverStyle) {

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
            setStatus(Status.CHECKED_OUT);
    return true;
        }
    return false;
    }
 
    // Implement returnItem method
    @Override
    public boolean returnItem(int numberOfCopies) {
        setAvailableCopies(getAvailableCopies() + numberOfCopies);
        if (getAvailableCopies() > 0) {
            setStatus(Status.AVAILABLE);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PrintdBook{" +
                "pageNumber=" + pageNumber +
                ", coverStyle='" + coverStyle + '\'' +
                '}';
    }
    
}
