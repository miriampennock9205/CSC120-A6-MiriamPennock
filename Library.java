import java.util.Hashtable;
import javax.swing.border.TitledBorder;

/* This is a stub for the Library class */
public class Library extends Building {

    private Hashtable<String, Boolean> collection; //Stores book titles and availability

    public Library(String name, String address, int nFloors) {      
    super(name, address, nFloors); //Call the Building constructor
    this.collection = new Hashtable<String, Boolean>(); //Initialize the collection
    System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title) {
      collection.put(title, true); //Add the title and mark it as available
    }

    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
          collection.remove(title); //Remove the title if it exists
          return title;
        } else {
          return null; //Return null if the title doesn't exist
        }
    }

    public void checkOut(String title) {
      if (collection.containsKey(title) && collection.get(title)) {
        collection.replace(title, false); //Mark the title as checked out
      } else {
        System.out.println("Book not available for checkout.");
      }
    }

    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        collection.replace(title, true); //Mark the title as available again
      } else {
        System.out.println("This title was not part of the libary's collection.");
      }
    }
    public static void main(String[] args) {
      Library myLibrary = new Library("Smith College Library", "100 Green St, Northampton, MA", 4);
      System.out.println(myLibrary);
    }
  
  }