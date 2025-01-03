package test;

import system.LoginScreen;

public class SystemTest {
	
	public static void main(String[] args) {
//		StoreBranch branch1 = new StoreBranch(1, "Dong Da");
//		StoreBranch branch2 = new StoreBranch(2, "Hai Ba Trung");
//		StoreBranch branch3 = new StoreBranch(3, "Tay Ho");
//		
//		StoreChain storeChain = new StoreChain();
//		storeChain.addBranch(branch1);
//		storeChain.addBranch(branch2);
//		storeChain.addBranch(branch3);
//		
//		// Must add a constraint that a person can only work at a store at a time.
//		Employee cashier1 = new Cashier("Nguyen Van A");
//		Employee staff1 = new Staff("Tran Thi B");
//		Employee manager1 = new StoreBranchManager("Le Van C");
//		Employee staff2 = new Staff("Hoang Thi D");
//		Director director = new Director("Tran Binh E");
//		Employee manager2 = new StoreBranchManager("Nguyen Thi F");
//		Employee manager3 = new StoreBranchManager("Nguyen Van G");
//		
//		// Id should be sequential to reduce duplicated
//		cashier1.setAccount(new Account("01", ""));
//		staff1.setAccount(new Account("02", ""));
//		manager1.setAccount(new Account("03", ""));
//		staff2.setAccount(new Account("04", "4"));
//		director.setAccount(new Account("05", ""));
//		manager2.setAccount(new Account("06", ""));
//		manager3.setAccount(new Account("07", ""));
//		
//		storeChain.setDirector(director);
//		branch1.addEmployee(cashier1);
//		branch1.addEmployee(staff1);
//		branch1.addEmployee(manager1);
//		branch2.addEmployee(staff2);
//		branch2.addEmployee(manager2);
//		branch3.addEmployee(manager3);
//		
//		branch1.setBranchManager((StoreBranchManager) manager1);
//		branch2.setBranchManager((StoreBranchManager) manager2);
//		branch3.setBranchManager((StoreBranchManager) manager3);
//		
//		Notice notice1 = new Notice();
//		Notice notice2 = new Notice(staff1);
//		Notice notice3 = new Notice(manager1);
//		notice1.setTitle("You was absent today");
//		notice3.setTitle("Hello World");
//		cashier1.getAccount().addNotice(notice1);
//		cashier1.getAccount().addNotice(notice2);
//		cashier1.getAccount().addNotice(notice3);
//		
//		ItemService itemService = new ItemService(branch1);
//		itemService.addBook("Calculus III", "0000", "Dao Tuan Anh", "NXB Bach Khoa", "0000", 100, 2);
//		itemService.addStationary("Staedtler 4H", "0001", "pencil", 3, 1);
//		itemService.addToy("Euler figure", "0002", "LoveMaths", new int[]{6, 18}, "figure", 10, 10);
//		itemService.addItem(new Book("Calculus: Early Transcendentals", "0003", "James Stewart", "Cengage Learning", "1285740629", 202), 15);		
		
		LoginScreen.main(args);
	}
	
}
