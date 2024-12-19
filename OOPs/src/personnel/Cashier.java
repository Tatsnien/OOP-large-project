package personnel;
import customer.*;

public class Cashier extends Personnel{
	private Customer customer;
	
	public Cashier(String name) {
		super(name);
		this.position = "Cashier";
	}

}
