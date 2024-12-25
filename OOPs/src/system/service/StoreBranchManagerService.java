package system.service;

import data.StoreBranch;

public class StoreBranchManagerService {
	
	private StoreBranch storeBranch;
	private ItemManagementService itemService;
	private IncomeManagementService incomeService;
	private PersonnelManagementService personnelService;
	
	public StoreBranchManagerService (){}
	
	public StoreBranchManagerService (StoreBranch storeBranch){
		this.storeBranch = storeBranch;
		this.itemService = new ItemManagementService(storeBranch.getItems());
		this.incomeService = new IncomeManagementService(storeBranch);
		this.personnelService = new PersonnelManagementService(storeBranch.getPersonnels(), storeBranch.getExpenses());
	}
	
	public StoreBranch getBranch() {
		return storeBranch;
	}

	public void setBranch(StoreBranch storeBranch) {
		this.storeBranch = storeBranch;
	}

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
