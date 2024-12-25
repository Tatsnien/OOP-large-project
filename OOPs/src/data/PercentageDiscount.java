package data;

import java.util.ArrayList;

class PercentageDiscount extends Discount {
	private float percent;
	public PercentageDiscount(CustomDate startDate, CustomDate endDate, ArrayList<Item> appliedItem, float percent) {
		super(startDate, endDate, appliedItem);
		this.percent = percent;
	}	
	
}
