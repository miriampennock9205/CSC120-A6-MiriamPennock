
import java.util.Hashtable;

/**
 * Represents a library, which is a type of building that contains a collection
 * of books. Extends the Building class.
 */
public class Library extends Building {

    /**
     * Stores book titles and their availability in the library
     */
    private Hashtable<String, Boolean> collection;

    /**
     * Constructs a Library object with the specified attributes.
     *
     * @param name The name of the library
     * @param address The address of the library
     * @param nFloors The number of floors of the library
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors); //Call the Building constructor
        this.collection = new Hashtable<String, Boolean>(); //Initialize the collection
        System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book title to the collection and marks it as available.
     *
     * @param title The title of the book to add
     */
    public void addTitle(String title) {
        if (collection.containsKey(title)) {
            throw new IllegalArgumentException("This title is already in the collection: " + title);
        } else {
            collection.put(title, true); //Add the title and mark it as available
            System.out.println("Added book: " + title);
        }
    }

    /**
     * Removes a book title from the library collection.
     *
     * @param title The title of the book to remove
     * @return The title of the book if it was removed, or null if it was not
     * found
     */
    public String removeTitle(String title) {
        if (collection.containsKey(title)) {
            collection.remove(title); //Remove the title if it exists
            return title;
        } else {
            return null; //Return null if the title doesn't exist
        }
    }

    /**
     * Checks out a book by marking it as unavailable in the library collection.
     *
     * @param title The title of the book to check out
     */
    public void checkOut(String title) {
        if (collection.containsKey(title) && collection.get(title)) {
            collection.replace(title, false); //Mark the title as checked out
        } else {
            System.out.println("Book not available for checkout.");
        }
    }

    /**
     * Returns a book by marking it as available in the library collection.
     *
     * @param title The title of the book to return
     */
    public void returnBook(String title) {
        if (collection.containsKey(title)) {
            collection.replace(title, true); //Mark the title as available again
        } else {
            System.out.println("This title was not part of the libary's collection.");
        }
    }

    /**
     * Checks if a book is in the collection.
     *
     * @param title The title of the book to check
     * @return true if the book is in the collection, false otherwise
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * Checks if a book is available for checkout.
     *
     * @param title The title of the book to check
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable(String title) {
        if (collection.containsKey(title)) {
            return collection.get(title); // Return availability status (true if available)
        } else {
            System.out.println("This title is not in the collection.");
            return false;
        }
    }

    /**
     * Prints the entire collection of books along with their availability.
     */
    public void printCollection() {
        if (collection.isEmpty()) {
            System.out.println("The collection is empty.");
        } else {
            for (String title : collection.keySet()) {
                String status = collection.get(title) ? "Available" : "Checked out";
                System.out.println("Title: " + title + " | Status: " + status);
            }
        }
    }

    /**
     * Tests the functionality of the Library class methods.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        //Create a new Library object
        Library myLibrary = new Library("Smith College Library", "100 Green St, Northampton, MA", 4);

        //Test toString method from Building class
        System.out.println(myLibrary);

        //Test addTitleMethod
        myLibrary.addTitle("The Great Gatsby");
        myLibrary.addTitle("1984");

        // Test removeTitle method
        myLibrary.removeTitle("1984");
        myLibrary.removeTitle("To Kill a Mockingbird"); // Testing removing a non-existent book

        // Test checkOut method
        myLibrary.checkOut("The Great Gatsby"); // Checking out an available book
        myLibrary.checkOut("The Great Gatsby"); // Attempting to check out the same book again

        // Test returnBook method
        myLibrary.returnBook("The Great Gatsby"); // Returning a checked-out book
        myLibrary.returnBook("To Kill a Mockingbird"); // Testing return for a non-existent book

        // Test printCollection method
        System.out.println("Library Collection:");
        myLibrary.printCollection();

        // Test containsTitle method
        System.out.println("Contains '1984': " + myLibrary.containsTitle("1984"));
        System.out.println("Contains 'Moby Dick': " + myLibrary.containsTitle("Moby Dick"));

        // Test isAvailable method
        System.out.println("Is '1984' available: " + myLibrary.isAvailable("1984"));
        myLibrary.checkOut("1984");
        System.out.println("Is '1984' available after checkout: " + myLibrary.isAvailable("1984"));

        // Test returnBook method
        myLibrary.returnBook("1984");
        System.out.println("Is '1984' available after return: " + myLibrary.isAvailable("1984"));

        // Test printCollection again
        System.out.println("Library Collection after updates:");
        myLibrary.printCollection();
    }
}
