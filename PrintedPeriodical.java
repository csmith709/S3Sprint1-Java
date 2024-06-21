public class PrintedPeriodical extends Periodical{
    private String coverType;

    public PrintedPeriodical(String itemId, String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String coverType) {
        //inherited
        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
        this.coverType = coverType;
    }

    //get
    public String getCoverType() {
        return coverType;
    }

    //set
    public void setCoverType(String coverType) {
        this.coverType = coverType;
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

    @Override
    public boolean returnItem(int numberOfCopies) {
        setAvailableCopies(getAvailableCopies() + numberOfCopies);
        if (getAvailableCopies() > 0) {
            setStatus(Status.AVAILABLE);
        }
        return true;
    }

    //to string
    @Override
    public String toString() {
        return "PrintedPeriodical{" +
                "coverType='" + coverType + '\'' +
                ", itemId='" + getItemId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", author=" + getAuthor() +
                ", ISBN='" + getISBN() + '\'' +
                ", publisher='" + getPublisher() + '\'' +
                ", totalCopies=" + getTotalCopies() +
                ", availableCopies=" + getAvailableCopies() +
                ", status=" + getStatus() +
                '}';
    }

}