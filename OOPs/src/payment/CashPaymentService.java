package payment;

import javax.swing.JOptionPane;
import customer.Cart;

public class CashPaymentService extends PaymentService {

	public CashPaymentService(Cart cart) {
		super(cart);
	}
	
	protected float getPaymentTotal() {
		String num = JOptionPane.showInputDialog(null, "Enter amount paid", "System");
		try {
			Float numFloat = Float.parseFloat(num);
			return numFloat;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid amount entered, please try again.");
			return getPaymentTotal();
		}
	}
	
	public void makePayment() {
		boolean validated = false;
		while (validated == false) {
			float status = getPaymentTotal();
			validated = checkValidation();
		}
	}

}
