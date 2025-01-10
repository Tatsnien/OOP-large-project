package data;

public class Stationary extends Item {
    private String type; // Specific attribute for stationeries
    private String brand; // Specific attribute for stationeries

    public Stationary (String name, String barcode, String type, float price) {
    	super(name, barcode, price);
        this.type = type;
        this.itemType = "Stationary";
    }

    public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	@Override
    public String getItemInfo() {
        return "Stationery: " + name + ", Type: " + type + ", Barcode: " + barcode + 
               ", Price: " + price;
    }
}


