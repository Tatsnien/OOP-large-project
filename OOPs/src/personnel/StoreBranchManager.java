package personnel;

import system.service.StoreBranchManagerService;

public class StoreBranchManager extends Personnel {
	StoreBranchManagerService service;

	public StoreBranchManager(String name) {
		super(name);
		this.position = "Unassigned Manager";
	}

	public StoreBranchManagerService getService() {
		return service;
	}

	public void setService(StoreBranchManagerService service) {
		this.service = service;
		this.position = "Branch " + service.getBranch().getBranchNumber() + " Manager";
	}
	
}
