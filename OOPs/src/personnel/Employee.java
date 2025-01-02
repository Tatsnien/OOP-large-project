package personnel;

public class Employee extends Personnel {
	
	private int workingBranchNumber;

	public Employee(String name) {
		super(name);
	}
	
	public Employee(String name, float salary, Account account, String position) {
		super(name, salary, account, position);
	}
	
	public int getWorkingBranchNumber() {
		return workingBranchNumber;
	}

	public void setWorkingBranchNumber(int workingBranchNumber) {
		this.workingBranchNumber = workingBranchNumber;
	}

}
