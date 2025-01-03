package customer;

import data.Item;
import data.ItemGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<ItemGroup> groups;
	
	public Cart() {
		groups = FXCollections.observableArrayList();
	}
	
	public ObservableList<ItemGroup> getGroups() {
		return groups;
	}
	
	public void clearCart() {
		groups.clear();
	}
	
}
