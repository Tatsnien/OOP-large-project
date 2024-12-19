package data;

public class Date {
	private int day;
	private int month;
	private int year;

	public void Date(int day, int month, int year) {
		// TODO Auto-generated constructor stub
		this.day= day;
		this.month= month;
		this.year=year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	
	@Override
    public String toString() {
        return "Day " + this.getDay() +
                " - Month: " + this.getMonth() +
                " - Year: " + this.getYear();
    }

}
