package data;

import personnel.Personnel;

public class SalaryExpense extends Expense {
    private Personnel personnel;
   
	public SalaryExpense(Personnel personnel) {
	    super();
	    this.expenseName = "Salary" + personnel.getAccount().getId();
	    this.personnel = personnel;
	    this.expenseValue = personnel.getSalary();
	}

	public void setSalary(float salary) {
		this.personnel.setSalary(salary);
		this.expenseValue = salary;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SalaryExpense)
			return ((SalaryExpense) obj).getPersonnel().equals(personnel);
		return false;
	}
	
}
