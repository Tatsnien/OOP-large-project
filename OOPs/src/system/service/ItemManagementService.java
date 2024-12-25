package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Item;
import data.Stationary;
import data.StoreBranch;
import data.StoreChain;
import data.Toy;
import data.Book;
import personnel.Director;
import personnel.Personnel;

public class ItemManagementService {
	private List<Item> items;
	private List<Integer> qty;

	public ItemManagementService() {
		this.items = (new StoreChain()).getItems();
		this.qty = (new StoreChain()).getQty();
	}
	
	public ItemManagementService(int branchNumber) {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchNumber() == branchNumber) {
				items = branch.getItems();
				qty = branch.getQty();
				return;
			}
	}
	
	public ItemManagementService(StoreBranch branch) {
		items = branch.getItems();
		qty = branch.getQty();
	}	
	
	public ItemManagementService(List<Item> items, List<Integer> qty) {
		this.items = items;
		this.qty = qty;
	}
	
	public ItemManagementService(Personnel personnel) {
		if (personnel instanceof Director) {
			this.items = (new StoreChain()).getItems();
			this.qty = (new StoreChain()).getQty();
		}
		else {
			for (StoreBranch branch : StoreChain.getBranchs()) 
				if (branch.getPersonnels().contains(personnel)) {
					this.items = branch.getItems();
					this.qty = branch.getQty();
				}
		}
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<Integer> getQty() {
		return qty;
	}

	public void setQty(List<Integer> qty) {
		this.qty = qty;
	}

	public int searchItemIndex(String barcode) {
		for (int i = 0; i < items.size(); ++i)
			if (items.get(i).getBarcode().equals(barcode))
				return i;
		return -1;
	}
	
	public void addItem(Item item, int quantity) {
		items.add(item);
		qty.add(quantity);
	}
	
	public void addToy(String name, String barcode, String brand, int[] suitableAges, String type, int quantity, float price) {
		items.add(new Toy(name, barcode, brand, suitableAges, type, price));
		qty.add(quantity);
	}
	
	public void addStationary(String name, String barcode, String type, int quantity, float price) {
		items.add(new Stationary(name, barcode, type, price));
		qty.add(quantity);
	}
	
	public void addBook(String name, String barcode, String author, String publisher, String isbn, int quantity, float price) {
		items.add(new Book(name, barcode, author, publisher, isbn, price));
		qty.add(quantity);
	}
	
	public void removeItem(Item item) {
		int idx = items.indexOf(item);
		items.remove(idx);
		qty.remove(idx);
	}
	
}
