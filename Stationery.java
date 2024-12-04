class Stationery extends Item {
    private String type; // Specific attribute for stationeries
    private String brand; // Specific attribute for stationeries

    public Stationery(String name, int barcode, String type, int quantity, float purchasePrice, float sellingPrice) {
        super(name, barcode, purchasePrice, quantity, sellingPrice);
        this.type = type;
    }

    @Override
    public String getItemInfo() {
        return "Stationery: " + name + ", Type: " + type + ", Barcode: " + barcode + 
               ", Price: " + sellingPrice + ", Available: " + availability;
    }
}

