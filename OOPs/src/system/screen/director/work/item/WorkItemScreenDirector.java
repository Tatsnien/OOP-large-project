package system.screen.director.work.item;

import java.io.IOException;

import javax.swing.JFrame;

import data.StoreChain;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import personnel.Director;

public class WorkItemScreenDirector extends JFrame{
	
	private StoreChain chain;
	private WorkItemScreenDirector frame;
	
	public WorkItemScreenDirector(Director director) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Work Item Screen Director");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("workitemdirector.fxml"));
					
					WorkItemScreenDirectorController controller = new WorkItemScreenDirectorController(director);
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
