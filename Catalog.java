
import java.util.ArrayList;

/**
 * A generic catalog for storing library items.
 */
public class Catalog<T extends LibraryItem<?>> {
    private ArrayList<T> items;

    public Catalog() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item if its ID is not already in the catalog.
     */
    public <U extends T> boolean addItem(U item) {
        if (getItemById(item.getItemID()) != null) {
            System.out.println("Error: Item ID already exists.");
            return false;
        }

        items.add(item);
        System.out.println("Item added successfully.");
        return true;
    }

    /**
     * Retrieves an item using its ID.
     */
    public T getItemById(String itemID) {
        for (T item : items) {
            if (item.getItemID().equalsIgnoreCase(itemID)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Removes an item using its ID.
     */
    public boolean removeItem(String itemID) {
        T item = getItemById(itemID);

        if (item == null) {
            System.out.println(
                    "Error: Item with ID " + itemID
                    + " was not found.");
            return false;
        }

        items.remove(item);
        System.out.println("Item removed successfully.");
        return true;
    }

    /**
     * Displays all items in the catalog.
     */
    public void displayCatalog() {
        if (items.isEmpty()) {
            System.out.println("The catalog is empty.");
            return;
        }

        System.out.println("\n--- Library Catalog ---");

        for (T item : items) {
            System.out.println(item);
        }
    }

    public int getItemCount() {
        return items.size();
    }
}
