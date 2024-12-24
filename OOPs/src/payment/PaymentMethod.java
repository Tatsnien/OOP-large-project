package payment;

public class PaymentMethod {
	private String ownername;
	private long number;
	private double balance;
	private String issuer;

public PaymentMethod(String ownername, long number, double balance,String issuer) {
		
	this.ownername = ownername;
	this.number = number;
	this.balance = balance;
	this.issuer = issuer;
	
	}
	public String getOwnername() {
		return ownername;
	}

	public long getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String getIssuer() {
		return issuer;
	}

}