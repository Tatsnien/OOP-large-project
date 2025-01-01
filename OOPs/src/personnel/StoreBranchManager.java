package personnel;

import data.StoreBranch;
import data.StoreChain;
import system.service.ExpenseManagementService;
import system.service.ManagerService;

public class StoreBranchManager extends Personnel implements ManagerService{
	public StoreBranchManager(String name) {
		super(name);
		this.position = "Unassigned Manager";
	}

	@Override
	public double getRevenue() {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchManagerName().equals(this))
				return branch.getIncome();
		return 0;
	}

	@Override
	public double getProfit() {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchManagerName().equals(this)) {
				double expense = (new ExpenseManagementService(branch)).getTotalExpense();
				return getRevenue() - expense;
			}
		return 0;
	}
	
}
