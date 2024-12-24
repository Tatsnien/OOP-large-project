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
	
	public ItemProperty(Item item) {
		this.item = item;
	}
	
	public StringProperty nameProperty() {
		return new SimpleStringProperty(item.name);
	}
	
	public IntegerProperty barcodeProperty() {
		return new SimpleIntegerProperty(item.barcode);
	}
	
	public FloatProperty purchasePriceProperty() {
		return new SimpleFloatProperty(item.purchasePrice);
	}
	
	public IntegerProperty quantity() {
		return new SimpleIntegerProperty(item.quantity);
	}
	
	public FloatProperty sellingPriceProperty() {
		return new SimpleFloatProperty(item.sellingPrice);
	}
	
}
