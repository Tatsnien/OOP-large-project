package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.SalaryExpense;
import personnel.Personnel;

public class PersonnelManagementService {
	
	private List<Personnel> personnels;
	private ExpenseManagementService expenseService;
	
	public PersonnelManagementService() {
		this.personnels = new ArrayList<>();
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
	
	public void addPersonnel(Personnel personnel) {
		personnels.add(personnel);
		this.expenseService.addExpense(new SalaryExpense(personnel));
	}
	
	public void removePersonnel(Personnel personnel) {
		personnels.remove(personnel);
		for (Expense expense : expenseService.getExpenses()) 
			if (expense instanceof SalaryExpense && 
					((SalaryExpense) expense).getPersonnel().equals(personnel)) {
				expenseService.removeExpense(expense);
				return;
			}
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

}
