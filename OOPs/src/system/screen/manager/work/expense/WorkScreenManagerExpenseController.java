package system.screen.manager.work.expense;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;
import system.screen.manager.profile.ProfileScreenManager;
import system.screen.manager.work.item.WorkScreenManagerItems;
import system.screen.manager.work.personnel.WorkPersonnelScreenManager;
import system.screen.manager.work.report.WorkScreenManagerReport;
import system.service.ExpenseService;

public class WorkScreenManagerExpenseController {
	private JFrame frame;
	private StoreBranchManager manager;
	private ExpenseService service;
	
	public WorkScreenManagerExpenseController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = manager.getExpenseService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	@FXML
    void btnEmployeeListPressed(ActionEvent event) {
		// TODO write function
    }

    @FXML
    void btnFinancialStatusPressed(ActionEvent event) {
    	// TODO write function
    }

    @FXML
    void btnItemsListPressed(ActionEvent event) {
    	// TODO write function
    }

    @FXML
    void btnTimekeepingPressed(ActionEvent event) {
    	// TODO write function
    }

    @FXML
    void btnViewReportsPressed(ActionEvent event) {
    	// TODO write function
    }
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Expenses -> Home");
    	this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Expenses -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Expenses -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkExpensesPressed(ActionEvent event) {
    	
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	System.out.println("Expenses -> Items");
    	this.frame.setVisible(false);
    	new WorkScreenManagerItems(this.manager);
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	System.out.println("Expenses -> Reports");
    	this.frame.setVisible(false);
    	new WorkScreenManagerReport(this.manager);
    }
}
