package payment;

import customer.Cart;

public class CashPaymentService extends PaymentService {

	public CashPaymentService(Cart cart) {
		super(cart);
	}

}
