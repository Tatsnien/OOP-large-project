package system.screen.manager.work.personnel;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.Account;
import personnel.Cashier;
import personnel.StoreBranchManager;
import personnel.Employee;
import personnel.Staff;
import personnel.StoreBranchManager;
import system.screen.manager.home.HomeScreenManager;
import system.screen.manager.profile.ProfileScreenManager;
import system.service.PersonnelService;
import system.service.StoreBranchService;

public class WorkPersonnelScreenManagerController {

	private StoreBranchManager manager;
	private JFrame frame;
	private PersonnelService personnelService;
	
	public WorkPersonnelScreenManagerController(StoreBranchManager manager) {
    	this.manager = manager;
    	this.personnelService = new PersonnelService(manager.getWorkingBranchNumber());
    	System.out.println("Manager personnel service has " + personnelService.getEmployees().size() + " employees.");
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
    private ToggleGroup employeeViewSelect;

    @FXML
    private Label lbMemberName;

    @FXML
    private Label lbName;

    @FXML
    private Label lbAccountStatus;
    
    @FXML
    private Label lbStatus;

    @FXML
    private RadioButton rbID;

    @FXML
    private RadioButton rbName;

    @FXML
    private RadioButton rbPosition;

    @FXML
    private TableView<Employee> tblPersonnel;

    @FXML
    private TextField tfAccountID;
    
    public void initialize() {
		lbName.setText(manager.getName());
		
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
    	float salary;
    	String name = JOptionPane.showInputDialog("Enter name: ");
    	String id = personnelService.getSpareId();
    	while (true) {
    		try {
    			salary = Float.parseFloat(JOptionPane.showInputDialog("Enter salary: "));
    			break;
    		} catch(Exception e) {};
    	}
    	String[] options = {"Cashier", "Staff"};
        int position = JOptionPane.showOptionDialog(
	        null,
	        "Choose a position",
	        "Position Dialog",
	        JOptionPane.DEFAULT_OPTION,
	        JOptionPane.INFORMATION_MESSAGE,
	        null,
	        options,
	        options[0]);
    	int branchNb = manager.getWorkingBranchNumber();
    	
    	if (position == 0) {
    		Cashier cashier = new Cashier(name, salary, new Account(id, id), "Cashier", branchNb);
    		personnelService.addEmployee(cashier);
    		tblPersonnel.getItems().add(cashier);
    	}
    	else if (position == 1) {
    		Staff staff = new Staff(name, salary, new Account(id, id), "Staff", branchNb);
    		personnelService.addEmployee(new Staff(name, salary, new Account(id, id), "Staff", branchNb));
    		tblPersonnel.getItems().add(staff);
    	}
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
    	System.out.println("View Employees -> Home");
    	this.frame.setVisible(false);
		new HomeScreenManager(this.manager);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("View Employees -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnViewEmployeesPressed(ActionEvent event) {

    }

}
