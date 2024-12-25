package system.service;

import java.util.List;

import personnel.StoreBranchManager;

public class StoreChainDirectorService extends ManagerService{
	
	private StoreBranchManagementService branchService;
	private StoreManagerManagementService managerManagementService;

	public StoreChainDirectorService() {
		this.branchService = new StoreBranchManagementService();
		this.managerManagementService = new StoreManagerManagementService();
	}

	@Override
	public float viewRevenue() {
		float revenue = 0;
		List<StoreBranchManager> managers = managerManagementService.getManagers();
		for (StoreBranchManager manager : managers) {
			
		}
		return revenue;
	}

	@Override
	public float viewProfit() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
