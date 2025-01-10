package personnel;

import system.service.ItemService;

public class Cashier extends Employee{
	
	private ItemService itemService;
	
	public Cashier(String name) {
		super(name);
		this.salaryMultiplier = 1.25f;
		this.position = "Cashier";
	}

	public Cashier(String name, float salaryMultiplier, Account account, String position, int branchNb) {
		super(name, salaryMultiplier, account, position);
		this.salaryMultiplier = 1.25f;
		this.position = "Cashier";
		this.setWorkingBranchNumber(branchNb);
		this.itemService = new ItemService(this.getWorkingBranchNumber());
	}

	public ItemService getItemService() {
		return itemService;
	}
	
}