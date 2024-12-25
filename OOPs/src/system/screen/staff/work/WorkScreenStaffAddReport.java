package system.screen.staff.work;

import java.io.IOException;

import personnel.Cashier;
import system.screen.cashier.work.FXMLLoader;
import system.screen.cashier.work.JFXPanel;
import system.screen.cashier.work.Parent;
import system.screen.cashier.work.Scene;
import system.screen.cashier.work.WorkScreenCashier;
import system.screen.cashier.work.WorkScreenCashierController;

public class WorkScreenStaffAddReport {

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
