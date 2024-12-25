package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Item;
import data.Stationary;
import data.Toy;
import data.Book;

public class ItemManagementService {
	private List<Item> items;

	public ItemManagementService() {
		this.items = new ArrayList<>();
	}
	
	public ItemManagementService(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void addToy(String name, int barcode, String brand, int[] suitableAges, int type, int quantity, float purchasePrice, float sellingPrice) {
		items.add(new Toy(name, barcode, brand, suitableAges, type, quantity, purchasePrice, sellingPrice));
	}
	
	public void addStationary(String name, int barcode, String type, int quantity, float purchasePrice, float sellingPrice) {
		items.add(new Stationary(name, barcode, type, quantity, purchasePrice, sellingPrice));
	}
	
	public void addBook(String name, int barcode, String author, String publisher, String isbn, int quantity, float purchasePrice, float sellingPrice) {
		items.add(new Book(name, barcode, author, publisher, isbn, quantity, purchasePrice, sellingPrice));
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
}
