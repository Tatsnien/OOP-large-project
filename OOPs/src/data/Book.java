package data;

public class Book extends Item {
    private String author;      // Specific attribute for books
    private String publisher;   // Specific attribute for books
    private String isbn;        // Specific attribute for books

    public Book(String name, String barcode, String author, String publisher, String isbn, 
    		float price) {
        super(name, barcode, price);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.itemType = "Book";
    }
    
    public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
    public String getItemInfo() {
        return 	"Book: " + name + 
        		" by " + author + 
        		", Publisher: " + publisher + 
        		", ISBN: " + isbn + 
        		", Price: " + price;
    }
}

