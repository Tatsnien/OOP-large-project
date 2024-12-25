package system.service;

import java.util.List;

import data.StoreBranch;
import payment.Bill;

public class IncomeManagementService {
	
	StoreBranch branch;
	
	public void setBranch(StoreBranch branch) {
		this.branch = branch;
	}
	
	public List<Bill> getBills() {
		return branch.getBills();
	}

	public float getIncome() {
		return branch.getIncome();
	}
	
	public void addBill(Bill bill) {
		branch.addBill(bill);
	}
	
}
