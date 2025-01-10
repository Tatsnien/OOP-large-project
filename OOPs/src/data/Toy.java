package data;

public class Toy extends Item {
    private int[] suitableAges; // Array to represent suitable age range
    private String brand;
    private String type; // Additional attribute for a specific age type

    public Toy(String name, String barcode, String brand, int[] suitableAges, String type, float price) {
        super(name, barcode, price);
        this.brand = brand;
        this.suitableAges = suitableAges; // Expecting an array with two elements [minAge, maxAge]
        this.type = type; // A specific age value or category
        this.itemType = "Toy";
    }

    @Override 
    public String getItemInfo() {
        return "Toy: " + name + ", Suitable Ages: " + suitableAges[0] + "-" + suitableAges[1] + 
               ", Age Type: " + type + ", Barcode: " + barcode + 
               ", Price: " + price;
    }

    // Method to check if a specific age is suitable
    public boolean isAgeSuitable(int age) {
        return age >= suitableAges[0] && age <= suitableAges[1];
    }

       public String getBrand() {
        return brand;
    }

    public int[] getSuitableAges() {
        return suitableAges;
    }


    public String getType() {
        return type;
    }
}

