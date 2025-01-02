package system;

import data.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import personnel.*;
import system.screen.cashier.home.HomeScreenCashier;
import system.screen.director.home.HomeScreenDirector;
import system.screen.manager.home.HomeScreenManager;
import system.screen.staff.home.HomeScreenStaff;
import system.service.ExpenseService;
import system.service.IncomeService;
import system.service.ItemService;
import system.service.PersonnelService;
import system.service.StoreBranchService;

public class LoginScreenController {

	private StoreChain chain;
	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public LoginScreenController() {
		chain = new StoreChain();
		ExpenseService.setChain(chain);
    	IncomeService.setChain(chain);
    	ItemService.setChain(chain);
    	PersonnelService.setChain(chain);
    	StoreBranchService.setChain(chain);
		(new DAO()).getChainFromFiles(chain);
	}

	@FXML
    private TextField tfId;

    @FXML
    private TextField tfPassword;
    
    @FXML
    private Label lbLoginStatus;

    @FXML
    void btnLoginPressed(ActionEvent event) {
    	System.out.println("There is " + chain.getPersonnels().size() + " people in store chain.");
    	
    	Account account = new Account(tfId.getText(), tfPassword.getText());
    	Personnel validPerson = null;
    	for (Personnel person : chain.getPersonnels()) {
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
    		new HomeScreenDirector((Director) validPerson);
    	else if (validPerson instanceof StoreBranchManager)
    		new HomeScreenManager((StoreBranchManager) validPerson);
    	else if (validPerson instanceof Cashier)
    		new HomeScreenCashier((Cashier) validPerson);
    	else if (validPerson instanceof Staff)
    		new HomeScreenStaff((Staff) validPerson);
    }
	
}
