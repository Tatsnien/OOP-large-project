package system.service;

import java.util.List;

import data.StoreBranch;
import data.StoreBranchDAO;
import data.StoreChain;
import personnel.Personnel;
import personnel.StoreBranchManager;

public class StoreBranchManagementService {
	
	private List<StoreBranch> branchs;
	
	public StoreBranchManagementService() {
		this.branchs = StoreChain.getBranchs();
	}
	
	private int availableSlot() {
		for (int i = 0; i < branchs.size(); ++i)
			if (branchs.get(i).getBranchNumber() != i + 1)
				return i;
		return branchs.size();
	}
	
	public void addBranch(String address) {
		int slot = availableSlot();
		StoreBranch newBranch = new StoreBranch();
		newBranch.setAddress(address);
		newBranch.setBranchNumber(slot + 1);
		branchs.add(slot, newBranch);
	}
	
	public void addBranch(StoreBranch newBranch) {
		try {
			if (getBranch(newBranch.getBranchNumber()) != null)
				return;
		} 
		finally {
			int slot = availableSlot();
			newBranch.setBranchNumber(slot + 1);
			branchs.add(slot, newBranch);
		}
	}
	
	public StoreBranch getBranch(int branchNumber) {
		StoreBranch curBranch = new StoreBranch();
		curBranch.setBranchNumber(branchNumber);
		for (StoreBranch branch : branchs)
			if (branch.equals(curBranch))
				return branch;
		return null;
	}
	
	public void assignBranchManager(String id, int branchNumber) {
		StoreBranch assignedBranch = getBranch(branchNumber);
		if (assignedBranch == null)
			return;
		
		Personnel assignedPersonnel = null;
		PersonnelManagementService personnelService = new PersonnelManagementService();
		for (StoreBranch branch : branchs) {
			personnelService.setPersonnels(branch.getPersonnels());
			assignedPersonnel = personnelService.searchPersonnel(id);
			if (assignedPersonnel == null)
				continue;
			personnelService.removePersonnel(assignedPersonnel);
		}
		if (assignedPersonnel == null)
			return;
		
		StoreBranchManager oldManager = 
				(new StoreManagerManagementService())
				.searchManager(branchNumber);
		
		if (oldManager != null) {
			Personnel personnel = (Personnel) oldManager;
			assignedBranch.getPersonnels().remove(oldManager);
			assignedBranch.getPersonnels().add(personnel);
		}
		
		assignedBranch.setBranchManager((StoreBranchManager) assignedPersonnel);
	}
	
}
