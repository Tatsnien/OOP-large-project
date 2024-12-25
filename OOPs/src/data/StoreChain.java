package data;

import java.util.*;

import customer.MemberCustomer;
import payment.Bill;
import personnel.Director;
import personnel.Personnel;

public class StoreChain extends StoreEntity{
	private static List<StoreBranch> branchs;
	private static Director director;
	
	public StoreChain() {
		if (branchs == null)
			branchs = new ArrayList<StoreBranch>();
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
	
}
