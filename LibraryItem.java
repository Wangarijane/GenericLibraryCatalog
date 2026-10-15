
/**
 * Represents a library item.
 * T represents additional information specific to an item.
 */
public class LibraryItem<T> {
    private String title;
    private String author;
    private String itemID;
    private String itemType;
    private T itemDetails;

    public LibraryItem(String title, String author,
                       String itemID, String itemType,
                       T itemDetails) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
        this.itemType = itemType;
        this.itemDetails = itemDetails;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemType() {
        return itemType;
    }

    public T getItemDetails() {
        return itemDetails;
    }

    @Override
    public String toString() {
        return "ID: " + itemID
                + ", Type: " + itemType
                + ", Title: " + title
                + ", Author: " + author
                + ", Details: " + itemDetails;
    }
}

// A book uses String for its additional details, such as genre.
class Book extends LibraryItem<String> {
    public Book(String title, String author,
                String itemID, String genre) {
        super(title, author, itemID, "Book", genre);
    }
}

// A DVD uses Integer for its running time in minutes.

class DVD extends LibraryItem<Integer> {
    public DVD(String title, String author,
               String itemID, Integer duration) {
        super(title, author, itemID, "DVD", duration);
    }
}

// A magazine uses String for its issue information.
class Magazine extends LibraryItem<String> {
    public Magazine(String title, String author,
                    String itemID, String issue) {
        super(title, author, itemID, "Magazine", issue);
    }
}
