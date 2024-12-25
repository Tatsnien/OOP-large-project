package personnel;
import customer.*;

public class Cashier extends Personnel{
	private Customer customer;
	
	public Cashier(String name) {
		super(name);
		this.position = "Cashier";
	}
	public void createMembershipAccount() {
		MemberCustomer newMember = new MemberCustomer();
		return newMember;
		// TODO Link with reading input
	}
	public boolean checkMembershipStatus() {
		return customer instanceof MemberCustomer;
	}
	public void makePaymentService() {
		// TODO add later
	}
}
