package data;

class GiftDiscount extends Discount {
	private int boughtNumber;
	private int additionNumber;
	private Item[] additionItem;

	public GiftDiscount(CustomDate startDate, CustomDate endDate, Item[] appliedItem, int boughtNumber, int additionNumber, Item[] additionItem) {
		super(startDate, endDate,appliedItem);
		this.boughtNumber=boughtNumber;
		this.additionNumber=additionNumber; 
		this.additionItem=additionItem;
		// TODO Auto-generated constructor stub
	}

}
