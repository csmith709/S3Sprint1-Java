public class ElectronicPeriodical extends Periodical {
    private String fileFormat;

    public ElectronicPeriodical(String itemId, String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String fileFormat) {
        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);
        this.fileFormat = fileFormat;
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

    @Override
    public String toString() {
        return "ElectronicPeriodical{" +
                "fileFormat='" + fileFormat + '\'' +
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
