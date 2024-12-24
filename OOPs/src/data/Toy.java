package data;

class Toy extends Item {
    private int[] suitableAges; // Array to represent suitable age range
    private String brand;
    private int type; // Additional attribute for a specific age type

    public Toy(String name, int barcode, String brand, int[] suitableAges, int type, int quantity, float purchasePrice, float sellingPrice) {
        super(name, barcode, purchasePrice, quantity, sellingPrice);
        this.brand = brand;
        this.suitableAges = suitableAges; // Expecting an array with two elements [minAge, maxAge]
        this.type = type; // A specific age value or category
    }

    @Override 
    public String getItemInfo() {
        return "Toy: " + name + ", Suitable Ages: " + suitableAges[0] + "-" + suitableAges[1] + 
               ", Age Type: " + type + ", Barcode: " + barcode + 
               ", Price: " + sellingPrice;
    }

    // Method to check if a specific age is suitable
    public boolean isAgeSuitable(int age) {
        return age >= suitableAges[0] && age <= suitableAges[1];
    }
}

