package system.service;

public abstract class ManagerService {
	
	protected ExpenseManagementService expenseService;

	public abstract double getRevenue();
	
	public abstract double getProfit();
	
}
