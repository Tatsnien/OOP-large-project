package system.service;

import java.util.ArrayList;
import java.util.List;

import data.StoreBranch;
import data.StoreChain;
import personnel.StoreBranchManager;

public class StoreManagerManagementService {

	private List<StoreBranchManager> managers;
	
	public StoreManagerManagementService() {
		this.managers = new ArrayList<>();
		for (StoreBranch branch : StoreChain.getBranchs())
			this.managers.add(branch.getBranchManager());
	}

	public List<StoreBranchManager> getManagers() {
		return managers;
	}
	
	public StoreBranchManager searchManager(int branchNumber) {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchNumber() == branchNumber)
				return branch.getBranchManager();
		return null;
	}
	
	public void addManager(StoreBranchManager manager) {
		managers.add(manager);
	}
	
	public void removeManager(StoreBranchManager manager) {
		managers.remove(manager);
	}
	
	public void updateBonus(StoreBranchManager manager, float bonus) {
		// Update bonus
	}
	
	public void salaryDeduction(StoreBranchManager manager, float deduction) {
		manager.setSalary(manager.getSalary() - deduction);
	}
	
	public void salaryDeductionByPercentage(StoreBranchManager manager, float deductionPercentage) {
		manager.setSalary(manager.getSalary() * (1 - deductionPercentage));
	}
}
