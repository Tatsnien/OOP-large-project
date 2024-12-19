package data;

public class Discount {
	private Date startDate;
	private Date endDate;
	private Item[] appliedItem;
	

	public Discount(Date startDate, Date endDate, Item[] appliedItem) {
		this.startDate = startDate;
		this.endDate = endDate;
		this. appliedItem = appliedItem;
	
	}

}
