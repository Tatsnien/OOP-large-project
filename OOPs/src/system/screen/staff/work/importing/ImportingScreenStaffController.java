package system.screen.staff.work.importing;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.DAO;
import data.ItemGroup;
import data.Notice;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import personnel.Staff;
import system.screen.staff.home.HomeScreenStaff;
import system.screen.staff.profile.ProfileScreenStaff;
import system.screen.staff.work.check.CheckScreenStaff;
import system.service.ItemService;
import system.service.StoreBranchService;

public class ImportingScreenStaffController {
	
	private Staff staff;
	private JFrame frame;
	private ItemService itemService;
	private ItemService groups;
	
	public ImportingScreenStaffController(Staff staff) {
    	this.staff = staff;
    	this.itemService = this.staff.getItemService();
    	this.groups = new ItemService(new ArrayList<>());
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	@FXML
    private TableColumn<ItemGroup, String> colBarcode;

    @FXML
    private TableColumn<ItemGroup, String> colInfo;

    @FXML
    private TableColumn<ItemGroup, String> colName;

    @FXML
    private TableColumn<ItemGroup, Integer> colQty;

    @FXML
    private TableColumn<ItemGroup, String> colType;

    @FXML
    private Label lbName;

    @FXML
    private Label lbStatus;

    @FXML
    private TableView<ItemGroup> tblItems;
    
    public void initialize() {
		lbName.setText(this.staff.getName());
		
		colBarcode.setCellValueFactory(
				new PropertyValueFactory<>("barcode"));
		
		colInfo.setCellValueFactory(
				new PropertyValueFactory<>("itemInfo"));
		
		colName.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		
		colQty.setCellValueFactory(
				new PropertyValueFactory<>("qty"));
		
		colType.setCellValueFactory(
				new PropertyValueFactory<>("itemType"));
		
		tblItems.setItems((ObservableList<ItemGroup>) groups.getGroups());
		
	}
    
    private void printError(String message) {
    	System.out.println(message);
		lbStatus.setTextFill(Color.RED);
		lbStatus.setText(message);
    }
    
    private void printSuccessful(String message) {
    	lbStatus.setTextFill(Color.GREEN);
    	lbStatus.setText(message);
    }

    @FXML
    void mnAddBookPressed(ActionEvent event) {
    	String name 		= JOptionPane.showInputDialog("Enter item name: ");
    	if (name.equals("")) printError("Name is empty. Please enter a name.");
    	String barcode 		= JOptionPane.showInputDialog("Enter barcode: ");
    	if (barcode.equals("")) printError("Barcode is empty. Please enter a barcode.");
    	String author 		= JOptionPane.showInputDialog("Enter author(s): ");
    	if (author.equals("")) printError("Author(s) is empty. Please enter author(s).");
    	String publisher 	= JOptionPane.showInputDialog("Enter publisher: ");
    	if (publisher.equals("")) printError("Publisher is empty. Please enter a publisher.");
    	String isbn 		= JOptionPane.showInputDialog("Enter isbn: ");
    	if (isbn.equals("")) printError("ISBN is empty. Please enter a ISBN.");
    	float price = 0;
    	int qty 	= 0;
    	try {
    		price = Float.parseFloat(JOptionPane.showInputDialog("Enter price: "));
    	} catch (Exception e) {
    		printError("Invalid price. Please enter a number.");
    		return;
    	}
    	try {
    		qty = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity: "));
    	} catch (Exception e) {
    		printError("Invalid quantity. Please enter a number.");
    		return;
    	}
    	
    	groups.addBook(name, barcode, author, publisher, isbn, qty, price);
    	printSuccessful("Book \"" + name + "\" has been added");
    	tblItems.refresh();
    }

    @FXML
    void mnAddStationaryPressed(ActionEvent event) {
    	String name 		= JOptionPane.showInputDialog("Enter item name: ");
    	if (name.equals("")) printError("Name is empty. Please enter a name.");
    	String barcode 		= JOptionPane.showInputDialog("Enter barcode: ");
    	if (barcode.equals("")) printError("Barcode is empty. Please enter a barcode.");
    	String type 		= JOptionPane.showInputDialog("Enter type: ");
    	if (type.equals("")) printError("Type is empty. Please enter a type.");
    	float price = 0;
    	int qty 	= 0;
    	try {
    		price = Float.parseFloat(JOptionPane.showInputDialog("Enter price: "));
    	} catch (Exception e) {
    		printError("Invalid price. Please enter a number.");
    		return;
    	}
    	try {
    		qty = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity: "));
    	} catch (Exception e) {
    		printError("Invalid quantity. Please enter a number.");
    		return;
    	}
    	
    	groups.addStationary(name, barcode, type, qty, price);
    	printSuccessful("Stationary \"" + name + "\" has been added");
    	tblItems.refresh();
    }

    @FXML
    void mnAddToyPressed(ActionEvent event) {
    	String name 		= JOptionPane.showInputDialog("Enter item name: ");
    	if (name.equals("")) 	printError("Name is empty. Please enter a name.");
    	String barcode 		= JOptionPane.showInputDialog("Enter barcode: ");
    	if (barcode.equals("")) printError("Barcode is empty. Please enter a barcode.");
    	String brand 		= JOptionPane.showInputDialog("Enter brand: ");
    	if (brand.equals("")) 	printError("Brand is empty. Please enter a brand.");
    	int[] suitableAges	= new int[2];
    	try {
    		suitableAges[0] = Integer.parseInt(JOptionPane.showInputDialog("Enter lowest suitable age: ")); 	
    	} catch (Exception e) {
    		printError("Invalid age. Please enter a number.");
    		return;
    	}
    	try {
    		suitableAges[1] = Integer.parseInt(JOptionPane.showInputDialog("Enter highest suitable age: ")); 	
    	} catch (Exception e) {
    		printError("Invalid age. Please enter a number.");
    		return;
    	}
    	if (suitableAges[1] < suitableAges[0]) {
    		printError("Invalid age. Lowest age must be less than highest age.");
    		return;
    	}
    	String type 		= JOptionPane.showInputDialog("Enter type: ");
    	if (type.equals("")) printError("Type is empty. Please enter a type.");
    	float price = 0;
    	int qty 	= 0;
    	try {
    		price = Float.parseFloat(JOptionPane.showInputDialog("Enter price: "));
    	} catch (Exception e) {
    		printError("Invalid price. Please enter a number.");
    		return;
    	}
    	try {
    		qty = Integer.parseInt(JOptionPane.showInputDialog("Enter item quantity: "));
    	} catch (Exception e) {
    		printError("Invalid quantity. Please enter a number.");
    		return;
    	}
    	
    	groups.addToy(name, barcode, brand, suitableAges, type, qty, price);
    	printSuccessful("Toy \"" + name + "\" has been added");
    	tblItems.refresh();
    }
    
    @FXML
    void mnRemovePressed(ActionEvent event) {
    	ItemGroup group = tblItems.getSelectionModel().getSelectedItem();
    	if (group == null) {
    		printError("Please click on the item.");
    		return;
    	}
    	printSuccessful(group.getItemType() + " \"" + group.getName() + "\" has been removed.");
    	groups.removeGroup(group);
    	tblItems.refresh();
    }

    @FXML
    void mnSendReportPressed(ActionEvent event) {
    	// Update to store branch's items
    	itemService.addItemGroups(this.groups.getGroups());
    	
    	// Create notice to manager
    	Notice notice = new Notice(
    			this.staff,
    			StoreBranchService.searchManager(this.staff.getWorkingBranchNumber()),
    			"Import stock");
    	
    	// Create notice to director
    	Notice notice2 = new Notice(
    			this.staff,
    			StoreBranchService.getDirector(),
    			"Import stock");
    	
    	String content = "";
    	for (ItemGroup group : this.groups.getGroups())
    		content += group.getItemInfo() + ", quantity: " + group.getQty();
    	notice.setContent(content);
    	
    	// Save notice
    	(new DAO()).saveNotices(Arrays.asList(new Notice[]{notice, notice2}));
    	
    	// Save new items
//    	(new DAO()).saveItems(this.itemService.getGroups());
    	
    	// Clear table
    	groups.clear();
    	printSuccessful("Report sent successfully");
    	tblItems.refresh();
    }
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Importing -> Home");
    	this.frame.setVisible(false);
		new HomeScreenStaff(this.staff);
    }
	
	@FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Importing -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenStaff(this.staff);
    }
    
    @FXML
    void mnCheckPressed(ActionEvent event) {
    	System.out.println("Importing -> Check");
    	this.frame.setVisible(false);
		new CheckScreenStaff(this.staff);
    }
    
    @FXML
    void mnImportPressed(ActionEvent event) {
    	
    }

}
