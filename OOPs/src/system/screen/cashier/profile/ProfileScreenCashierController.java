package system.screen.cashier.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import personnel.Cashier;
import system.screen.cashier.home.HomeScreenCashier;
import system.screen.cashier.work.WorkScreenCashier;

public class ProfileScreenCashierController{

	private Cashier cashier;
	private JFrame frame;
	
	@FXML
    private Label lbName;

    @FXML
    private Label lbProfileId;

    @FXML
    private Label lbProfileName;

    @FXML
    private Label lbProfilePosition;

    @FXML
    private Label lbProfileSalary;

    
    public ProfileScreenCashierController(Cashier cashier) {
    	this.cashier = cashier;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(cashier.getName());
		lbProfileName.setText(cashier.getName());
		lbProfileId.setText(cashier.getAccount().getId());
		lbProfileSalary.setText(Math.round(cashier.getSalary() * 100) / 100.0 + " VNĐ");
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenCashier(this.cashier);
    }

    @FXML
    void mnWorkPressed(ActionEvent event) {
    	this.frame.setVisible(false);
		new WorkScreenCashier(this.cashier);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	
    }

}
