package personnel;
import system.service.StoreBranchPublicService;
import system.notice.Report;

public class Staff extends Personnel {
	private StoreBranchPublicService service;

	public Staff(String name, StoreBranchPublicService service) {
		super(name);
		this.position = "Staff";
		this.service = service;
	}
	public void setService(StoreBranchPublicService service) {
		this.service = service;
	}

	public StoreBranchPublicService getService() {
		return service;
	}

	//	public Report report() {
	//	}
}
