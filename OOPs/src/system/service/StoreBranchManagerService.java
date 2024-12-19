package system.service;

import data.StoreBranch;

public class StoreBranchManagerService {
	
	private StoreBranch branch;

	public StoreBranchManagerService(StoreBranch branch) {
		this.branch = branch;
	}

	public StoreBranch getBranch() {
		return branch;
	}
	
}
