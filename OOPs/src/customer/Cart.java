package customer;

import data.Item;
import data.OrderedItemGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<OrderedItemGroup> group;
	private ObservableList<Item> itemsOrdered;	
	private ObservableList<Integer> qty;
	
	public Cart() {
		itemsOrdered = FXCollections.observableArrayList();
		qty = FXCollections.observableArrayList();
		group = FXCollections.observableArrayList();
	}
	
	public ObservableList<Item> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public ObservableList<Integer> getQty() {
		return qty;
	}
	
	public ObservableList<OrderedItemGroup> getGroup() {
		return group;
	}

	public void addItem(Item item, int qty) {		
		this.itemsOrdered.add(item);
		this.qty.add(qty);
		group.add(new OrderedItemGroup(item, qty));
		System.out.println("\"" + item.getName() + "\" has been added.");
	}
	
	public void removeItem(Item removingItem) {
		int idx = itemsOrdered.indexOf(removingItem);
		if (idx == -1) {
			System.out.println("\"" + removingItem.getName() + "\" is not found");
			return;
		}
		
		itemsOrdered.remove(idx);
		qty.remove(idx);
		group.remove(idx);
		System.out.println("\"" + removingItem.getName() + "\" is removed");
	}
	
	public void clearCart() {
		itemsOrdered.clear();
		qty.clear();
		group.clear();
	}
	
}
