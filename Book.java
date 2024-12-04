class Book extends Item {
    private String author;      // Specific attribute for books
    private String publisher;   // Specific attribute for books
    private String isbn;        // Specific attribute for books

    public Book(String name, int barcode, String author, String publisher, String isbn, int quantity, 
    		float purchasePrice, float sellingPrice) {
        super(name, barcode, purchasePrice, quantity, sellingPrice);
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    @Override
    public String getItemInfo() {
        return "Book: " + name + " by " + author + ", Publisher: " + publisher + ", ISBN: " + isbn + 
               ", Price: " + sellingPrice + ", Available: " + availability;
    }
}

