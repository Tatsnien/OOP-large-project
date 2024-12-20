package data;

public cclass RecurringExpense extends Expense {
	private int frequency;

	public RecurringExpense(String expenseName, double expenseValue, int frequency) {
		super(expenseName, expenseValue); 
		this.frequency=frequency;
		// TODO Auto-generated constructor stub
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequency() {
		return frequency;
	}
	
}
