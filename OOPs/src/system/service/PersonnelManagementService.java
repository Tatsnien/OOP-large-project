package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.SalaryExpense;
import data.StoreBranch;
import personnel.Account;
import personnel.Director;
import personnel.Personnel;

public class PersonnelManagementService {
	
	protected List<Personnel> personnels;
	protected ExpenseManagementService expenseService;
	
	public PersonnelManagementService(Director director) {
		this.personnels = new ArrayList<>();
		this.expenseService = new ExpenseManagementService(director);
	}
	
	public PersonnelManagementService(StoreBranch storeBranch) {
		this.personnels = storeBranch.getPersonnels();
		this.expenseService = new ExpenseManagementService(storeBranch);
	}

	public PersonnelManagementService(List<Personnel> personnels, List<Expense> expenses) {
		this.personnels = personnels;
		expenseService = new ExpenseManagementService(expenses);
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}
	
	public void setExpense(List<Expense> expenses) {
		this.expenseService = new ExpenseManagementService(expenses);
	}
	
	public Personnel searchPersonnel(String id) {
		for (Personnel personnel : personnels)
			if (personnel.getAccount().getId().equals(id))
				return personnel;
		return null;
	}
	
	public void addPersonnel(Personnel personnel) {
		personnels.add(personnel);
		this.expenseService.addExpense(new SalaryExpense(personnel));
	}
	
	public void removePersonnel(Personnel personnel) {
		personnels.remove(personnel);
		this.expenseService.removeExpense(new SalaryExpense(personnel));
	}
	
	public void updateBonus(Personnel personnel, float bonus) {
		// Update bonus
	}
	
	public void salaryDeduction(Personnel personnel, float deduction) {
		personnel.setSalary(personnel.getSalary() - deduction);
		for (Expense expense : expenseService.getExpenses()) {
			if (!(expense instanceof SalaryExpense))
				continue;
			
			SalaryExpense salaryExpense = (SalaryExpense) expense;
			
			if (!salaryExpense.getPersonnel().equals(personnel))
				continue;
			
			salaryExpense.setSalary(personnel.getSalary() - deduction);
		}
	}
	
	public void salaryDeductionByPercentage(Personnel personnel, float deductionPercentage) {
		salaryDeduction(personnel, personnel.getSalary() * deductionPercentage);
	}
	
	public PersonnelManagementService() {
		this.personnels = new ArrayList<>();
		this.expenseService = new ExpenseManagementService();
	}

}
