package system.screen.staff.work.importing;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import personnel.Staff;
import system.screen.staff.home.HomeScreenStaff;
import system.screen.staff.profile.ProfileScreenStaff;
import system.screen.staff.work.check.CheckScreenStaff;
import system.service.ItemService;

public class ImportingScreenStaffController {
	
	private Staff staff;
	private JFrame frame;
	private ItemService itemService;
	
	public ImportingScreenStaffController(Staff staff) {
    	this.staff = staff;
    	this.itemService = new ItemService(this.staff);
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Importing -> Home");
    	this.frame.setVisible(false);
		new HomeScreenStaff(this.staff);
    }
	
	@FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Importing -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenStaff(this.staff);
    }
    
    @FXML
    void mnCheckPressed(ActionEvent event) {
    	System.out.println("Importing -> Check");
    	this.frame.setVisible(false);
		new CheckScreenStaff(this.staff);
    }
    
    @FXML
    void mnImportPressed(ActionEvent event) {
    	
    }

}
