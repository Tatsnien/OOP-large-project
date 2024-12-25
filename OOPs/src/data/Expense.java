package data;

public class Expense {
	protected String expenseName;
	protected double expenseValue;
	
	public Expense() {};

	public Expense(String expenseName, double expenseValue) {
		this.expenseName = expenseName;
		this.expenseValue = expenseValue;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public double getExpenseValue() {
		return expenseValue;
	}

}
