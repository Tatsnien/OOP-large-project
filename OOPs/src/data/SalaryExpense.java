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
	
}
