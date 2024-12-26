package data;

import java.util.List;

import payment.Bill;
import personnel.Personnel;
import personnel.StoreBranchManager;

public class StoreBranch extends StoreEntity {
	private int branchNumber;
	private String address;
	private StoreBranchManager branchManager;
	
	public StoreBranch() {}
	
	public StoreBranch(int branchNumber, String address, StoreBranchManager branchManager) {
		this.branchNumber = branchNumber;
		this.address = address;
		this.branchManager = branchManager;
	}

	public void addBill(Bill bill) {
		this.bills.add(bill);
		this.income += bill.getTotalAmount();
	}

	public int getBranchNumber() {
		return branchNumber;
	}

	public String getAddress() {
		return address;
	}

	public StoreBranchManager getBranchManager() {
		return branchManager;
	}
	
	public String getBranchManagerName() {
		return branchManager.getName();
	}

	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBranchManager(StoreBranchManager branchManager) {
		this.branchManager = branchManager;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StoreBranch)
			return this.branchNumber == ((StoreBranch) obj).branchNumber;
		return false;
	}	
	
	//Testing purpose: Deleted at final stage
	public void addPersonnel(Personnel person) {
		if (person instanceof StoreBranchManager) {
			StoreBranchManager manager = (StoreBranchManager) person;
			this.getPersonnels().add(manager);
		}
		else
			this.getPersonnels().add(person);
	}
	
	//Testing purpose: Deleted at final stage
	public void addExpense(Personnel person) {
		this.expenses.add(new SalaryExpense(person));
	}
	
}
