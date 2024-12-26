package data;

import java.util.*;

import customer.*;
import payment.Bill;
import personnel.*;

public class StoreEntity {
	
	protected List<Personnel> personnels;
	protected List<Item> items;
	protected List<Integer> qty;
	protected List<Bill> bills;
	protected List<Expense> expenses;
	protected float income;
	private float basicSalary;
	private static List<MemberCustomer> memberCustomers;
	private static List<Discount> discounts;
	
	public StoreEntity() {
		personnels = new ArrayList<>();
		items = new ArrayList<>();
		qty = new ArrayList<>();
		bills = new ArrayList<>();
		expenses = new ArrayList<>();
		income = 0;
		if (discounts == null)
			discounts = new ArrayList<>();
		if (memberCustomers == null)
			memberCustomers = new ArrayList<>();
	}
	
	public List<Personnel> getPersonnels() {
		return personnels;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public List<Bill> getBills() {
		return bills;
	}
	
	public List<Integer> getQty() {
		return qty;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public float getIncome() {
		return income;
	}

	public static List<MemberCustomer> getMemberCustomers() {
		return memberCustomers;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void setQty(List<Integer> qty) {
		this.qty = qty;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

}
