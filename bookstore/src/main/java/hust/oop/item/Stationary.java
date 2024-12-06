package hust.oop.item;

public class Stationary extends Item {
    // Attributes specific to Stationary
    private String type;

    // Constructor
    public Stationary(String name, String barcode, float purchasePrice, float sellingPrice, boolean availability, String type) {
        super(name, barcode, purchasePrice, sellingPrice, availability);
        this.type = type;
    }

    // Getter and Setter
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "type='" + type + '\'' +
                ", " + super.toString() +
                '}';
    }
}
