package data;

class AdditionFreeDiscount extends Discount {
	private int boughtNumber;
	private int additionNumber;

	public AdditionFreeDiscount(Date startDate, Date endDate, Item[] appliedItem, int boughtNumber, int additionNumber) {
		super(startDate, endDate,appliedItem);
		this.boughtNumber=boughtNumber;
		this.additionNumber=additionNumber; 
		// TODO Auto-generated constructor stub
	}

}
