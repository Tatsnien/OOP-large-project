package system.screen.director.work.item;

import javax.swing.JFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.expense.WorkExpenseScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;
import system.service.ItemService;
import system.service.StoreBranchService;

public class WorkItemScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreBranchService branchService;
	private ItemService itemService;
	
	public WorkItemScreenDirectorController(Director director) {
    	this.director = director;
    	this.branchService = new StoreBranchService(director);
    	this.itemService = new ItemService(director);
    	System.out.println("Director branch service has " + branchService.getBranchs().size() + " branchs.");
    	System.out.println("Director item service has " + itemService.getGroups().size() + " item groups.");
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
    	System.out.println("Items -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Items -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Items -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Items -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	System.out.println("Items -> Expenses");
    	this.frame.setVisible(false);
    	new WorkExpenseScreenDirector(this.director);
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	
    }

}
