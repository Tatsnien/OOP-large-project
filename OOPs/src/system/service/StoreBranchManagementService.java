package system.service;

import java.util.ArrayList;
import java.util.List;

import data.StoreBranch;
import data.StoreBranchDAO;

public class StoreBranchManagementService {
	
	private StoreBranch branch;
	private StoreBranchDAO storeBranchDAO;
	
	public StoreBranch getBranch() {
		return branch;
	}
	
	public void setBranch(StoreBranch branch) {
		this.branch = branch;
	}
	
	public StoreBranchDAO getStoreBranchDAO() {
		return storeBranchDAO;
	}
	
	public void setStoreBranchDAO(StoreBranchDAO storeBranchDAO) {
		this.storeBranchDAO = storeBranchDAO;
	}
	
}
