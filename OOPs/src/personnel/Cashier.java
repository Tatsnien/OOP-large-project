package personnel;

import system.service.ItemService;

public class Cashier extends Employee{
	
	private ItemService itemService;
	
	public Cashier(String name) {
		super(name);
		this.position = "Cashier";
	}

	public Cashier(String name, float salary, Account account, String position, int branchNb) {
		super(name, salary, account, position);
		this.position = "Cashier";
		this.setWorkingBranchNumber(branchNb);
		this.itemService = new ItemService(this.getWorkingBranchNumber());
	}

	public ItemService getItemService() {
		return itemService;
	}
	
}
