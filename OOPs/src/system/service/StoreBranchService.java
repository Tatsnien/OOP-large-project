package system.service;

import java.util.List;

import data.StoreBranch;
import data.StoreBranchDAO;
import data.StoreChain;
import javafx.collections.ObservableList;
import personnel.Director;
import personnel.Personnel;
import personnel.StoreBranchManager;

public class StoreBranchService {
	
	private static StoreChain chain;
	
	public StoreBranchService(Director director) {}
	
	public static void setChain(StoreChain chain) {
		StoreBranchService.chain = chain;
	}

	private int availableSlot() {
		for (int i = 0; i < chain.getBranchs().size(); ++i)
			if (chain.getBranchs().get(i).getBranchNumber() != i + 1)
				return i;
		return chain.getBranchs().size();
	}
	
	public int addBranch(String address) {
		int slot = availableSlot();
		
		StoreBranch newBranch = new StoreBranch(slot + 1, address);
		chain.getBranchs().add(slot, newBranch);
		return slot + 1;
	}
	
	public int addBranch(StoreBranch newBranch) {
		int slot = -1;
		try {
			if (getBranch(newBranch.getBranchNumber()) != null)
				return -1;
		} 
		finally {
			slot = availableSlot();
			newBranch.setBranchNumber(slot + 1);
			chain.getBranchs().add(slot, newBranch);
			slot += 1;
		}
		return slot;
	}
	
	public void removeBranch(StoreBranch branch) {
		chain.removeBranch(branch);
	}
	
	public StoreBranch getBranch(int branchNumber) {
		/**
		 * return StoreBranch | null 
		 */
		return chain.getBranch(branchNumber);
	}
	
	public StoreBranchManager searchManager(int branchNumber) {
		return chain.getBranch(branchNumber).getBranchManager();
	}
	
	public void assignBranchManager(StoreBranchManager manager, int branchNumber) {
		chain.getBranch(branchNumber).setBranchManager(manager);
	}

	public List<StoreBranch> getBranchs() {
		return chain.getBranchs();
	}
	
}
