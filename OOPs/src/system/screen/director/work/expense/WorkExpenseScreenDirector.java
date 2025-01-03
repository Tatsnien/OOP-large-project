package system.screen.director.work.expense;

import java.io.IOException;

import javax.swing.JFrame;

import data.StoreChain;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import personnel.Director;

public class WorkExpenseScreenDirector extends JFrame{
	
	private StoreChain chain;
	private WorkExpenseScreenDirector frame;
	
	public WorkExpenseScreenDirector(Director director) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Work Expense Screen Director");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("workexpensedirector.fxml"));
					
					WorkExpenseScreenDirectorController controller = new WorkExpenseScreenDirectorController(director);
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
