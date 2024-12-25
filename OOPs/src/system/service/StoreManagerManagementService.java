package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.StoreBranch;
import data.StoreChain;
import personnel.Personnel;
import personnel.StoreBranchManager;

public class StoreManagerManagementService extends PersonnelManagementService{
	
	public StoreManagerManagementService() {
		super();
		for (StoreBranch branch : StoreChain.getBranchs())
			this.personnels.add(branch.getBranchManager());
	}
	
	public StoreManagerManagementService(List<Personnel> personnels, List<Expense> expenses) {
		super();
		setPersonnels(personnels);
		expenseService = new ExpenseManagementService(expenses);
	}
	
	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = new ArrayList<>();
		for (Personnel personnel : personnels)
			if (personnel instanceof StoreBranchManager)
				this.personnels.add(personnel);
	}
	
	public StoreBranchManager searchManager(int branchNumber) {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchNumber() == branchNumber)
				return branch.getBranchManager();
		return null;
	}
	
}
