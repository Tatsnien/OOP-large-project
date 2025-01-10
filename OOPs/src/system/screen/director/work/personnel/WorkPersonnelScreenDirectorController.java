package system.screen.director.work.personnel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.Account;
import personnel.Cashier;
import personnel.Director;
import personnel.Employee;
import personnel.Staff;
import personnel.StoreBranchManager;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.expense.WorkExpenseScreenDirector;
import system.screen.director.work.item.WorkItemScreenDirector;
import system.service.PersonnelService;
import system.service.StoreBranchService;

public class WorkPersonnelScreenDirectorController {

	private Director director;
	private JFrame frame;
	private StoreBranchService branchService;
	private PersonnelService personnelService;
	
	public WorkPersonnelScreenDirectorController(Director director) {
    	this.director = director;
    	this.branchService = new StoreBranchService(director);
    	this.personnelService = new PersonnelService(director);
    	System.out.println("Director branch service has " + branchService.getBranchs().size() + " branchs.");
    	System.out.println("Director personnel service has " + personnelService.getEmployees().size() + " employees.");
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@FXML
    private Button btnNewEmployee;

    @FXML
    private TableColumn<Employee, String> colId;

    @FXML
    private TableColumn<Employee, String> colName;
    
    @FXML
    private TableColumn<Employee, Integer> colBranchNb;

    @FXML
    private TableColumn<Employee, String> colPosition;

    @FXML
    private TableColumn<Employee, Float> colSalary;
    
    @FXML
    private TableColumn<Employee, String> colNotice;

    @FXML
    private Label lbMemberName;

    @FXML
    private Label lbName;

    @FXML
    private Label lbAccountStatus;
    
    @FXML
    private Label lbStatus;

    @FXML
    private TableView<Employee> tblPersonnel;

    @FXML
    private TextField tfAccountID;
    
    public void initialize() {
		lbName.setText(director.getName());
		
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colId.setSortable(true);
		
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colName.setSortable(true);
		
		colBranchNb.setCellValueFactory(new PropertyValueFactory<>("workingBranchNumber"));
		
		colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
		colPosition.setSortable(true);
		
		colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
		
		colNotice.setCellValueFactory(new PropertyValueFactory<>("noticeTitles"));
		
		List<Employee> temp = personnelService.getEmployees();
		ObservableList<Employee> tempList = FXCollections.observableArrayList(temp);
		tblPersonnel.setItems(tempList);
		
	}
    
    @FXML
    void btnNewEmployeePressed(ActionEvent event) {
    	int branchNb;
    	float salary;
    	String name = JOptionPane.showInputDialog("Enter name: ");
    	String id = personnelService.getSpareId();
    	while (true) {
    		try {
    			salary = Float.parseFloat(JOptionPane.showInputDialog("Enter salary: "));
    			break;
    		} catch(Exception e) {};
    	}
    	String[] options = {"Cashier", "Staff", "Manager"};
        int position = JOptionPane.showOptionDialog(
	        null,
	        "Choose a position",
	        "Position Dialog",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.INFORMATION_MESSAGE,
	        null,
	        options,
	        options[0]);
    	while (true) {
    		try {
    			branchNb = Integer.parseInt(JOptionPane.showInputDialog("Enter branch number: "));
    			break;
    		} catch(Exception e) {};
    	}
    	
    	if (branchService.getBranch(branchNb) == null) {
    		String warning = "Branch " + branchNb + " not exist.";
    		JOptionPane.showMessageDialog(null, warning, "Information", JOptionPane.INFORMATION_MESSAGE);
    		return;
    	}
    	
    	if (position == 0)
    		personnelService.addEmployee(new Cashier(name, salary, new Account(id, id), "Cashier", branchNb));
    	else if (position == 1)
    		personnelService.addEmployee(new Staff(name, salary, new Account(id, id), "Staff", branchNb));
    	else if (position == 2)
    		personnelService.addEmployee(new StoreBranchManager(name, salary, new Account(id, id), "Manager", branchNb));
    }

    @FXML
    void btnSearchPressed(ActionEvent event) {
    	Employee employee = personnelService.searchEmployee(tfAccountID.getText());
    	if (employee == null) {
    		lbMemberName.setText("-");
    		lbAccountStatus.setText("Employee's ID " + tfAccountID.getText() + " not found.");
    	}
    	else {
    		lbMemberName.setText(employee.getName());
    		lbAccountStatus.setText("");
    	}
    }

    @FXML
    void btnUpdatePressed(ActionEvent event) {
    	Employee employee = tblPersonnel.getSelectionModel().getSelectedItem();
    	if (employee == null) {
    		lbStatus.setText("Please click on the employee.");
    		return;
    	}
    	lbStatus.setText("");
    	String salary = JOptionPane.showInputDialog("Enter salary: ");
    	while (true) {
    		try {
    			employee.setSalary(Float.parseFloat(salary));
    			break;
    		} catch (Exception e) {};
    	}
    	tblPersonnel.refresh();
    }

    @FXML
    void btnViewProfilePressed(ActionEvent event) {
    	Employee employee = tblPersonnel.getSelectionModel().getSelectedItem();
    	if (employee == null) {
    		lbStatus.setText("Please click on the employee.");
    		return;
    	}
    	lbStatus.setText("");
    	String profile = 	"Name:\t" + employee.getName() + "\n" +
    						"ID:\t" + employee.getId() + "\n" +
    						"Salary:\t" + employee.getSalary() + "\n" +
    						"Position:\t" + employee.getPosition() + "\n";
    	JOptionPane.showMessageDialog(null, profile, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Personnel -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Personnel -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Personnel -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	System.out.println("Personnel -> Expenses");
    	this.frame.setVisible(false);
    	new WorkExpenseScreenDirector(this.director);
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	System.out.println("Personnel -> Items");
    	this.frame.setVisible(false);
    	new WorkItemScreenDirector(this.director);
    }

}
