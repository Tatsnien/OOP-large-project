package system.screen.manager.work.report;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import personnel.StoreBranchManager;
//import system.service.ManagerService;
import system.screen.manager.home.HomeScreenManager;
import system.screen.manager.profile.ProfileScreenManager;
import system.screen.manager.work.expense.WorkScreenManagerExpense;
import system.screen.manager.work.item.WorkScreenManagerItems;
import system.screen.manager.work.personnel.WorkPersonnelScreenManager;

public class WorkScreenManagerReportController {

	private StoreBranchManager manager;
	private JFrame frame;
//	private ManagerService service;
	
	public WorkScreenManagerReportController(StoreBranchManager manager) {
		this.manager = manager;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// TODO FXML
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Reports -> Home");
    	this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Reports -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Reports -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkExpensesPressed(ActionEvent event) {
    	System.out.println("Reports -> Expenses");
    	this.frame.setVisible(false);
    	new WorkScreenManagerExpense(this.manager);
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	System.out.println("Reports -> Items");
    	this.frame.setVisible(false);
    	new WorkScreenManagerItems(this.manager);
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	
    }
    
}
