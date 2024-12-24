package system.screen.director.home;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.Director;

public class HomeScreenDirector extends JFrame{
	
	private HomeScreenDirector frame;
	
	public HomeScreenDirector(Director director) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Home Screen Director");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("homedirector.fxml"));
					HomeScreenDirectorController controller = new HomeScreenDirectorController(director);
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