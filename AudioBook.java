
public class AudioBook extends Book{

    private int fileSize;
    private String audioFormat;

    public AudioBook(String title, Author author, String ISBN, String publisher, int totalCopies, int availableCopies, Status status, String itemId, int fileSize, String audioFormat) {

        super(itemId, title, author, ISBN, publisher, totalCopies, availableCopies, status);

        this.fileSize = fileSize;
        this.audioFormat = audioFormat;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getAudioFormat() {
        return audioFormat;
    }

    public void setAudioFormat(String audioFormat) {
        this.audioFormat = audioFormat;
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
        return "AudioBook{" +
                "fileSize=" + fileSize +
                ", audioFormat='" + audioFormat + '\'' +
                '}';
    }
    
}