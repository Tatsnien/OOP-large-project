package customer;

public class Customer {
	private Cart cart;
	
	public Customer() {
		this.cart = new Cart();
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void registerMembershipAccount(int phoneNumber, String name) {
		
	}
	
	public boolean isMemberCustomer() {
		return false;
	}
	
	public void payByCash() {
		
	}
	
	public void payByCard() {
		
	}
	
	public void payOnline() {
		
	}
	
}
