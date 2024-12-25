package system.service;

public class StoreBranchManagerService {
	
	private ItemManagementService itemService;
	private IncomeManagementService incomeService;
	private PersonnelManagementService personnelService;
	
	public ItemManagementService getItemService() {
		return itemService;
	}
	
	public IncomeManagementService getIncomeService() {
		return incomeService;
	}
	
	public PersonnelManagementService getPersonnelService() {
		return personnelService;
	}

	public void setItemService(ItemManagementService itemService) {
		this.itemService = itemService;
	}

	public void setIncomeService(IncomeManagementService incomeService) {
		this.incomeService = incomeService;
	}

	public void setPersonnelService(PersonnelManagementService personnelService) {
		this.personnelService = personnelService;
	}
		
}
