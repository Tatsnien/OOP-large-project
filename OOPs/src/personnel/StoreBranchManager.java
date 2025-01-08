package personnel;

import data.StoreChain;
import system.service.ExpenseService;
import system.service.IncomeService;
import system.service.ItemService;
import system.service.IManagerService;
import system.service.PersonnelService;

public class StoreBranchManager extends Employee implements IManagerService{
	
	private ExpenseService expenseService;
	private IncomeService incomeService;
	private ItemService itemService;
	private PersonnelService personnelService;
	
	public StoreBranchManager(String name) {
		super(name);
		this.position = "Manager";
	}
	
	public StoreBranchManager(String name, float salary, Account account, String position, int branchNb) {
		super(name, salary, account, position);
		this.position = "Manager";
		this.setWorkingBranchNumber(branchNb);
		this.setServices();
	}
	
	public void setServices() {
		this.expenseService 	= new ExpenseService(this.getWorkingBranchNumber());
		this.incomeService 		= new IncomeService(this.getWorkingBranchNumber());
		this.itemService 		= new ItemService(this.getWorkingBranchNumber());
		this.personnelService 	= new PersonnelService(this.getWorkingBranchNumber());
	}

	public ExpenseService getExpenseService() {
		return expenseService;
	}


	public IncomeService getIncomeService() {
		return incomeService;
	}


	public ItemService getItemService() {
		return itemService;
	}


	public PersonnelService getPersonnelService() {
		return personnelService;
	}

	@Override
	public double getRevenue() {
		return incomeService.getIncome();
	}

	@Override
	public double getProfit() {
		return getRevenue() - expenseService.getTotalExpense();
	}
	
}
