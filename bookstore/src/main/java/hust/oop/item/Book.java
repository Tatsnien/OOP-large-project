package hust.oop.item;

public class Book extends Item {
    // Attributes specific to Book
    private String publisher;
    private String ISBN;

    // Constructor
    public Book(String name, String barcode, float purchasePrice, float sellingPrice, boolean availability, String publisher, String ISBN) {
        super(name, barcode, purchasePrice, sellingPrice, availability);
        this.publisher = publisher;
        this.ISBN = ISBN;
    }

    // Getters and Setters
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", " + super.toString() +
                '}';
    }
}
