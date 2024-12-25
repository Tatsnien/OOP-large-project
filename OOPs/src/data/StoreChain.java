package data;

import java.util.*;

import customer.MemberCustomer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import payment.Bill;
import personnel.Director;
import personnel.Personnel;

public class StoreChain extends StoreEntity{
	private static ObservableList<StoreBranch> branchs;
	private static Director director;
	
	public StoreChain() {
		if (branchs == null) 
			branchs = FXCollections.observableArrayList();			
	}
	
	public static Director getDirector() {
		return director;
	}
	
	public static void setDirector(Director director) {
		StoreChain.director = director;
	}

	public static List<StoreBranch> getBranchs() {
		return branchs;
	}

	public void addBranch(StoreBranch newBranch) {
		boolean branchExisted = false;
		for (StoreBranch branch : branchs)
			if (newBranch.equals(branch)) {
				branchExisted = true;
				break;
			}
		
		if (branchExisted)
			System.out.println("Branch " + newBranch.getBranchNumber() + " has existed. Can't be added to store chain.");
		else {
			branchs.add(newBranch);
			System.out.println("Branch " + newBranch.getBranchNumber() + " has been added to store chain.");
		}
	}
	
	public void removeBranch(StoreBranch newBranch) {
		StoreBranch similarBranch = null;
		for (StoreBranch branch : branchs)
			if (newBranch.equals(branch)) {
				similarBranch = branch;
				break;
			}
		
		if (similarBranch != null) {
			branchs.remove(similarBranch);
			System.out.println("Branch " + newBranch.getBranchNumber() + " has been removed from store chain.");
		}
		else
			System.out.println("Branch " + newBranch.getBranchNumber() + " doesn't exist.");
	}
	
	public StoreBranch searchBranch(String id) {
		for (StoreBranch branch : branchs)
			for (Personnel personnel : getPersonnels())
				if (personnel.getAccount().getId().equals(id))
					return branch;
		return null;
	}
	
	public Personnel searchPersonnel(String id) {
		for (StoreBranch branch : branchs)
			for (Personnel personnel : getPersonnels())
				if (personnel.getAccount().getId().equals(id))
					return personnel;
		return null;
	}
	
	@Override
	public List<Personnel> getPersonnels() {
		this.personnels = new ArrayList<>();
		for (StoreBranch branch : branchs)
			this.personnels.addAll(branch.getPersonnels());
		return this.personnels;
	}
	
	@Override
	public List<Item> getItems() {
		this.items = new ArrayList<>();
		this.qty = new ArrayList<>();
		for (StoreBranch branch : branchs) {
			List<Item> curItems = branch.getItems();
			List<Integer> curQty = branch.getQty();
			
			for (int i = 0; i < curItems.size(); ++i)
				if (items.contains(curItems.get(i))) {
					int idx = items.indexOf(curItems.get(i));
					qty.set(idx, qty.get(idx) + curQty.get(i));
				}
				else {
					items.add(curItems.get(i));
					qty.add(curQty.get(i));
				}
		}
		
		for (StoreBranch branch : branchs)
			this.items.addAll(branch.getItems());
		return this.items;
	}

	@Override
	public List<Bill> getBills() {
		this.bills = new ArrayList<>();
		for (StoreBranch branch : branchs)
			this.bills.addAll(branch.getBills());
		return this.bills;
	}

	@Override
	public float getIncome() {
		this.income = 0;
		for (StoreBranch branch : branchs)
			this.income += branch.getIncome();
		return this.income;
	}
	
	@Override
	public List<Expense> getExpenses(){
		for (StoreBranch branch : branchs)
			for (Expense expense : branch.getExpenses())
				if (!this.expenses.contains(expense))
					this.expenses.add(expense);
		return this.expenses;
	}
	
}
