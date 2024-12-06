package hust.oop.item;

import java.util.ArrayList;
import java.util.List;

public class StoreInformation {
    private String storeName;
    private String location;
    private List<Item> items;

    // Constructor
    public StoreInformation(String storeName, String location) {
        this.storeName = storeName;
        this.location = location;
        this.items = new ArrayList<>();
    }

    // Add an item to the store
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Remove an item from the store
    public void removeItem(Item item) {
        this.items.remove(item);
    }

    // Get all items in the store
    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "StoreInformation [storeName=" + storeName + ", location=" +
               location + ", items=" + items + "]";
    }
}
