package hust.oop.item;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> items;
    private float totalAmount;

    // Constructor
    public Bill() {
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    // Add an item to the bill
    public void addItem(Item item) {
        items.add(item);
        totalAmount += item.getSellingPrice();
    }

    // Get the total amount of the bill
    public float getTotalAmount() {
        return totalAmount;
    }

    // Get all items in the bill
    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Bill [items=" + items + ", totalAmount=" + totalAmount + "]";
    }
}
