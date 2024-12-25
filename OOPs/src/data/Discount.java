package data;

import java.util.ArrayList;
import java.util.Date;

public class Discount {
	private CustomDate startDate;
	private CustomDate endDate;
	public ArrayList<Item> appliedItem;

	public Discount(CustomDate startDate, CustomDate endDate, ArrayList appliedItem) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.appliedItem = appliedItem;
	}
	
	

}
