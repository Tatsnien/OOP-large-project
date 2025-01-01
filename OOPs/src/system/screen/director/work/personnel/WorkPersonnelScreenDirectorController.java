package system.screen.director.work.personnel;

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
import personnel.Director;
import personnel.StoreBranchManager;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.service.PersonnelManagementService;
import system.service.StoreBranchManagementService;

public class WorkPersonnelScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreChain storeChain;
	private StoreBranchManagementService branchService;
	private PersonnelManagementService personnelService;

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
    
    public WorkPersonnelScreenDirectorController(Director director) {
    	this.director = director;
    	this.storeChain = new StoreChain();
    	this.branchService = new StoreBranchManagementService();
    	this.personnelService = new PersonnelManagementService();
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
		
		tblBranch.setItems((ObservableList<StoreBranch>) StoreChain.getBranchs());
		
	}
	
	 @FXML
    void btnAddPressed(ActionEvent event) {
		 String address = JOptionPane.showInputDialog("Enter Address: ");
		 String id = JOptionPane.showInputDialog("Enter Manager ID: ");
			 
		 lbStatus.setText("");
		 int branchNumber = branchService.addBranch(address, id);
		 
		 if (branchNumber == -1) {
			 lbStatus.setText("Personnel doesn't exist.");
			 return;
		 }
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
    	
    	if (storeChain.searchPersonnel(id) == null) {
			 lbStatus.setText("Personnel doesn't exist.");
			 return;
		 }
			 
		 lbStatus.setText("");
		 branchService.assignBranchManager(id, storeBranch.getBranchNumber());
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
    }
	
	 @FXML
    void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Home -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnViewBranchPressed(ActionEvent event) {

    }

}
