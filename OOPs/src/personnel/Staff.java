package personnel;
import system.notice.Report;
import system.service.ItemManagementService;

public class Staff extends Personnel {
	private ItemManagementService service;
	
	public Staff(String name) {
		super(name);
		this.position = "Staff";
	}

	public Staff(String name, ItemManagementService service) {
		super(name);
		this.position = "Staff";
		this.service = service;
	}
	public void setService(ItemManagementService service) {
		this.service = service;
	}

	public ItemManagementService getService() {
		return service;
	}

	//	public Report report() {
	//	}
}
