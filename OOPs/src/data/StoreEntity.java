package data;

import java.util.*;

import customer.*;
import personnel.*;

public class StoreEntity {
	
	private List<Personnel> personnels = new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	private float basicSalary;
	private static List<MemberCustomer> memberCustomers;
	private static List<Discount> discounts;
	
	public StoreEntity() {
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

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setMemberCustomers(List<MemberCustomer> memberCustomers) {
		this.memberCustomers= memberCustomers;
	}


}
