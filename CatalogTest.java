
/**
 * Tests the generic library catalog operations.
 */
public class CatalogTest {
    public static void main(String[] args) {
        Catalog<LibraryItem<?>> catalog = new Catalog<>();

        System.out.println("=== Library Catalog Tests ===");

        // Test adding different types of library items.
        catalog.addItem(
                new Book("Things Fall Apart", "Chinua Achebe",
                        "B101", "Fiction"));

        catalog.addItem(
                new DVD("Java Tutorial", "John Smith",
                        "D201", 90));

        catalog.addItem(
                new Magazine("Science Today", "Mary Jones",
                        "M301", "Issue 12"));

        // Test the total number of items.
        System.out.println(
                "Expected 3 items; actual: "
                + catalog.getItemCount());

        // Test retrieving an existing item.
        LibraryItem<?> item = catalog.getItemById("B101");
        System.out.println("Retrieved item: " + item);

        // Test preventing duplicate IDs.
        catalog.addItem(
                new Book("Another Book", "Jane Doe",
                        "B101", "Education"));

        // Test removing an existing item.
        catalog.removeItem("D201");

        System.out.println(
                "Expected 2 items after removal; actual: "
                + catalog.getItemCount());

        // Test removing a non-existent item.
        catalog.removeItem("X999");

        // Test displaying the remaining catalog.
        catalog.displayCatalog();

        // Test the LibraryItem class getters.
        LibraryItem<?> book = catalog.getItemById("B101");

        if (book != null
                && book.getTitle().equals("Things Fall Apart")
                && book.getAuthor().equals("Chinua Achebe")) {
            System.out.println("LibraryItem getter test passed.");
        } else {
            System.out.println("LibraryItem getter test failed.");
        }

        System.out.println("=== Tests Completed ===");
    }
}
