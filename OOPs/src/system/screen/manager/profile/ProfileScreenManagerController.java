package system.screen.manager.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;

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

}
