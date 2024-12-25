package data;

public class Stationary extends Item {
    private String type; // Specific attribute for stationeries
    private String brand; // Specific attribute for stationeries

    public Stationary (String name, String barcode, String type, float price) {
    	super(name, barcode, price);
        this.type = type;
    }

    @Override
    public String getItemInfo() {
        return "Stationery: " + name + ", Type: " + type + ", Barcode: " + barcode + 
               ", Price: " + price;
    }
}


