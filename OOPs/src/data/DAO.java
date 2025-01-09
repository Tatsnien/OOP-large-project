package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import personnel.Account;
import personnel.Cashier;
import personnel.Director;
import personnel.Employee;
import personnel.Personnel;
import personnel.Staff;
import personnel.StoreBranchManager;
import system.notice.Notice;

public class DAO {
	
	public Set<String> listFiles(String dir) {
	    return Stream.of(new File("resources/" + dir).listFiles())
	      .filter(file -> !file.isDirectory())
	      .map(File::getName)
	      .collect(Collectors.toSet());
	}
	
	public List<StoreBranch> getBranchFromFiles() {
		List<StoreBranch> branchs = new ArrayList<>();
		Set<String> files = listFiles("branch");
		
		for (String filename : files) {
			String path = "resources/branch/" + filename;
			try {
				File file = new File(path);
			    Scanner scanner = new Scanner(file);
			    
			    StoreBranch branch = new StoreBranch(
			    		Integer.parseInt(filename.substring(0, filename.length() - 4)), 
			    		scanner.nextLine().strip());
			    branchs.add(branch);
			    
			    scanner.close();
			} catch (FileNotFoundException e) {
		    	System.out.println("File not found.");
		    	e.printStackTrace();
		    } 
			catch (Exception e){
				System.out.println("Some errors occur while reading " + path);
			}
		}
		
		return branchs;
	}
	
	public List<Personnel> getPersonnelFromFiles() {
		List<Personnel> personnels = new ArrayList<>();
		Set<String> files = listFiles("personnel");
		
		for (String filename : files) {
			String path = "resources/personnel/" + filename;
			try {
				File file = new File(path);
			    Scanner scanner = new Scanner(file);
			    
			    String position = scanner.nextLine().strip();
			    String name 	= scanner.nextLine().strip();
			    float salary	= Float.parseFloat(scanner.nextLine().strip());
			    String id		= filename.substring(0, filename.length() - 4);
			    String password = scanner.nextLine().strip();
			    
			    if (position.equals("Director"))
			    	personnels.add(new Director(name, salary, new Account(id, password), position));
			    else {
			    	int branchNb = Integer.parseInt(scanner.nextLine().strip());
			    	
			    	if (position.equals("Cashier"))
			    		personnels.add(new Cashier(name, salary, new Account(id, password), position, branchNb));
			    	else if (position.equals("Staff"))
			    		personnels.add(new Staff(name, salary, new Account(id, password), position, branchNb));
			    	else if (position.equals("Manager"))
			    		personnels.add(new StoreBranchManager(name, salary, new Account(id, password), position, branchNb));
			    	System.out.println(id + " " + position);
			    }
			    
			    scanner.close();
			} catch (FileNotFoundException e) {
		    	System.out.println("File not found.");
		    	e.printStackTrace();
		    } catch (Exception e){
				System.out.println("Some errors occur while reading " + path);
			}
		}
		
		return personnels;
	}
	
	public void getChainFromFiles(StoreChain chain) {
		chain.setBranchs(getBranchFromFiles());
		addPersonnelsToBranches(chain);
		
	}
	
	public List<Item> getItemFromFiles() {
	    List<Item> items = new ArrayList<>();
	    Set<String> files = listFiles("items");
	    
	    for (String filename : files) {
	        String path = "resources/items/" + filename;
	        try {
	            File file = new File(path);
	            Scanner scanner = new Scanner(file);
	            String itemType = scanner.nextLine().strip();
	            String name = scanner.nextLine().strip();
                    String barcode = scanner.nextLine().strip();

	            if (itemType.equals("Book")) {
	               
	                String author = scanner.nextLine().strip();
	                String publisher = scanner.nextLine().strip();
	                String isbn = scanner.nextLine().strip();
	                float price = Float.parseFloat(scanner.nextLine().strip());
	                items.add(new Book(name, barcode, author, publisher, isbn, price));
	            } else if (itemType.equals("Stationary")) {
	               
	                String type = scanner.nextLine().strip();
	                float price = Float.parseFloat(scanner.nextLine().strip());
	                items.add(new Stationary(name, barcode, type, price));
	            } else if (itemType.equals("Toy")) {
	               
	                String brand = scanner.nextLine().strip();
	                int[] suitableAges = {Integer.parseInt(scanner.nextLine().strip()), Integer.parseInt(scanner.nextLine().strip())};
	                String toyType = scanner.nextLine().strip();
	                float price = Float.parseFloat(scanner.nextLine().strip());
	                items.add(new Toy(name, barcode, brand, suitableAges, toyType, price));
	            } 
	            
	            scanner.close();
	        } catch (FileNotFoundException e) {
		    	System.out.println("File not found.");
		    	e.printStackTrace();
		    } 
			catch (Exception e){
				System.out.println("Some errors occur while reading " + path);
			}
		}
	    return items;
	}

	public List<Expense> getExpenseFromFiles() {

	}

	public List<Notice> getNoticeFromFiles() {

	}
	
	public void savePersonnels(List<Personnel> personnels) {
		
	}
	
	public void saveItems(List<ItemGroup> groups) {
		
	}
	
	public void saveNotices(List<Notice> notices) {
		
	}
	
	private void addPersonnelsToBranches(StoreChain chain) {
		for (Personnel personnel : getPersonnelFromFiles())
			if (personnel instanceof Director)
				chain.setDirector((Director) personnel);
			else {
				Employee employee = (Employee) personnel;
				StoreBranch branch = chain.getBranch(employee.getWorkingBranchNumber());
				branch.addEmployee(employee);
			}
	}

}
