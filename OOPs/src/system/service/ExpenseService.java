package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Expense;
import data.RecurringExpense;
import data.StoreBranch;
import data.StoreChain;
import personnel.Director;

public class ExpenseService {
	
	private static StoreChain chain;
	private List<Expense> expenses;
	
	public ExpenseService(Director director) {
		this.expenses = chain.getExpenses();
	}
	
	public ExpenseService(int branchNumber) {
		this.expenses = chain.getBranch(branchNumber).getExpenses();
	}
	
	public ExpenseService(StoreBranch branch) {
		this.expenses = branch.getExpenses();
	}
	
	public ExpenseService(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public static void setChain(StoreChain chain) {
		ExpenseService.chain = chain;
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
