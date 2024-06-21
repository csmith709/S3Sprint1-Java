
public interface Borrowable {
    boolean borrowedItems(int numberOfCopies);
    boolean returnItem(int numberOfCopies);
}
