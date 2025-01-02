package data;

import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import payment.Bill;
import personnel.Director;
import personnel.Employee;
import personnel.Personnel;

public class StoreChain implements IStoreEntity{
	private ObservableList<StoreBranch> branchs;
	private Director director;
	private float basicSalary;
	
	public StoreChain() {
		branchs = FXCollections.observableArrayList();	
	}
	
	public StoreChain(Director director) {
		branchs = FXCollections.observableArrayList();	
		this.director = director;
	}
	
	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Director getDirector() {
		return director;
	}
	
	public void setDirector(Director director) {
		this.director = director;
	}

	public List<StoreBranch> getBranchs() {
		return branchs;
	}
	
	public void setBranchs(List<StoreBranch> branchs) {
		this.branchs.addAll(branchs);
	}

	public void addBranch(StoreBranch newBranch) {
		if (branchs.contains(newBranch)) {
			System.out.println("Branch " + newBranch.getBranchNumber() + " has existed. Can't be added to store chain.");			
			return;
		}
		
		branchs.add(newBranch);
		System.out.println("Branch " + newBranch.getBranchNumber() + " has been added to store chain.");
	}
	
	public void removeBranch(StoreBranch removedBranch) {
		if (branchs.contains(removedBranch)) {
			branchs.remove(removedBranch);
			System.out.println("Branch " + removedBranch.getBranchNumber() + " has been removed from store chain.");		
			return;
		}
		
		System.out.println("Branch " + removedBranch.getBranchNumber() + " doesn't exist.");
	}
	
	public StoreBranch getBranch(int branchNumber) {
		/**
		 * return StoreBranch | null 
		 */
		for (StoreBranch branch : branchs)
			if (branch.getBranchNumber() == branchNumber)
				return branch;
		System.out.println("Branch " + branchNumber + " not found.");
		return null;
	}
	
	public StoreBranch searchEmployeeBranch(String id) {
		for (StoreBranch branch : branchs)
			for (Employee employee : branch.getEmployees())
				if (employee.getAccount().getId().equals(id))
					return branch;
		System.out.println("Employee's ID " + id + " not found.");
		return null;
	}
	
	public Personnel searchPersonnel(String id) {
		for (Personnel personnel : getPersonnels())
			if (personnel.getAccount().getId().equals(id))
				return personnel;
		System.out.println("Personnel's ID " + id + " not found.");
		return null;
	}
	
	public List<Personnel> getPersonnels(){
		List<Personnel> personnels = new ArrayList<>();
		personnels.add(director);
		personnels.addAll(getEmployees());
		return personnels;
	}
	
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (StoreBranch branch : branchs)
			employees.addAll(branch.getEmployees());
		return employees;
	}

	public List<Bill> getBills() {
		List<Bill> bills = new ArrayList<>();
		for (StoreBranch branch : branchs)
			bills.addAll(branch.getBills());
		return bills;
	}

	public float getIncome() {
		float income = 0;
		for (StoreBranch branch : branchs)
			income += branch.getIncome();
		return income;
	}
	
	public List<Expense> getExpenses(){
		List<Expense> expenses = new ArrayList<>();
		if (director != null)
			expenses.add(new SalaryExpense(director));
		for (StoreBranch branch : branchs)
			for (Expense expense : branch.getExpenses())
				expenses.add(expense);
		return expenses;
	}

	public List<ItemGroup> getGroups() {
		List<ItemGroup> itemGroups = new ArrayList<>();
		for (StoreBranch branch : branchs)
			for (ItemGroup itemGroup : branch.getGroups())
				itemGroups.add(itemGroup);
		return itemGroups;
	}
	
}
