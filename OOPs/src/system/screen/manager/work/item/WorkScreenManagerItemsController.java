package system.screen.manager.work.item;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;
import system.screen.manager.profile.ProfileScreenManager;
import system.screen.manager.work.expense.WorkScreenManagerExpense;
import system.screen.manager.work.personnel.WorkPersonnelScreenManager;
import system.screen.manager.work.report.WorkScreenManagerReport;
import system.service.ItemService;

public class WorkScreenManagerItemsController {
	private JFrame frame;
	private StoreBranchManager manager;
	private ItemService service;
	
	public WorkScreenManagerItemsController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = new ItemService(manager.getWorkingBranchNumber());
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// TODO DO FXML
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Items -> Home");
    	this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Items -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Items -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkExpensesPressed(ActionEvent event) {
    	System.out.println("Items -> Expenses");
    	this.frame.setVisible(false);
    	new WorkScreenManagerExpense(this.manager);
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	System.out.println("Items -> Reports");
    	this.frame.setVisible(false);
    	new WorkScreenManagerReport(this.manager);
    }
    
}
