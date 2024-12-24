package system.screen.staff.profile;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.Staff;

public class ProfileScreenStaff extends JFrame{
	
	private ProfileScreenStaff frame;
	
	public ProfileScreenStaff(Staff staff) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Profile Screen Staff");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("profilestaff.fxml"));
					
					ProfileScreenStaffController controller = new ProfileScreenStaffController(staff);
					loader.setController(controller);
					
					Parent root = loader.load();
					Scene scene = new Scene(root);
					fxPanel.setScene(scene);
					
					controller.setFrame(frame);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}