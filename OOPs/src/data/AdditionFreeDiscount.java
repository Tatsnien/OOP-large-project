package data;

class AdditionFreeDiscount extends Discount {
	private int boughtNumber;
	private int additionNumber;
	private int nbBought;
	private int nbAddition; 

	public AdditionFreeDiscount(CustomDate startDate, CustomDate endDate, Item[] appliedItem, int boughtNumber, int additionNumber) {
		super(startDate, endDate,appliedItem);
		this.boughtNumber = boughtNumber;
		this.additionNumber = additionNumber; 
	}

}
