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
	
	public int addBranch(String address, String id) {
		int slot = availableSlot();
		StoreBranchManager assignedManager = getAssignedBranchManager(id);
		if (assignedManager == null)
			return -1;
		
		StoreBranch newBranch = new StoreBranch(slot + 1, address, assignedManager);
		branchs.add(slot, newBranch);
		return slot + 1;
	}
	
	public int addBranch(StoreBranch newBranch) {
		int slot = -1;
		try {
			if (getBranch(newBranch.getBranchNumber()) != null)
				return -1;
		} 
		finally {
			slot = availableSlot();
			newBranch.setBranchNumber(slot + 1);
			branchs.add(slot, newBranch);
			slot += 1;
		}
		return slot;
	}
	
	public void removeBranch(StoreBranch branch) {
		branchs.remove(branch);
	}
	
	public StoreBranch getBranch(int branchNumber) {
		StoreBranch curBranch = new StoreBranch();
		curBranch.setBranchNumber(branchNumber);
		for (StoreBranch branch : branchs)
			if (branch.equals(curBranch))
				return branch;
		return null;
	}
	
	public StoreBranchManager getAssignedBranchManager(String id) {
		Personnel assignedPersonnel = null;
		PersonnelManagementService personnelService = new PersonnelManagementService();
		for (StoreBranch branch : branchs) {
			personnelService.setPersonnels(branch.getPersonnels());
			assignedPersonnel = personnelService.searchPersonnel(id);
			if (assignedPersonnel == null)
				continue;
			personnelService.removePersonnel(assignedPersonnel);
		}
		return (StoreBranchManager) assignedPersonnel;
	}
	
	public void assignBranchManager(String id, int branchNumber) {
		StoreBranch assignedBranch = getBranch(branchNumber);
		if (assignedBranch == null)
			return;
		
		StoreBranchManager assignedManager = getAssignedBranchManager(id);
		
		StoreBranchManager oldManager = 
				(new StoreManagerManagementService())
				.searchManager(branchNumber);
		
		if (oldManager != null) {
			Personnel personnel = (Personnel) oldManager;
			assignedBranch.getPersonnels().remove(oldManager);
			assignedBranch.getPersonnels().add(personnel);
		}
		
		assignedBranch.setBranchManager(assignedManager);
	}
	
}
