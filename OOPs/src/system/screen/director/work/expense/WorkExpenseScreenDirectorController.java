package system.screen.director.work.expense;

import javax.swing.JFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.item.WorkItemScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;
import system.service.ExpenseService;
import system.service.StoreBranchService;

public class WorkExpenseScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreBranchService branchService;
	private ExpenseService expenseService;
	
	public WorkExpenseScreenDirectorController(Director director) {
    	this.director = director;
    	this.branchService = new StoreBranchService(director);
    	this.expenseService = new ExpenseService(director);
    	System.out.println("Director branch service has " + branchService.getBranchs().size() + " branchs.");
    	System.out.println("Director expense service has " + expenseService.getExpenses().size() + " expenses.");
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

    @FXML
    private Label lbName;
    
    public void initialize() {
		lbName.setText(director.getName());		
	}

    @FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Expenses -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Expenses -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Expenses -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Expenses -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	System.out.println("Expenses -> Items");
    	this.frame.setVisible(false);
    	new WorkItemScreenDirector(this.director);
    }

}
