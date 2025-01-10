package personnel;

import system.notice.Notice;

public class Personnel {
	
	private static float BASIC_SALARY = 3450000.0f;
	
	private String name;
	protected float salaryMultiplier;
	private float bonuses;
	private Account account;
	protected String position;
	
	public Personnel(String name) {
		this.name = name;
		this.salaryMultiplier = 1.0f;
	}
	
	public Personnel(String name, float salaryMultiplier, Account account, String position) {
		this.name = name;
		this.salaryMultiplier = salaryMultiplier;
		this.account = account;
		this.position = position;
		this.bonuses = 0.0f;
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
		float salary = (BASIC_SALARY * salaryMultiplier + bonuses);
		return ((int)(salary * 100)) / 100f;
	}

	public void setSalary(float salaryMultiplier) {
		this.salaryMultiplier = salaryMultiplier;
	}
	
	public void setBasicSalary(float basicSalary) {
		BASIC_SALARY = basicSalary;
	}
	
	public float getBonuses() {
		return bonuses;
	}
	
	public void addBonuses(float bonuses) {
		this.bonuses += bonuses;
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
