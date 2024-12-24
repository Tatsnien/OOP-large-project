package payment;

import customer.Cart;

public class PaymentService {

	protected PaymentMethod paymentMethod;
	protected Cart cart;
	protected Bill bill;
	
	protected Bill createBill() {
		return null;
	}
	
	protected void printBill() {
	
	}
	
	protected boolean checkValidation() {
		return true;
	}
	
	public PaymentService(Cart cart) {
		
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		
	}
	
	public void makePayment() {
		
	}
	
	public void updateItemPurchasePrice() {
		// update item.purchasePrice by subtract discounts
		// we currently don't add tax for each item, but may charge 10% at a whole
	}
	
	public float calculateItemDiscount() {
		// calculate discount applied for item
		return 0;
	}
	
	public float calculateSubTotal() {
		return 0;
	}
	
	public float calculateTax() {
		return 0;
	}
	
	public float calculateDiscount() {
		return 0;
	}
	
	public float calculateTotal() {
		return 0;
	}
	
}
