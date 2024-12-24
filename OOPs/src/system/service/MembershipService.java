package system.service;

import java.util.List;

import customer.MemberCustomer;
import data.StoreBranch;

public class MembershipService {
	private List<MemberCustomer> memberCustomers;
	
	public MembershipService(){
		memberCustomers = StoreBranch.getMemberCustomers();
	}
	
	public MemberCustomer searchMemberCustomer(String phoneNumber) {
		for (MemberCustomer memberCustomer : memberCustomers)
			if (memberCustomer.getPhoneNumber().equals(phoneNumber))
				return memberCustomer;
		return null;
	}
	
	public void addMemberCustomer(MemberCustomer newMember) {
		memberCustomers.add(newMember);	
	}
	
	public void removeMemberCustomer(MemberCustomer removingMember) {
		memberCustomers.remove(removingMember);
	}
	
}
