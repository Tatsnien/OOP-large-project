package data;

public class RecurringExpense extends Expense {
	private int frequency;
	private double base;

	public RecurringExpense(String expenseName, double expenseValue, int frequency, double base) {
		super(expenseName, expenseValue); 
		this.frequency = frequency;
		this.base = base;
		calculateExpenseValue();
	}

	public int getFrequency() {
		return frequency;
	}
	
	public void setFrequency(int frequency) {
		this.frequency = frequency;
		calculateExpenseValue();
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
		calculateExpenseValue();
	}
	
	private void calculateExpenseValue() {
		this.expenseValue = frequency * base;
	}
	
}
