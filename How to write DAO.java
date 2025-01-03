/**
 *      THIS FILE IS AN INSTRUCTION. DO NOT TRY TO RUN THIS FILE.
 * 
 * 1)   What is DAO:
 *      DAO (Data Access Object) is used to separate the data importing/ exporting
 *      part from the main functions. The main functions DO NOT NEED to know
 *      how the data is read or written, but only care about the availability of
 *      the data when running program.
 * 
 * 2)   DAO in our project:
 *      DAO class in our project is dedicated to reading data from .txt files
 * 
 *                          remember, ONLY .TXT
 * 
 *      This helps the program be testing-friendly:
 *      the data can be easily viewed and modified even outside the program.
 * 
 *      DAO will read and write .txt files in specific folders, 
 *      located in OOPs/resources. Those folders include:
 *      -   branch
 *      -   notice      [UNFINISHED]     
 *      -   expense     [UNFINISHED]
 *      -   item        [UNFINISHED]
 *      -   personnel
 * 
 * 3)   Your tasks
 *      -   Write DAO method for [UNFINISHED] folder in (2), both READ and WRITE functions.
 *      -   Test INTENSIVELY, ensure that no exception will occur.
 * 
 * 4)   How to write DAO:
 */

public class DAO {
/**
 *      [DONE]
 *      This method will get all the file names in "dir" folder
 * 
 *      Example:
 *      Set<String> files = listFiles("branch");
 *      ->  files = {"1.txt", "2.txt", "3.txt"}
 * 
 */
    public Set<String> listFiles(String dir);

/**
 *      Your task is writing functions like the below code
 * 
 *      The method must:
 *      -   Walk through all files in the folder
 *      -   Read data by a fixed order in the file
 *      -   Initialize the object from the data and add it to a list
 *      -   Return the list of objects that you have initialized
 * 
 *      The order of data in files should follow the constructor signature.
 *      The file's name must be something unique to that object (id, barcode,...)
 */
    public List<Personnel> getPersonnelFromFiles() {
        // List of objects to return
		List<Personnel> personnels = new ArrayList<>();

        // "files" include all file names in "personnel" folder
		Set<String> files = listFiles("personnel");
		
		for (String filename : files) {
			String path = "resources/personnel/" + filename;
			try {
				File file = new File(path);
			    Scanner scanner = new Scanner(file);
			    
                /**
                 *  File content example:
                 *  Cashier
                 *  Nguyen Van A
                 *  2000.0
                 *  01
                 *  1
                 */
			    String position = scanner.nextLine().strip();
			    String name 	= scanner.nextLine().strip();
			    float salary	= Float.parseFloat(scanner.nextLine().strip());
			    String id		= filename.substring(0, filename.length() - 4);
			    String password = scanner.nextLine().strip();
			    
                // Remember that String is a class, so you must use A.equals(B), never use A == B
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
			    	System.out.println(id);
			    }
			    
			    scanner.close();

            // Handle exception
			} catch (FileNotFoundException e) {
		    	System.out.println("File not found.");
		    	e.printStackTrace();
		    } catch (Exception e){
				System.out.println("Some errors occur while reading " + path);
			}
		}
		
		return personnels;
	}
}