package system.screen.director.work.expense;

import java.util.List;

import javax.swing.JFrame;

import data.StoreBranch;
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
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.item.WorkItemScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;
import system.service.ExpenseService;
import system.service.StoreBranchService;

public class WorkExpenseScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreBranchService branchService;
	private ExpenseService expenseService;
	
	@FXML
    private TableColumn<StoreBranch, Integer> colBranchNumber;

    @FXML
    private TableColumn<?, Float> colExpenses;

    @FXML
    private TableColumn<?, Float> colProfit;

    @FXML
    private TableColumn<?, Float> colRevenue;

    @FXML
    private Label lbExpenses;
    
    @FXML
    private Label lbName;

    @FXML
    private Label lbProfit;

    @FXML
    private Label lbRevenue;

    @FXML
    private Menu mnHome;

    @FXML
    private Menu mnProfile;

    @FXML
    private Menu mnWork;

    @FXML
    private MenuItem mnWorkBranch;

    @FXML
    private MenuItem mnWorkExpense;

    @FXML
    private MenuItem mnWorkItem;

    @FXML
    private MenuItem mnWorkPersonnel;

    @FXML
    private TableView<StoreBranch> tblIncome;
	
	public WorkExpenseScreenDirectorController(Director director) {
    	this.director = director;
    	this.branchService = new StoreBranchService(director);
    	this.expenseService = new ExpenseService(director);
    	System.out.println("Director branch service has " + branchService.getBranchs().size() + " branchs.");
    	System.out.println("Director expense service has " + expenseService.getExpenses().size() + " expenses.");
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
    
    public void initialize() {
		lbName.setText(director.getName());		
		
		colBranchNumber.setCellValueFactory(
				new PropertyValueFactory<>("branchNumber"));
		colBranchNumber.setSortable(true);
		
		colExpenses.setCellValueFactory(
				new PropertyValueFactory<>("totalExpense"));
		colExpenses.setSortable(true);
		
		colRevenue.setCellValueFactory(
				new PropertyValueFactory<>("income"));
		colRevenue.setSortable(true);
		
		colProfit.setCellValueFactory(
				new PropertyValueFactory<>("profit"));
		colProfit.setSortable(true);
		
		List<StoreBranch> temp = branchService.getBranchs();
		ObservableList<StoreBranch> tempList = FXCollections.observableArrayList(temp);
		tblIncome.setItems(tempList);
		
		double totalExpenses = 0;
		for (StoreBranch branch : temp) {
			totalExpenses += branch.getTotalExpense();
		}
		lbExpenses.setText(String.valueOf(totalExpenses));
		double totalIncome = 0;
		for (StoreBranch branch : temp) {
			totalIncome += branch.getIncome();
		}
		lbRevenue.setText(String.valueOf(totalIncome));
		double totalProfit = totalIncome - totalExpenses;
		lbProfit.setText(String.valueOf(String.valueOf(totalProfit)));
		
	}

    @FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Expenses -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Expenses -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Expenses -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Expenses -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {}

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	System.out.println("Expenses -> Items");
    	this.frame.setVisible(false);
    	new WorkItemScreenDirector(this.director);
    }
}
