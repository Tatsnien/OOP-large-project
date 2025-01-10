package system.screen.manager.work.expense;

import java.util.List;

import javax.swing.JFrame;

import data.Expense;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;
import system.screen.manager.profile.ProfileScreenManager;
import system.screen.manager.work.item.WorkScreenManagerItems;
import system.screen.manager.work.personnel.WorkPersonnelScreenManager;
import system.service.ExpenseService;
import system.service.IncomeService;

public class WorkScreenManagerExpenseController {
	private JFrame frame;
	private StoreBranchManager manager;
	private ExpenseService expenseService;
	private IncomeService incomeService;
	
	public WorkScreenManagerExpenseController(StoreBranchManager manager) {
		this.manager = manager;
		this.expenseService = this.manager.getExpenseService();
		this.incomeService = this.manager.getIncomeService();
		System.out.println("Manager expense service has " + expenseService.getExpenses().size() + " expenses.");
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(manager.getName());
		
		colExpenseName.setCellValueFactory(
				new PropertyValueFactory<>("expenseName"));
		colExpenseName.setSortable(true);
		
		colExpenseType.setCellValueFactory(
				new PropertyValueFactory<>("expenseType"));
		colExpenseType.setSortable(true);
		
		colExpenseValue.setCellValueFactory(
				new PropertyValueFactory<>("expenseValue"));
		colExpenseValue.setSortable(true);
		
		List<Expense> temp = expenseService.getExpenses();
		ObservableList<Expense> tempList = FXCollections.observableArrayList(temp);
		tblExpense.setItems(tempList);
		
		String total = String.valueOf(expenseService.getTotalExpense());
		lbExpenseSum.setText(total);
		
		String income = String.valueOf(incomeService.getIncome());
		lbIncome.setText(income);
		
		String profit = String.valueOf(incomeService.getIncome() - expenseService.getTotalExpense());
		lbProfit.setText(profit);
	}
	
	 @FXML
	 private TableColumn<Expense, String> colExpenseName;

	 @FXML
	 private TableColumn<Expense, String> colExpenseType;

	 @FXML
	 private TableColumn<Expense, Double> colExpenseValue;

	 @FXML
	 private Label lbExpenseSum;
	    
	 @FXML
	 private Label lbIncome;

	 @FXML
	 private Label lbName;

	 @FXML
	 private Label lbRecurringSum;

	 @FXML
	 private Label lbSalarySum;

	 @FXML
	 private Label lbProfit;

	 @FXML
	 private Menu mnHome;

	 @FXML
	 private Menu mnProfile;

	 @FXML
	 private Menu mnWork;

	 @FXML
	 private MenuItem mnWorkExpenses;

	 @FXML
	 private MenuItem mnWorkItems;

	 @FXML
	 private MenuItem mnWorkPersonnel;

	 @FXML
	 private MenuItem mnWorkReports;

	 @FXML
	 private TableView<Expense> tblExpense;

	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Expenses -> Home");
    	this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Expenses -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Expenses -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkExpensesPressed(ActionEvent event) {
    	
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	System.out.println("Expenses -> Items");
    	this.frame.setVisible(false);
    	new WorkScreenManagerItems(this.manager);
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	System.out.println("Expenses -> Reports");
    	this.frame.setVisible(false);
//    	new WorkScreenManagerReport(this.manager);
    }
}
