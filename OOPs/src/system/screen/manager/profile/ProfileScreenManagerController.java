package system.screen.manager.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;
<<<<<<< HEAD
import system.screen.manager.work.personnel.WorkPersonnelScreenManager;
=======
import system.screen.manager.work.discount.WorkScreenManagerDiscount;
import system.screen.manager.work.expense.WorkScreenManagerExpense;
import system.screen.manager.work.items.WorkScreenManagerItems;
import system.screen.manager.work.personnel.WorkScreenManagerPersonnel;
import system.screen.manager.work.report.WorkScreenManagerReport;
>>>>>>> dab2ec4365775f74b95aec1e511b86e91ebf9054

public class ProfileScreenManagerController{

	private StoreBranchManager manager;
	private JFrame frame;
	
	@FXML
    private Label lbName;

    @FXML
    private Label lbProfileId;

    @FXML
    private Label lbProfileName;

    @FXML
    private Label lbProfilePosition;

    @FXML
    private Label lbProfileSalary;

    @FXML
    private Menu mnHome;

    @FXML
    private Menu mnProfile;

    @FXML
    private Menu mnWork;

    @FXML
    private MenuItem mnWorkExpenses;
    
    @FXML
    private MenuItem mnWorkDiscounts;

    @FXML
    private MenuItem mnWorkItems;

    @FXML
    private MenuItem mnWorkPersonnel;

    @FXML
    private MenuItem mnWorkReports;

    
    public ProfileScreenManagerController(StoreBranchManager manager) {
    	this.manager = manager;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(manager.getName());
		lbProfileName.setText(manager.getName());
		lbProfileId.setText(manager.getAccount().getId());
		lbProfilePosition.setText(manager.getPosition());
		lbProfileSalary.setText("$ " + Math.round(manager.getSalary() * 100) / 100.0);
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	
    }
    
    @FXML
<<<<<<< HEAD
    void mnViewEmployeesPressed(ActionEvent event) {
    	System.out.println("View Branches -> View Employees");
    	this.frame.setVisible(false);
		new WorkPersonnelScreenManager(this.manager);
=======
    void mnWorkExpensesPressed(ActionEvent event) {
    	System.out.println("Work -> Expenses");
    	this.frame.setVisible(false);
    	new WorkScreenManagerExpense(this.manager);
>>>>>>> dab2ec4365775f74b95aec1e511b86e91ebf9054
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	System.out.println("Work -> Items");
    	this.frame.setVisible(false);
    	new WorkScreenManagerItems(this.manager);
    }

    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Work -> Personnel");
    	this.frame.setVisible(false);
    	new WorkScreenManagerPersonnel(this.manager);
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	System.out.println("Work -> Reports");
    	this.frame.setVisible(false);
    	new WorkScreenManagerReport(this.manager);
    }
    
    @FXML
    void mnWorkDiscountsPressed(ActionEvent event) {
    	System.out.println("Work -> Discounts");
    	this.frame.setVisible(false);
    	new WorkScreenManagerDiscount(this.manager);
    }
}