package system.service;

import java.util.List;

import data.Item;
import data.ItemGroup;
import data.Stationary;
import data.StoreBranch;
import data.StoreChain;
import data.Toy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import data.Book;
import personnel.Director;
import personnel.Personnel;

public class ItemService {
	
	private static StoreChain chain;
	private ObservableList<ItemGroup> groups;

	public ItemService(List<ItemGroup> groups) {
		this.groups = FXCollections.observableArrayList(groups);
	}
	
	public ItemService(int branchNumber) {
		this.groups = FXCollections.observableArrayList(chain.getBranch(branchNumber).getGroups());
	}
	
	public ItemService(StoreBranch branch) {
		this.groups = FXCollections.observableArrayList(branch.getGroups());
	}
	
	public ItemService(Personnel personnel) {
		if (personnel instanceof Director) 
			this.groups = FXCollections.observableArrayList(chain.getGroups());
		else
			this.groups = FXCollections.observableArrayList(chain.searchEmployeeBranch(personnel.getId()).getGroups());
	}

	public static void setChain(StoreChain chain) {
		ItemService.chain = chain;
	}

	public List<ItemGroup> getGroups() {
		return groups;
	}

	public int searchItemIndex(String barcode) {
		for (int i = 0; i < groups.size(); ++i)
			if (groups.get(i).getBarcode().equals(barcode))
				return i;
		return -1;
	}
	
	public void addItem(Item item, int quantity) {		
		int idx = groups.indexOf(item);
		if (idx == -1)
			groups.add(new ItemGroup(item, quantity));
		else
			groups.get(idx).addQty(quantity);
	}
	
	public void addItemGroup(ItemGroup group) {		
		int idx = groups.indexOf(group);
		if (idx == -1)
			groups.add(group);
		else
			groups.get(idx).addQty(group.getQty());
	}
	
	public void addItemGroups(List<ItemGroup> groups) {		
		for (ItemGroup group : groups)
			addItemGroup(group);
	}
	
	public void addToy(String name, String barcode, String brand, int[] suitableAges, String type, int quantity, float price) {
		Item item = new Toy(name, barcode, brand, suitableAges, type, price);
		addItem(item, quantity);
	}
	
	public void addStationary(String name, String barcode, String type, int quantity, float price) {
		Item item = new Stationary(name, barcode, type, price);
		addItem(item, quantity);
	}
	
	public void addBook(String name, String barcode, String author, String publisher, String isbn, int quantity, float price) {
		Item item = new Book(name, barcode, author, publisher, isbn, price);
		addItem(item, quantity);
	}
	
	public void removeItem(Item item) {
		groups.remove(item);
	}
	
	public void removeGroup(ItemGroup group) {
		groups.remove(group);
	}
	
	public void clear() {
		groups.clear();
	}
	
}
