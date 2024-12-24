package system.screen.manager.home;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.StoreBranchManager;

public class HomeScreenManager extends JFrame{
	
	private HomeScreenManager frame;
	
	public HomeScreenManager(StoreBranchManager manager) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Home Screen Manager");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("homemanager.fxml"));
					HomeScreenManagerController controller = new HomeScreenManagerController(manager);
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