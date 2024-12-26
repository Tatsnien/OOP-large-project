package payment;

import java.util.Date;

import javax.swing.JOptionPane;

import customer.Cart;

public class Bill {

	private static String storeName;
	private static String storeAddress;
	private String billID;
	private Date issueDate;
	private Cart cart;
	private float subTotal;
	private float tax;
	private float discount;
	private float totalAmount;
	private float receivedAmount;
	private float changeAmount;
	
	private void setStoreInformation() {
		storeName = JOptionPane.showInputDialog(null, "Please enter store name: ", "System");
		storeAddress = JOptionPane.showInputDialog(null, "Please enter store address: ", "System");
	}
	
	private void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Bill(PaymentService paymentService) {
		this.cart = paymentService.cart;
		this.subTotal = paymentService.calculateSubTotal();
		this.tax = paymentService.calculateTax();
		this.discount = paymentService.calculateDiscount();
		this.totalAmount = paymentService.calculateTotal();
		if (paymentService instanceof CashPaymentService) {
			if (paymentService.checkValidation()) {
				this.receivedAmount = ((CashPaymentService) paymentService).getPaymentTotal();
				this.changeAmount = this.receivedAmount - this.totalAmount;
			}
		} else {
			if (paymentService.checkValidation()) {
				this.receivedAmount = this.totalAmount;
				this.changeAmount = 0.0f;
			}
		}
	}
	
	public void printBill() {
		// TODO
	}
	
	public float getTotalAmount() {
		return this.totalAmount;
	}
}
