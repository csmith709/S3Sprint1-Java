import java.util.ArrayList;
import java.util.List;
 
public class Author {
private String name;
private String dob;
private List<LibraryItem> items;
 
    public Author(String name, String dob) {
    this.name = name;
    this.dob = dob;
    this.items = new ArrayList<>();
    }
 
    public String getName() {
        return name;
    }
 
    public String getDob() {
        return dob;
    }
 
    public List<LibraryItem> getItems() {
        return items;
    }
 
    public void addWrittenItem(LibraryItem item) {
        items.add(item);
    }
}