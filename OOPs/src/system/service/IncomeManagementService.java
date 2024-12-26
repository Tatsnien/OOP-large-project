package system.service;

import java.util.List;

import data.StoreBranch;
import data.StoreChain;
import payment.Bill;
import personnel.Director;

public class IncomeManagementService {
	
	StoreBranch branch;
	
	public IncomeManagementService(Director director) {}
	
	public IncomeManagementService(int branchNumber) {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchNumber() == branchNumber) {
				this.branch = branch;
				return;
			}
	}
	
	public IncomeManagementService(StoreBranch branch) {
		this.branch = branch;
	}
	
	public void setBranch(StoreBranch branch) {
		this.branch = branch;
	}
	
	public List<Bill> getBills() {
		if (branch == null)
			return (new StoreChain()).getBills();
		return branch.getBills();
	}

	public float getIncome() {
		if (branch == null)
			return (new StoreChain()).getIncome();
		return branch.getIncome();
	}
	
}
