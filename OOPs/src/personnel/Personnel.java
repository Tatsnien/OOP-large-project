package personnel;

import system.notice.Notice;

public class Personnel {
	
	private String name;
	private float salary;
	private Account account;
	protected String position;
	
	public Personnel(String name) {
		this.name = name;
		this.salary = 0;
	}
	
	public Personnel(String name, float salary, Account account, String position) {
		this.name = name;
		this.salary = salary;
		this.account = account;
		this.position = position;
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
		return ((int) (salary * 100)) / 100.0f;
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
	
	public String getId() {
		return this.account.getId();
	}
	
	public String getNoticeTitles() {
		String titles = "";
		for (Notice notice : this.account.getNotices())
			titles += notice.getTitle() + "\n";
		return titles;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			if (obj instanceof String)
				return account.getId().equals((String) obj);
			else
				return account.equals(((Personnel) obj).getAccount());
		}
		catch (Exception e) {
			return false;
		}
	}

}
