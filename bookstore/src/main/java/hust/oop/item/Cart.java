package hust.oop.item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> itemsOrdered;

    // Constructor
    public Cart() {
        this.itemsOrdered = new ArrayList<>();
    }

    // Add an item to the cart
    public void addItem(Item item) {
        this.itemsOrdered.add(item);
    }

    // Remove an item from the cart
    public void removeItem(Item item) {
        this.itemsOrdered.remove(item);
    }

    // Get all items in the cart
    public List<Item> getItemsOrdered() {
        return itemsOrdered;
    }

    @Override
    public String toString() {
        return "Cart [itemsOrdered=" + itemsOrdered + "]";
    }
}
