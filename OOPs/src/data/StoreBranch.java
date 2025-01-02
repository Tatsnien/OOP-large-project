package data;

import java.util.ArrayList;
import java.util.List;

import payment.Bill;
import personnel.Employee;
import personnel.Personnel;
import personnel.StoreBranchManager;

public class StoreBranch implements IStoreEntity {
	
	private List<Employee> employees;
	private List<ItemGroup> groups;
	private List<Bill> bills;
	private List<Expense> expenses;
	private float income;
	private int branchNumber;
	private String address;
	private StoreBranchManager branchManager;
	
	public StoreBranch(int branchNumber, String address) {
		this.employees = new ArrayList<>();
		this.groups = new ArrayList<>();
		this.bills = new ArrayList<>();
		this.expenses = new ArrayList<>();
		this.income = 0;
		this.branchNumber = branchNumber;
		this.address = address;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public List<ItemGroup> getGroups() {
		return groups;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}

	public List<Bill> getBills() {
		return bills;
	}
	
	public float getIncome() {
		return income;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void setGroups(List<ItemGroup> groups) {
		this.groups = groups;
	}
	
	public int getBranchNumber() {
		return branchNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public StoreBranchManager getBranchManager() {
		return branchManager;
	}
	
	public String getBranchManagerName() {
		return branchManager.getName();
	}
	
	public void setBranchNumber(int branchNumber) {
		this.branchNumber = branchNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setBranchManager(StoreBranchManager branchManager) {
		this.branchManager = branchManager;
	}
	
	public void addBill(Bill bill) {
		this.bills.add(bill);
		this.income += bill.getTotalAmount();
	}
	
	public void addEmployee(Employee employee) {
		employee.setWorkingBranchNumber(branchNumber);
		employees.add(employee);
		if (employee instanceof StoreBranchManager)
			setBranchManager((StoreBranchManager) employee);
		expenses.add(new SalaryExpense(employee));
	}
	
	public boolean removeEmployee(Employee employee) {
		try {
			this.employees.remove(employee);
			return true;
		}
		catch (Exception e) {
			System.out.println("This employee is not in the branch.");
		}
		return false;
	}
	
	public void addExpense(Employee employee) {
		this.expenses.add(new SalaryExpense(employee));
	}
	
	public void addItem(Item item, int qty) {
		if (this.groups.contains(item)){
			int idx = this.groups.indexOf(item);
			ItemGroup curItem = this.groups.get(idx);
			curItem.setQty(curItem.getQty() + qty);
		}
		else
			this.groups.add(new ItemGroup(item, qty));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StoreBranch)
			return this.branchNumber == ((StoreBranch) obj).branchNumber;
		return false;
	}
	
}
