package data;

import personnel.Personnel;
import personnel.StoreBranchManager;
import system.service.StoreBranchManagerService;

public class StoreBranch extends StoreEntity {
	private int branchNumber;
	private String address;
	private StoreBranchManager branchManager;
	
	public int getBranchNumber() {
		return branchNumber;
	}

	public String getAddress() {
		return address;
	}

	public StoreBranchManager getBranchManager() {
		return branchManager;
	}

	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBranchManager(StoreBranchManager branchManager) {
		this.branchManager = branchManager;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StoreBranch)
			return this.branchNumber == ((StoreBranch) obj).branchNumber;
		return false;
	}
	
	//Testing purpose: Deleted at final stage
	public void addPersonnel(Personnel person) {
		if (person instanceof StoreBranchManager) {
			StoreBranchManager manager = (StoreBranchManager) person;
			manager.setService(new StoreBranchManagerService(this));
			this.getPersonnels().add(manager);
		}
		else
			this.getPersonnels().add(person);
	}
	
}
