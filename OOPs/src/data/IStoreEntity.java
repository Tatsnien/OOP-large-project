package data;

import java.util.*;

import customer.*;
import payment.Bill;
import personnel.*;

public interface IStoreEntity {
	
	public List<Expense> getExpenses();
	public List<Bill> getBills();
	public List<ItemGroup> getGroups();
	public float getIncome();

}
