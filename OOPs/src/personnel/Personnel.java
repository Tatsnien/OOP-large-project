package personnel;

public class Personnel {
	
	private String name;
	private float salary;
	private Account account;
	protected String position;
	
	public Personnel(String name) {
		this.name = name;
		this.salary = 0;
	}
	
	public String getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			return account.equals(((Personnel) obj).getAccount());
		}
		catch (Exception e) {
			return false;
		}
	}

}
