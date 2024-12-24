package system.screen.staff.home;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.Staff;

public class HomeScreenStaff extends JFrame{
	
	private HomeScreenStaff frame;
	
	public HomeScreenStaff(Staff staff) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Home Screen Staff");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("homestaff.fxml"));
					HomeScreenStaffController controller = new HomeScreenStaffController(staff);
					controller.setFrame(frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}