package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public void addGroupsToBranches(StoreChain chain) {
		List<ItemGroup> groups = new ArrayList<>();
		List<Integer> branches = new ArrayList<>();
		Set<String> files = listFiles("item");
		
		for (String filename : files) {
			String path = "resources/item/" + filename;
			try (Scanner scanner = new Scanner(new File(path))) {
				int branch = Integer.parseInt(scanner.nextLine().strip());
				String itemType = scanner.nextLine().strip();
				String name = scanner.nextLine().strip();
				String barcode = scanner.nextLine().strip();
				int qty = Integer.parseInt(scanner.nextLine().strip());
				
				branches.add(branch);
				if (itemType.equals("Book")) {
					String author = scanner.nextLine().strip();
					String publisher = scanner.nextLine().strip();
					String isbn = scanner.nextLine().strip();
					float price = Float.parseFloat(scanner.nextLine().strip());
					groups.add(new ItemGroup(new Book(name, barcode, author, publisher, isbn, price), qty));
					
				} else if (itemType.equals("Stationery")) {
					String type = scanner.nextLine().strip();
					float price = Float.parseFloat(scanner.nextLine().strip());
					groups.add(new ItemGroup(new Stationary(name, barcode, type, price), qty));
					
				} else if (itemType.equals("Toy")) {
					String brand = scanner.nextLine().strip();
					int[] suitableAges = {Integer.parseInt(scanner.nextLine().strip()), Integer.parseInt(scanner.nextLine().strip())};
					String type = scanner.nextLine().strip();
					float price = Float.parseFloat(scanner.nextLine().strip());
					groups.add(new ItemGroup(new Toy(name, barcode, brand, suitableAges, type, price), qty));
				} 
			} catch (FileNotFoundException e) {
		    	System.out.println("File not found: " + path);
		    	e.printStackTrace();
		    } 
			catch (Exception e) {
				System.out.println("Error reading " + path);
			}
		}

		for (int i = 0; i < groups.size(); ++i) {
			int branch = branches.get(i);
			chain.getBranch(branch).addGroup(groups.get(i));
		}
	}
	
	public void addExpensesToBranches(StoreChain chain) {
		List<Expense> expenses = new ArrayList<>();
		List<Integer> branches = new ArrayList<>();
		Set<String> files = listFiles("expense");
		
		for (String filename : files) {
			String path = "resources/expense/" + filename;
			try (Scanner scanner = new Scanner(new File(path))) {
				int branch = Integer.parseInt(scanner.nextLine().strip());
				String expenseName = scanner.nextLine().strip();
				double expenseValue = Double.parseDouble(scanner.nextLine().strip());
				int frequency = Integer.parseInt(scanner.nextLine().strip());
				double base = Double.parseDouble(scanner.nextLine().strip());
				
				Expense expense = new RecurringExpense(expenseName, expenseValue, frequency, base);
				if (branch == -1) {
					for (StoreBranch storeBranch : chain.getBranchs()) {
						branches.add(storeBranch.getBranchNumber());
						expenses.add(expense);
					}
				}
				else {
					branches.add(branch);
					expenses.add(expense);
				}
			} catch (FileNotFoundException e) {
		    	System.out.println("File not found: " + path);
		    	e.printStackTrace();
		    } catch (Exception e) {
				System.out.println("Error reading " + path);
			}
		}

		System.out.println(expenses.size());
		for (int i = 0; i < expenses.size(); ++i) {
			int branch = branches.get(i);
			chain.getBranch(branch).addExpense(expenses.get(i));
		}
	}
	
	public void addNoticesToPersonnels(List<Personnel> personnels) {
        Set<String> files = listFiles("notice");
 
        for (String filename : files) {
               String path = "resources/notice/" + filename;
               try (Scanner scanner = new Scanner(new File(path))) {
                    String senderID = scanner.nextLine().strip();
                    String receiverID = scanner.nextLine().strip();
                    String title = scanner.nextLine().strip();
                    String content = scanner.nextLine().strip();
                    
                    int idxSender = personnels.indexOf(senderID);
                    int idxReceiver = personnels.indexOf(receiverID);
	                Notice notice = new Notice(personnels.get(idxSender), personnels.get(idxReceiver), title);
	                notice.setContent(content);
	                notice.setDate(filename);
	                personnels.get(idxReceiver).getAccount().addNotice(notice);
		     } catch (FileNotFoundException e) {
		         System.out.println("File not found: " + path);
		         e.printStackTrace();
		     } catch (Exception e) {
		                System.out.println("Error reading " + path);
		     }
		 }
	}
	
	public void getChainFromFiles(StoreChain chain) {
		chain.setBranchs(getBranchFromFiles());
		addPersonnelsToBranches(chain);
		addGroupsToBranches(chain);
		addExpensesToBranches(chain);
		addNoticesToPersonnels(chain.getPersonnels());
		
	}
	
	public void savePersonnels(List<Personnel> personnels) {
		for (Personnel personnel : personnels) {
			String path = "resources/personnel/" + personnel.getId() + ".txt"; // Use getter for ID
			try (FileWriter writer = new FileWriter(path)) {
				writer.write(personnel.getPosition() + "\n"); // Use getter for position
				writer.write(personnel.getName() + "\n"); // Use getter for name
				writer.write(personnel.getSalary() + "\n"); // Use getter for salary
				writer.write(personnel.getAccount().getPassword() + "\n"); // Use getter for password
				if (personnel instanceof Employee) {
					writer.write(((Employee) personnel).getWorkingBranchNumber() + "\n"); // Use getter for branch number
				}
			} catch (IOException e) {
				System.out.println("Error saving personnel: " + personnel.getId());
				e.printStackTrace();
			}
		}
	}

	public void saveItems(List<Item> items) {
		for (Item item : items) {
			String path = "resources/items/" + item.getBarcode() + ".txt"; // Use getter for barcode
			try (FileWriter writer = new FileWriter(path)) {
				writer.write(item.getItemType() + "\n"); // Use getter for item type
				writer.write(item.getName() + "\n"); // Use getter for name
				writer.write(item.getBarcode() + "\n"); // Use getter for barcode
				
				if (item instanceof Book) {
					Book book = (Book) item;
					writer.write(book.getAuthor() + "\n"); // Use getter for author
					writer.write(book.getPublisher() + "\n"); // Use getter for publisher
					writer.write(book.getIsbn() + "\n"); // Use getter for ISBN
					writer.write(book.getPrice() + "\n"); // Use getter for price
				} else if (item instanceof Stationary) {
					Stationary stationary = (Stationary) item;
					writer.write(stationary.getType() + "\n"); // Use getter for type
					writer.write(stationary.getPrice() + "\n"); // Use getter for price
				} else if (item instanceof Toy) {
					Toy toy = (Toy) item;
					writer.write(toy.getBrand() + "\n"); // Use getter for brand
					writer.write(toy.getSuitableAges() + "\n"); // Use getter for suitable age
					writer.write(toy.getType() + "\n"); // Use getter for type
					writer.write(toy.getPrice() + "\n"); // Use getter for price
				}
			} catch (IOException e) {
				System.out.println("Error saving item: " + item.getBarcode());
				e.printStackTrace();
			}
		}
	}
	
	public void saveNotices(List<Notice> notices) {
         for (Notice notice : notices) {
                  String path = "resources/notices/" + notice.getTitle() + ".txt"; // Use title as filename
                  try (FileWriter writer = new FileWriter(path)) {
                      writer.write(notice.getSender() + "\n"); // Write sender
                      writer.write(notice.getReceiver() + "\n"); // Write receiver
                      writer.write(notice.getTitle() + "\n"); // Write title
                      writer.write(notice.getContent() + "\n"); // Write content
           
                   } catch (IOException e) {
                              System.out.println("Error saving notice: " + notice.getTitle());
                               e.printStackTrace();
                           }  
                   }
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