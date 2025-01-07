package system.screen.staff.work.check;

import javax.swing.JFrame;

import data.ItemGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.Staff;
import system.screen.staff.home.HomeScreenStaff;
import system.screen.staff.profile.ProfileScreenStaff;
import system.screen.staff.work.importing.ImportingScreenStaff;
import system.service.ItemService;

public class CheckScreenStaffController {
	
	private Staff staff;
	private JFrame frame;
	private ItemService itemService;
	private ObservableList<ItemGroup> groups;
	private String currentName;
	private String currentStock;
	
	public CheckScreenStaffController(Staff staff) {
		this.staff = staff;
		this.itemService = new ItemService(this.staff);
		this.groups = (ObservableList<ItemGroup>) itemService.getGroups();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

    @FXML
    private TableColumn<ItemGroup, Integer> colCount;

    @FXML
    private TableColumn<ItemGroup, String> colName;

    @FXML
    private Label lbName;
    
    @FXML
    private Label lbUpdateCheck;
    
    private Label lbSendReport;

    @FXML
    private TextField stockCheckSearchbar;

    @FXML
    private TableView<ItemGroup> tblItems;

    @FXML
    private TextField tfItemCount;

    @FXML
    private TextField tfItemName;
    
    public void initialize() {
    	colCount.setCellValueFactory(
    			new PropertyValueFactory<>("quantity"));
    	colName.setCellValueFactory(
    			new PropertyValueFactory<>("name"));
    	tblItems.setItems(this.groups);
    	tfItemCount.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			currentStock = newValue;
    		}
    	});
    	tfItemName.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    			currentName = newValue;
    		}
    	});
    	lbName.setText(staff.getName());
    }

    @FXML
    void sendReportPressed(ActionEvent event) {
    	// TODO
    }

    @FXML
    void updateCheckPressed(ActionEvent event) {
    	try {
    		boolean found = false;
    		for (ItemGroup i: groups) {
    			if (i.getName() == currentName) {
    				found = true;
    				i.setQty(Integer.parseInt(currentStock));
    				lbUpdateCheck.setText("Successfully updated.");
    			}
    		}
    		if (found == false) {
    			lbUpdateCheck.setText("Item not in items list");
    		}
    	} catch (Exception e) {
    		lbUpdateCheck.setText("Invalid inputs");
    	}
    }
	
	@FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Check -> Home");
    	this.frame.setVisible(false);
		new HomeScreenStaff(this.staff);
    }
	
	@FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Check -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenStaff(this.staff);
    }
    
    @FXML
    void mnCheckPressed(ActionEvent event) {
    	
    }
    
    @FXML
    void mnImportPressed(ActionEvent event) {
    	System.out.println("Check -> Impor");
    	this.frame.setVisible(false);
		new ImportingScreenStaff(this.staff);
    }

}
