package customer;

import data.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Item> itemsOrdered = 
			FXCollections.observableArrayList();
	
	public ObservableList<Item> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addItem(Item item) {		
		itemsOrdered.add(item);
		System.out.println("\"" + item.getName() + "\" has been added.");
	}
	
	public void addItem(Item[] itemList) {
		for (Item item : itemList) 
			addItem(item);
	}
	
	public void removeItem(Item removingItem) {
		for (Item item : itemsOrdered)
			if (item.equals(removingItem)) {
				itemsOrdered.remove(removingItem);
				System.out.println("\"" + removingItem.getName() + "\" has been removed.");
				return;
			}
		System.out.println("\"" + removingItem.getName() + "\" is not found");
	}
	
	public void clearCart() {
		itemsOrdered.clear();
	}
	
}
