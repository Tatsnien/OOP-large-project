package data;

public class SalaryExpense extends Expense {
    private Personnel personnel;
    private float salary;
   
public SalaryExpense(String expenseName, double expenseValue, Personnel personnel, float salary) {
    super(expenseName, expenseValue);
    this.personnel = personnel;
    this.salary = salary  
  }

}
