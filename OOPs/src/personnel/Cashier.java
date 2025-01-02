package personnel;

public class Cashier extends Employee{
	
	public Cashier(String name) {
		super(name);
		this.position = "Cashier";
	}

	public Cashier(String name, float salary, Account account, String position, int branchNb) {
		super(name, salary, account, position);
		this.position = "Cashier";
		this.setWorkingBranchNumber(branchNb);
	}
	
}
