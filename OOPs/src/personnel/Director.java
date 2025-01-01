package personnel;

import data.StoreBranch;
import data.StoreChain;
import system.service.ExpenseManagementService;
import system.service.ManagerService;

public class Director extends Personnel implements ManagerService{

	public Director(String name) {
		super(name);
		this.position = "Director";
	}

	@Override
	public double getRevenue() {
		return (new StoreChain()).getIncome();
	}

	@Override
	public double getProfit() {
		double expense = (new ExpenseManagementService()).getTotalExpense();
		return getRevenue() - expense;
	}
	
}
