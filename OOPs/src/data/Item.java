package data;
// Abstract Item Class
public abstract class Item {
    protected String name;          	// Common attribute for all items
    protected String barcode;          	// Unique barcode for the item
    protected float price;  			// Purchase price of the item
    protected String itemType;
    protected int quantity;

    public Item(String name, String barcode, int quantity, float price) {
        this.name = name;
        this.barcode = barcode;
        this.quantity=quantity;
        this.price = price;
    }

    // Abstract method to get item information
    public abstract String getItemInfo();

    public float getPrice() {
        return price;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}
	
	public int getQuantity() {
		return quantity;
	} 

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getItemType() {
		return itemType;
	
}  

