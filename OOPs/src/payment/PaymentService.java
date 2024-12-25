package payment;

import javax.swing.JOptionPane;

import customer.Cart;
import customer.Customer;
import customer.MemberCustomer;
import data.Discount;
import data.Item;

public class PaymentService {

	protected PaymentMethod paymentMethod;
	protected Cart cart;
	protected Bill bill;
	protected Customer customer;
	
	protected Bill createBill() {
		return new Bill(this);
	}
	
	protected void printBill() {
		if (this.bill != null) {
			this.bill.printBill();
		} else {
			this.bill = this.createBill();
			this.bill.printBill();
		}
	}
	
	protected boolean checkValidation() {
		// we are not implementing a full payment authorization system in our project
		JOptionPane.showMessageDialog(null, "PaymentSuccessful");
		return true;
	}
	
	public PaymentService(Cart cart) {
		this.cart = cart;
	}
	
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void makePayment() {
		// to be overridden
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
		float subTotal = 0;
		for (Item item: cart.getItemsOrdered())
			subTotal += item.getPurchasePrice();
		return subTotal;
	}
	
	public float calculateTax() {
		return this.calculateSubTotal() * 0.1f;
	}
	
	public float calculateDiscount() {
		return 0;
	}
	
	public float calculateTotal() {
		return this.calculateSubTotal() + this.calculateTax() - this.calculateDiscount();
	}
	
}