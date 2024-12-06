package hust.oop.item;

public class Toy extends Item {
    // Attribute specific to Toy
    private String brand;

    // Constructor
    public Toy(String name, String barcode, float purchasePrice, float sellingPrice, boolean availability, String brand) {
        super(name, barcode, purchasePrice, sellingPrice, availability);
        this.brand = brand;
    }

    // Getter and Setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "brand='" + brand + '\'' +
                ", " + super.toString() +
                '}';
    }
}
