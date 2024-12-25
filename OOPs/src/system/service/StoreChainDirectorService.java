package system.service;

import data.StoreChain;

public class StoreChainDirectorService extends ManagerService{
	
	private StoreBranchManagementService branchService;
	private StoreManagerManagementService managerManagementService;

	public StoreChainDirectorService() {
		this.branchService = new StoreBranchManagementService();
		this.managerManagementService = new StoreManagerManagementService();
		this.expenseService = new ExpenseManagementService((new StoreChain()).getExpenses());
	}

	public StoreBranchManagementService getBranchService() {
		return branchService;
	}

	public StoreManagerManagementService getManagerManagementService() {
		return managerManagementService;
	}

	@Override
	public double getRevenue() {
		return (new StoreChain()).getIncome();
	}

	@Override
	public double getProfit() {
		return getRevenue() - this.expenseService.getTotalExpense();
	}
	
}
