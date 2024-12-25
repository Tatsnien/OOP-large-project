package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.RecurringExpense;

public class ExpenseManagementService {
	private List<Expense> expenses;
	
	public ExpenseManagementService() {
		this.expenses = new ArrayList<Expense>();
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
