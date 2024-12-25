package data;

import java.util.ArrayList;

class GiftDiscount extends Discount {
	private int boughtNumber;
	private int additionNumber;
	private ArrayList<Item> additionItem;

	public GiftDiscount(CustomDate startDate, CustomDate endDate, ArrayList<Item> appliedItem, int boughtNumber, int additionNumber, ArrayList<Item> additionItem) {
		super(startDate, endDate,appliedItem);
		this.boughtNumber=boughtNumber;
		this.additionNumber=additionNumber; 
		this.additionItem=additionItem;
		// TODO Auto-generated constructor stub
	}

}
