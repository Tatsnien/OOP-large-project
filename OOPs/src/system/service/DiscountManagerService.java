package system.service;

import java.util.ArrayList;
import java.util.List;

import data.Discount;

public class DiscountManagerService {

private List<Discount> expenses;
	
	public DiscountManagerService() {
		this.expenses = new ArrayList<Discount>();
	}
	
	public DiscountManagerService(List<Discount> expenses) {
		this.expenses = expenses;
	}
	
	public List<Discount> getDiscounts() {
		return expenses;
	}

	public void setDiscounts(List<Discount> expenses) {
		this.expenses = expenses;
	}
	
	public void addDiscount(Discount expense) {
		expenses.add(expense);
	}
	
	public void removeDiscount(Discount expense) {
		expenses.remove(expense);
	}
	
}
