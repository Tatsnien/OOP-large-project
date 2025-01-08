package system.screen.director.work.branch;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import data.StoreBranch;
import data.StoreChain;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.Account;
import personnel.Director;
import personnel.Employee;
import personnel.StoreBranchManager;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.expense.WorkExpenseScreenDirector;
import system.screen.director.work.item.WorkItemScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;
import system.service.PersonnelService;
import system.service.StoreBranchService;

public class WorkBranchScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreBranchService branchService;
	private PersonnelService personnelService;

    @FXML
    private TableColumn<StoreBranch, String> colAddress;

    @FXML
    private TableColumn<StoreBranch, Integer> colBranchNo;

    @FXML
    private TableColumn<StoreBranch, String> colManager;

    @FXML
    private Label lbName;
    
    @FXML
    private Label lbStatus;

    @FXML
    private TableView<StoreBranch> tblBranch;
    
    public WorkBranchScreenDirectorController(Director director) {
    	this.director = director;
    	this.branchService = new StoreBranchService(director);
    	this.personnelService = new PersonnelService(director);
    	System.out.println("Director branch service has " + branchService.getBranchs().size() + " branchs.");
    	System.out.println("Director personnel service has " + personnelService.getEmployees().size() + " employees.");
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(director.getName());
		
		colBranchNo.setCellValueFactory(
				new PropertyValueFactory<>("branchNumber"));
		
		colAddress.setCellValueFactory(
				new PropertyValueFactory<>("address"));
		
		colManager.setCellValueFactory(
				new PropertyValueFactory<>("branchManagerName"));
		
		tblBranch.setItems((ObservableList<StoreBranch>) branchService.getBranchs());
	}
	
	 @FXML
    void btnAddPressed(ActionEvent event) {
		 String address = JOptionPane.showInputDialog("Enter Address: ");
		 String id = JOptionPane.showInputDialog("Enter Manager ID: ");
		
		 Employee assignedEmployee = personnelService.searchEmployee(id);
		 if (id.equals(director.getId()) || assignedEmployee != null && !(assignedEmployee instanceof StoreBranchManager)) {
			 lbStatus.setText("This person is not a manager.");
			 return;
		 }
		 
		 if (assignedEmployee != null && assignedEmployee.getWorkingBranchNumber() != 0) {
			 lbStatus.setText("This manager has already been assigned");
			 return;
		 }
		 
		 lbStatus.setText("");
		 int branchNumber = branchService.addBranch(address);
		 
		 if (assignedEmployee == null) {
			 String name = JOptionPane.showInputDialog("Enter Manager name: ");
			 StoreBranchManager manager = new StoreBranchManager(name);
			 manager.setAccount(new Account(id, id));
			 manager.setWorkingBranchNumber(branchNumber);
			 manager.setServices();
			 branchService.getBranch(branchNumber).addEmployee(manager);
			 lbStatus.setText("New Manager added");
			 return;
		 }
		 else {
			 branchService.getBranch(branchNumber).setBranchManager((StoreBranchManager) assignedEmployee);
		 }
		 
		 tblBranch.refresh();
    }

    @FXML
    void btnAssignPressed(ActionEvent event) {
    	StoreBranch storeBranch = tblBranch.getSelectionModel().getSelectedItem();
    	if (storeBranch == null) {
    		lbStatus.setText("Please click on the branch.");
    		return;
    	}
    	
    	lbStatus.setText("");
    	
    	String id = JOptionPane.showInputDialog("Enter Manager ID: ");
		 
		 Employee assignedEmployee = personnelService.searchEmployee(id);
		 if (id.equals(director.getId()) || assignedEmployee != null && !(assignedEmployee instanceof StoreBranchManager)) {
			 lbStatus.setText("This person is not a manager.");
			 return;
		 }
		 
		 if (assignedEmployee != null && assignedEmployee.getWorkingBranchNumber() != 0) {
			 lbStatus.setText("This manager has already been assigned");
			 return;
		 }
		 
		 lbStatus.setText("");
		 
		 if (assignedEmployee == null) {
			 String name = JOptionPane.showInputDialog("Enter Manager name: ");
			 StoreBranchManager manager = new StoreBranchManager(name);
			 manager.setAccount(new Account(id, ""));
			 manager.setWorkingBranchNumber(storeBranch.getBranchNumber());
			 manager.setServices();
			 storeBranch.addEmployee(manager);
			 lbStatus.setText("New Manager added");
			 return;
		 }
		 else {
			 storeBranch.setBranchManager((StoreBranchManager) assignedEmployee);
		 }
		 
		 tblBranch.refresh();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	StoreBranch storeBranch = tblBranch.getSelectionModel().getSelectedItem();
    	if (storeBranch == null) {
    		lbStatus.setText("Please click on the branch.");
    		return;
    	}
    	lbStatus.setText("");
    	branchService.removeBranch(storeBranch);
    	tblBranch.refresh();
    }
	
    @FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Branches -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Branches -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Branches -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	System.out.println("Branches -> Expenses");
    	this.frame.setVisible(false);
    	new WorkExpenseScreenDirector(this.director);
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	System.out.println("Branches -> Items");
    	this.frame.setVisible(false);
    	new WorkItemScreenDirector(this.director);
    }

}
