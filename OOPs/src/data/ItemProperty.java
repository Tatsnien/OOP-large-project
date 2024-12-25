package data;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Used for data-binding to table only
public class ItemProperty{

	Item item;
	int qty;
	
	public ItemProperty(Item item, int qty) {
		this.item = item;
		this.qty = qty;
	}
	
	public StringProperty nameProperty() {
		return new SimpleStringProperty(item.name);
	}
	
	public StringProperty barcodeProperty() {
		return new SimpleStringProperty(item.barcode);
	}
	
	public FloatProperty purchasePriceProperty() {
		return new SimpleFloatProperty(item.price);
	}
	
	public IntegerProperty quantity() {
		return new SimpleIntegerProperty(qty);
	}
	
	public FloatProperty sellingPriceProperty() {
		return new SimpleFloatProperty(item.price);
	}
	
}
