package system.service;

import java.util.List;

import data.StoreBranch;
import data.StoreChain;
import payment.Bill;
import personnel.Director;

public class IncomeService {
	
	private static StoreChain chain;
	StoreBranch branch;
	
	public IncomeService(Director director) {}
	
	public IncomeService(int branchNumber) {
		branch = chain.getBranch(branchNumber);
	}
	
	public IncomeService(StoreBranch branch) {
		this.branch = branch;
	}
	
	public static void setChain(StoreChain chain) {
		IncomeService.chain = chain;
	}
	
	public void setBranch(StoreBranch branch) {
		this.branch = branch;
	}
	
	public List<Bill> getBills() {
		if (branch == null)
			return chain.getBills();
		return branch.getBills();
	}

	public float getIncome() {
		if (branch == null)
			return chain.getIncome();
		return branch.getIncome();
	}
	
	public void addBill(Bill bill) {
		if (branch == null)
			return;
		branch.addBill(bill);
	}
	
}
