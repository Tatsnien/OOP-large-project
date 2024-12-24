package data;

class PercentageDiscount extends Discount {
	private float percent;
	public PercentageDiscount(CustomDate startDate, CustomDate endDate, Item[] appliedItem, float percent) {
		super(startDate, endDate, appliedItem);
		this.percent = percent;
	}	
	
}
