package system.screen.staff.work;

import java.io.IOException;

import personnel.Staff;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;
import java.awt.*;

import javafx.event.ActionEvent;


public class WorkScreenStaffAddReport extends JFrame {

	private WorkScreenStaffAddReport frame;
	
	public WorkScreenStaffAddReport(Staff staff) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Work Screen Staff");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("workstaffaddreport.fxml"));
					
					WorkScreenStaffAddReportController controller = new WorkScreenStaffAddReportController(staff);
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
