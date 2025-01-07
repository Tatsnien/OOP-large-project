package system.screen.staff.work.check;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.Staff;

public class CheckScreenStaff extends JFrame{
	
	private CheckScreenStaff frame;
	
	public CheckScreenStaff(Staff staff) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Check Screen Staff");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("checkstaff.fxml"));
					CheckScreenStaffController controller = new CheckScreenStaffController(staff);
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