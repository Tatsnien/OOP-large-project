package personnel;

import data.StoreBranch;
import data.StoreChain;
import system.service.ExpenseService;
import system.service.IncomeService;
import system.service.ItemService;
import system.service.IManagerService;
import system.service.PersonnelService;
import system.service.StoreBranchService;

public class Director extends Personnel implements IManagerService{
	
	private ExpenseService expenseService;
	private IncomeService incomeService;
	private ItemService itemService;
	private PersonnelService personnelService;
	private StoreBranchService branchService;

	public Director(String name) {
		super(name);
		this.position = "Director";
		this.expenseService = new ExpenseService(this);
		this.incomeService = new IncomeService(this);
		this.itemService = new ItemService(this);
		this.personnelService = new PersonnelService(this);
		this.branchService = new StoreBranchService(this);
	}

	public Director(String name, float salary, Account account, String position) {
		super(position, salary, account, position);
		this.position = "Director";
		this.expenseService = new ExpenseService(this);
		this.incomeService = new IncomeService(this);
		this.itemService = new ItemService(this);
		this.personnelService = new PersonnelService(this);
		this.branchService = new StoreBranchService(this);
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

	public StoreBranchService getBranchService() {
		return branchService;
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
