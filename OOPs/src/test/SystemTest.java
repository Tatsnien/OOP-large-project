package test;

import customer.MemberCustomer;
import data.*;
import personnel.*;
import system.LoginScreen;
import system.notice.Notice;
import system.service.ItemManagementService;

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
		Director director = new Director("Tran Binh E");
		
		// Id should be sequential to reduce duplicated
		cashier1.setAccount(new Account("01", ""));
		staff1.setAccount(new Account("02", ""));
		manager1.setAccount(new Account("03", ""));
		staff2.setAccount(new Account("04", "4"));
		director.setAccount(new Account("05", ""));
		
		branch1.addPersonnel(cashier1);
		branch1.addPersonnel(staff1);
		branch1.addPersonnel(manager1);
		branch2.addPersonnel(staff2);
		StoreChain.setDirector(director);
		
		Notice notice1 = new Notice();
		Notice notice2 = new Notice(staff1);
		Notice notice3 = new Notice(manager1);
		notice1.setTitle("You was absent today");
		notice3.setTitle("Hello World");
		cashier1.getAccount().addNotice(notice1);
		cashier1.getAccount().addNotice(notice2);
		cashier1.getAccount().addNotice(notice3);
		
		ItemManagementService itemService = new ItemManagementService(branch1.getItems(), branch1.getQty());
		itemService.addBook("Calculus III", "0000", "Dao Tuan Anh", "NXB Bach Khoa", "0000", 100, 2);
		itemService.addStationary("Staedtler 4H", "0001", "pencil", 3, 1);
		itemService.addToy("Euler figure", "0002", "LoveMaths", new int[]{6, 18}, "figure", 10, 10);
		itemService.addItem(new Book("Calculus: Early Transcendentals", "0003", "James Stewart", "Cengage Learning", "1285740629", 202), 15);		
		
		LoginScreen.main(args);
	}
	
}
