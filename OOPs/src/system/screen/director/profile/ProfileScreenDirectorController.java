package system.screen.director.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.expense.WorkExpenseScreenDirector;
import system.screen.director.work.item.WorkItemScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;

public class ProfileScreenDirectorController{

	private Director director;
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

    
    public ProfileScreenDirectorController(Director director) {
    	this.director = director;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(director.getName());
		lbProfileName.setText(director.getName());
		lbProfileId.setText(director.getAccount().getId());
		lbProfilePosition.setText(director.getPosition());
		lbProfileSalary.setText("$ " + Math.round(director.getSalary() * 100) / 100.0);
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Home -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Home -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	System.out.println("Home -> Expenses");
    	this.frame.setVisible(false);
    	new WorkExpenseScreenDirector(this.director);
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	System.out.println("Home -> Items");
    	this.frame.setVisible(false);
    	new WorkItemScreenDirector(this.director);
    }

}
