package system.screen.staff.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import personnel.Staff;
import system.screen.staff.home.HomeScreenStaff;

public class ProfileScreenStaffController{

	private Staff staff;
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

    
    public ProfileScreenStaffController(Staff staff) {
    	this.staff = staff;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(staff.getName());
		lbProfileName.setText(staff.getName());
		lbProfileId.setText(staff.getAccount().getId());
		lbProfilePosition.setText(staff.getPosition());
		lbProfileSalary.setText("$ " + Math.round(staff.getSalary() * 100) / 100.0);
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenStaff(this.staff);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	
    }

}
