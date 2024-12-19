package data;
// Abstract Item Class
public abstract class Item {
    protected String name;          // Common attribute for all items
    protected int barcode;          // Unique barcode for the item
    protected float purchasePrice;  // Purchase price of the item
    protected int quantity;         // Quantity in stock
    protected float sellingPrice;    // Selling price of the item
    protected boolean availability;  // Availability status of the item

    public Item(String name, int barcode, float purchasePrice, int quantity, float sellingPrice) {
        this.name = name;
        this.barcode = barcode;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.availability = quantity > 0; // Set availability based on quantity
    }

    // Abstract method to get item information
    public abstract String getItemInfo();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.availability = quantity > 0; // Update availability
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public boolean isAvailable() {
        return availability;
    } 
    
}  

