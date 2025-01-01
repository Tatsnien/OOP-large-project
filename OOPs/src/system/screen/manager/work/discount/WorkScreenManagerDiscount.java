package system.screen.manager.work.discount;

import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import personnel.StoreBranchManager;
import system.screen.manager.work.items.WorkScreenManagerItemsController;

public class WorkScreenManagerDiscount extends JFrame {

	private WorkScreenManagerDiscount frame;
	
	public WorkScreenManagerDiscount(StoreBranchManager manager) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Work Screen Manager - Discount");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("workmanageritems.fxml"));
					
					WorkScreenManagerItemsController controller = new WorkScreenManagerItemsController(manager);
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
		
