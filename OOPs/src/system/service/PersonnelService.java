package system.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Expense;
import data.SalaryExpense;
import data.StoreBranch;
import data.StoreChain;
import personnel.Director;
import personnel.Employee;
import personnel.Personnel;

public class PersonnelService {
	
	private static StoreChain chain;
	private List<Employee> employees;
	private ExpenseService expenseService;
	
	public PersonnelService(Director director) {
		this.employees = chain.getEmployees();
		this.expenseService = new ExpenseService(director);
	}
	
	public PersonnelService(int branchNumber) {
		this.employees = chain.getBranch(branchNumber).getEmployees();
		this.expenseService = new ExpenseService(branchNumber);
	}
	
	public PersonnelService(StoreBranch storeBranch) {
		this.employees = storeBranch.getEmployees();
		this.expenseService = new ExpenseService(storeBranch);
	}

	public PersonnelService(List<Employee> employees, List<Expense> expenses) {
		this.employees = employees;
		expenseService = new ExpenseService(expenses);
	}

	public static void setChain(StoreChain chain) {
		PersonnelService.chain = chain;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void setExpense(List<Expense> expenses) {
		this.expenseService = new ExpenseService(expenses);
	}
	
	public Employee searchEmployee(String id) {
		for (Employee employee : employees)
			if (employee.getAccount().getId().equals(id))
				return employee;
		return null;
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
		this.expenseService.addExpense(new SalaryExpense(employee));
	}
	
	public String getSpareId() {
		List<Integer> id = new ArrayList<>();
		for (Personnel personnel : chain.getPersonnels())
			id.add(Integer.parseInt(personnel.getId()));
		Collections.sort(id);
		int cnt = 1;
		for (int i : id)
			if (i == cnt)
				++cnt;
			else if (cnt < 10) 	return "0" + cnt;
			else 				return "" + cnt;
		if (cnt < 10) 	return "0" + cnt;
		else 			return "" + cnt;
	}
	
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
		this.expenseService.removeExpense(new SalaryExpense(employee));
	}
	
	public void updateBonus(Employee employee, float bonus) {
		// Update bonus
	}
	
	public void salaryDeduction(Employee employee, float deduction) {
		employee.setSalary(employee.getSalary() - deduction);
		for (Expense expense : expenseService.getExpenses()) {
			if (!(expense instanceof SalaryExpense))
				continue;
			
			SalaryExpense salaryExpense = (SalaryExpense) expense;
			
			if (!salaryExpense.getPersonnel().equals(employee))
				continue;
			
			salaryExpense.setSalary(employee.getSalary() - deduction);
		}
	}
	
	public void salaryDeductionByPercentage(Employee employee, float deductionPercentage) {
		salaryDeduction(employee, employee.getSalary() * deductionPercentage);
	}

}
