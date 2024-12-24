package customer;

import java.util.ArrayList;
import java.util.List;

import data.CustomDate;
import data.Discount;

public class MemberCustomer extends Customer {
	private String name;
	private int phoneNumber;
	private List<Discount> discounts;
	private CustomDate joinTime;
	
	public MemberCustomer(int phoneNumber, String name){
		this.phoneNumber = phoneNumber;
		this.name = name;
		discounts = new ArrayList<>();
		joinTime = new CustomDate();
	}
	
	public String getName() {
		return name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public CustomDate getJoinTime() {
		return joinTime;
	}
	
	@Override
	public boolean isMemberCustomer() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MemberCustomer) {
			return this.phoneNumber == ((MemberCustomer) obj).getPhoneNumber();
		}
		return false;
	}
	
}
