package data;

class PercentageDiscount extends Discount {
	private float percent;
	
	public PercentageDiscount(Date startDate, Date endDate, Item[] appliedItem, float percent) {
		super(startDate, endDate, appliedItem);
		this.percent = percent;
		// TODO Auto-generated constructor stub
	}
	
	

	public PercentageDiscount(float percent) {  
		this.percent= percent;
	}
	
	
}
