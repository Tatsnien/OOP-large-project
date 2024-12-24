package data;
// Abstract Item Class
public abstract class Item {
    protected String name;          // Common attribute for all items
    protected int barcode;          // Unique barcode for the item
    protected float purchasePrice;  // Purchase price of the item
    protected int quantity;         // Quantity in stock
    protected float sellingPrice;    // Selling price of the item

    public Item(String name, int barcode, float purchasePrice, int quantity, float sellingPrice) {
        this.name = name;
        this.barcode = barcode;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
    }

    // Abstract method to get item information
    public abstract String getItemInfo();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBarcode() {
		return barcode;
	}
	
	public float getTotalPrice() {
		return this.purchasePrice * this.quantity;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
    
}  

