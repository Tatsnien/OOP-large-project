package payment;

import customer.Cart;

public class OnlinePaymentService extends PaymentService {

	public OnlinePaymentService(Cart cart) {
		super(cart);
	}

	public void makePayment() {
		boolean validated = false;
		while (validated == false) {
			validated = checkValidation();
		}
	}
}
