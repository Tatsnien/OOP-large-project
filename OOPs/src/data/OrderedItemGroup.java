package data;

public class OrderedItemGroup {
	
	private Item item;
	private int qty;
	
	public OrderedItemGroup(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}
	
	public Item getItem() {
        return item;
    }
	
	public float getPrice() {
        return item.getPrice();
    }

	public String getName() {
		return item.getName();
	}

	public String getBarcode() {
		return item.getBarcode();
	}
	
	public int getQty() {
		return qty;
	}
	
	public float getTotal() {
		return getPrice() * qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item)
			return item.equals((Item) obj);
		if (obj instanceof OrderedItemGroup)
			return item.equals(((OrderedItemGroup) obj).getItem());
		return false;
	}
	
}
