package data;

import java.util.*;

import customer.MemberCustomer;
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
		List<Personnel> personnels = new ArrayList<>();
		for (StoreBranch branch : branchs)
			personnels.addAll(branch.getPersonnels());
		return personnels;
	}
	
	@Override
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		for (StoreBranch branch : branchs)
			items.addAll(branch.getItems());
		return items;
	}
	
}
