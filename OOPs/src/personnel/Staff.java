package personnel;
import system.notice.Report;
import system.service.ItemService;

public class Staff extends Employee {
	
	private ItemService service;
	
	public Staff(String name) {
		super(name);
		this.position = "Staff";
	}
	
	public Staff(String name, float salary, Account account, String position, int branchNb) {
		super(name, salary, account, position);
		this.position = "Staff";
		this.setWorkingBranchNumber(branchNb);
	}
	
	public void setService(ItemService service) {
		this.service = service;
	}

	public ItemService getService() {
		return service;
	}

	//	public Report report() {
	//	}
}
