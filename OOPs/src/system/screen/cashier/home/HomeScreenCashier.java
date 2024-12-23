package system.screen.cashier.home;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import personnel.Cashier;

public class HomeScreenCashier extends JFrame{
	
	private HomeScreenCashier frame;
	
	public HomeScreenCashier(Cashier cashier) {
		super();
		
		this.frame = this;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Home Screen Cashier");
		this.setVisible(true);
		setSize(1024, 768);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {							
					FXMLLoader loader = new FXMLLoader(getClass().getResource("homecashier.fxml"));
					HomeScreenCashierController controller = new HomeScreenCashierController(cashier);
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