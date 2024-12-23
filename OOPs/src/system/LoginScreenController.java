package system;

import data.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import personnel.*;
import system.screen.cashier.home.HomeScreenCashier;
import system.screen.director.HomeScreenDirector;
import system.screen.manager.HomeScreenManager;
import system.screen.staff.HomeScreenStaff;

public class LoginScreenController {

	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	 @FXML
    private TextField tfId;

    @FXML
    private TextField tfPassword;
    
    @FXML
    private Label lbLoginStatus;

    @FXML
    void btnLoginPressed(ActionEvent event) {
    	StoreChain storeChain = new StoreChain();
    	System.out.println("There is " + storeChain.getPersonnels().size() + " people in store chain.");
    	
    	Account account = new Account(tfId.getText(), tfPassword.getText());
    	Personnel validPerson = null;
    	for (Personnel person : storeChain.getPersonnels()) {
    		if (account.equals(person.getAccount())) {
    			validPerson = person;
    			break;
    		}
    			
    		System.out.print(account.getId() + " " + account.getPassword() + "-");
    		System.out.println(person.getAccount().getId() + " " + person.getAccount().getPassword());
    	}
    	
    	tfId.setText("");
    	tfPassword.setText("");
    	
    	if (validPerson == null) {
    		lbLoginStatus.setText("The user name or password is incorrect.");
    		return;
    	}
    	
    	stage.hide();
    	
    	if (validPerson instanceof Director)
    		new HomeScreenDirector();
    	else if (validPerson instanceof StoreBranchManager)
    		new HomeScreenManager();
    	else if (validPerson instanceof Cashier)
    		new HomeScreenCashier((Cashier) validPerson);
    	else if (validPerson instanceof Staff)
    		new HomeScreenStaff();
    }
	
}
