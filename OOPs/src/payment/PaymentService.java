package payment;

import java.util.List;

import javax.swing.JOptionPane;

import customer.Cart;
import data.ItemGroup;

public class PaymentService {

	protected PaymentMethod paymentMethod;
	protected Cart cart;
	protected Bill bill;
	
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
	
	public float calculateSubTotal() {
		float subTotal = 0;
		List<ItemGroup> groups = cart.getGroups();
		for (ItemGroup group : groups)
			subTotal += group.getPrice() * group.getQty();
		return subTotal;
	}
	
	public float calculateTax() {
		return formattedPrice(this.calculateSubTotal() * 0.1f);
	}
	
	public float calculateDiscount() {
		return 0;
	}
	
	public float calculateTotal() {
		return formattedPrice(this.calculateSubTotal() + this.calculateTax() - this.calculateDiscount());
	}
	
	public float formattedPrice(float price) {
		return Math.round(price * 100) / 100.0f;
	}
	
}