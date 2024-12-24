package data;

import java.util.Date;

public class Discount {
	private CustomDate startDate;
	private CustomDate endDate;
	private Item[] appliedItem;

	public Discount(CustomDate startDate, CustomDate endDate, Item[] appliedItem) {
		this.startDate = startDate;
		this.endDate = endDate;
		this. appliedItem = appliedItem;
	}

}
