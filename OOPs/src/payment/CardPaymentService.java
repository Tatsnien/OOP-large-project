package payment;

import customer.Cart;

public class CardPaymentService extends PaymentService {

	public CardPaymentService(Cart cart) {
		super(cart);
	}
	
	public void makePayment() {
		boolean validated = false;
		while (validated == false) {
			validated = checkValidation();
		}
	}
}
