
import java.util.Scanner;

/**
 * Provides a command-line interface for the library catalog.
 */
public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Catalog<LibraryItem<?>> catalog = new Catalog<>();

        int choice;

        do {
            System.out.println("\n=== Library Catalog Menu ===");
            System.out.println("1. Add a library item");
            System.out.println("2. Remove a library item");
            System.out.println("3. View the catalog");
            System.out.println("4. Retrieve item details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                scanner.nextLine();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Choose item type:");
                    System.out.println("1. Book");
                    System.out.println("2. DVD");
                    System.out.println("3. Magazine");
                    System.out.print("Enter item type: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid item type.");
                        scanner.nextLine();
                        break;
                    }

                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type < 1 || type > 3) {
                        System.out.println("Invalid item type.");
                        break;
                    }

                    System.out.print("Enter item ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter book genre: ");
                        String genre = scanner.nextLine();

                        catalog.addItem(
                                new Book(title, author, id, genre));

                    } else if (type == 2) {
                        System.out.print(
                                "Enter DVD duration in minutes: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println(
                                    "Duration must be a whole number.");
                            scanner.nextLine();
                            break;
                        }

                        int duration = scanner.nextInt();
                        scanner.nextLine();

                        if (duration <= 0) {
                            System.out.println(
                                    "Duration must be positive.");
                            break;
                        }

                        catalog.addItem(
                                new DVD(title, author, id, duration));

                    } else {
                        System.out.print("Enter magazine issue: ");
                        String issue = scanner.nextLine();

                        catalog.addItem(
                                new Magazine(title, author, id, issue));
                    }
                    break;

                case 2:
                    System.out.print("Enter item ID to remove: ");
                    String removeID = scanner.nextLine();
                    catalog.removeItem(removeID);
                    break;

                case 3:
                    catalog.displayCatalog();
                    System.out.println(
                            "Total items: " + catalog.getItemCount());
                    break;

                case 4:
                    System.out.print("Enter item ID to retrieve: ");
                    String searchID = scanner.nextLine();

                    LibraryItem<?> found =
                            catalog.getItemById(searchID);

                    if (found != null) {
                        System.out.println("Item found:");
                        System.out.println(found);
                    } else {
                        System.out.println(
                                "No item found with ID " + searchID);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the catalog. Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please choose 1 to 5.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
