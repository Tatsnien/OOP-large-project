package data;

import java.util.ArrayList;

class AdditionFreeDiscount extends Discount {
	private int boughtNumber;
	private int additionNumber;
	private int nbBought;
	private int nbAddition; 

	public AdditionFreeDiscount(CustomDate startDate, CustomDate endDate, ArrayList<Item> appliedItem, int boughtNumber, int additionNumber) {
		super(startDate, endDate,appliedItem);
		this.boughtNumber = boughtNumber;
		this.additionNumber = additionNumber; 
	}

}
