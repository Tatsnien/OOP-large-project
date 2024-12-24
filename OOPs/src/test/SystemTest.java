package test;

import customer.MemberCustomer;
import data.*;
import personnel.*;
import system.LoginScreen;
import system.notice.Notice;

public class SystemTest {
	
	public static void main(String[] args) {
		StoreBranch branch1 = new StoreBranch();
		StoreBranch branch2 = new StoreBranch();
		StoreBranch branch3 = new StoreBranch();
		
		branch1.setBranchNumber(1);
		branch2.setBranchNumber(2);
		branch3.setBranchNumber(3);
		
		StoreChain storeChain = new StoreChain();
		storeChain.addBranch(branch1);
		storeChain.addBranch(branch2);
		storeChain.addBranch(branch3);
		
		// Must add a constraint that a person can only work at a store at a time.
		Personnel cashier1 = new Cashier("Nguyen Van A");
		Personnel staff1 = new Staff("Tran Thi B");
		Personnel manager1 = new StoreBranchManager("Le Van C");
		Personnel staff2 = new Staff("Hoang Thi D");
		
		// Id should be sequential to reduce duplicated
		cashier1.setAccount(new Account("01", ""));
		staff1.setAccount(new Account("02", "2"));
		manager1.setAccount(new Account("03", "3"));
		staff2.setAccount(new Account("04", "4"));
		
		branch1.addPersonnel(cashier1);
		branch1.addPersonnel(staff1);
		branch1.addPersonnel(manager1);
		branch2.addPersonnel(staff2);
		
		Notice notice1 = new Notice();
		Notice notice2 = new Notice(staff1);
		Notice notice3 = new Notice(manager1);
		notice1.setTitle("You was absent today");
		notice3.setTitle("Hello World");
		cashier1.getAccount().addNotice(notice1);
		cashier1.getAccount().addNotice(notice2);
		cashier1.getAccount().addNotice(notice3);
		
		StoreEntity.getMemberCustomers().add(new MemberCustomer("0987987987", "Le Van Tu"));
		StoreEntity.getMemberCustomers().add(new MemberCustomer("0123456789", "Do Van Cuong"));
		
		LoginScreen.main(args);
	}
	
}
