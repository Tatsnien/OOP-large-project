package personnel;
import system.service.ItemService;

public class Staff extends Employee {
	
	private ItemService itemService;
	
	public Staff(String name) {
		super(name);
		this.salaryMultiplier = 1.5f;
		this.position = "Staff";
	}
	
	public Staff(String name, float salaryMultiplier, Account account, String position, int branchNb) {
<<<<<<< HEAD
		super(name, salaryMultiplier, account, position);
=======
		super(name, salary, account, position);
>>>>>>> 65e67d12641d0ba135d0e54b7fe3bd60a969f288
		this.salaryMultiplier = 1.5f;
		this.position = "Staff";
		this.setWorkingBranchNumber(branchNb);
		itemService = new ItemService(this.getWorkingBranchNumber());
	}

	public ItemService getItemService() {
		return itemService;
	}
	
}