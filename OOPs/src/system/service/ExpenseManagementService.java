package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.RecurringExpense;
import data.StoreBranch;
import data.StoreChain;
import personnel.Director;

public class ExpenseManagementService {
	private List<Expense> expenses;
	
	public ExpenseManagementService(Director director) {
		this.expenses = (new StoreChain()).getExpenses();
	}
	
	public ExpenseManagementService(int branchNumber) {
		for (StoreBranch branch : StoreChain.getBranchs())
			if (branch.getBranchNumber() == branchNumber) {
				expenses = branch.getExpenses();
				return;
			}
	}
	
	public ExpenseManagementService(StoreBranch branch) {
		expenses = branch.getExpenses();
	}
	
	public ExpenseManagementService(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public double getTotalExpense() {
		double total = 0;
		for (Expense expense : expenses)
			total += expense.getExpenseValue();
		return total;
	}

	public void updateRecurringExpense(RecurringExpense expense, int freq) {
		expense.setFrequency(freq);
	}
	
	public void updateRecurringExpense(RecurringExpense expense, double base) {
		expense.setBase(base);
	}
	
	public void addExpense(Expense expense) {
		expenses.add(expense);
	}
	
	public void removeExpense(Expense expense) {
		expenses.remove(expense);
	}
	
}
