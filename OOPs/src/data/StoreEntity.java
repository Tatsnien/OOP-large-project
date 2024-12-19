package data;

import java.util.*;

import customer.*;
import personnel.*;

public class StoreEntity {
	
	private List<Personnel> personnels = new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	private List<MemberCustomer> memberCustomers = new ArrayList<>();
	private float basicSalary;
	
	public List<Personnel> getPersonnels() {
		return personnels;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public List<MemberCustomer> getMemberCustomers() {
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

	public void setMemberCustomers(List<MemberCustomer> memberCustomers) {
		this.memberCustomers = memberCustomers;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

}
