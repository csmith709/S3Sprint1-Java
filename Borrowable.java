package Java;

public interface Borrowable {
    boolean borrowItem(int numberOfCopies);
    boolean returnItem(int numberOfCopies);
}
