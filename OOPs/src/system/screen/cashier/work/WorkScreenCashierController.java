package system.screen.cashier.work;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import personnel.Cashier;
import system.screen.cashier.home.HomeScreenCashier;
import system.screen.cashier.profile.ProfileScreenCashier;

public class WorkScreenCashierController {
	
	private Cashier cashier;
	private JFrame frame;
	
	@FXML
    private Label lbName;

	public WorkScreenCashierController(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
//		lbName.setText(cashier.getName());
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenCashier(this.cashier);
    }
	
	@FXML
    void mnWorkPressed(ActionEvent event) {
		
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	this.frame.setVisible(false);
		new ProfileScreenCashier(this.cashier);
    }

}
