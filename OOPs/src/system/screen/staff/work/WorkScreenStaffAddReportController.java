package system.screen.staff.work;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import data.Item;
import data.ItemGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class WorkScreenStaffAddReportController {
	
	private JFrame frame;
	private Staff staff;
	private ObservableList<ItemGroup> itemsList;
	private String currentName;
	private String currentStock;
	
	public WorkScreenStaffAddReportController(Staff staff) {
		this.staff = staff;
		itemsList = FXCollections.observableArrayList();
		for (int i = 0; i < items.size(); ++i)
			itemsList.add(new ItemGroup(items.get(i), qty.get(i)));			
	}

    @FXML
    private TableColumn<ItemGroup, Integer> colCount;

    @FXML
    private TableColumn<ItemGroup, String> colName;

    @FXML
    private Label lbName;
    
    @FXML
    private java.awt.Label lbUpdateCheck;
    
    private Label lbSendReport;

    @FXML
    private TextField stockCheckSearchbar;

    @FXML
    private TableView<ItemGroup> tblItems;

    @FXML
    private TextField tfItemCount;

    @FXML
    private TextField tfItemName;
    
    public void setFrame(JFrame frame) {
		this.frame = frame;
	}
    
    public void initialize() {
    	colCount.setCellValueFactory(
    			new PropertyValueFactory<>("quantity"));
    	colName.setCellValueFactory(
    			new PropertyValueFactory<>("name"));
    	tblItems.setItems(this.itemsList);
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
    void mnCheckPressed(ActionEvent event) {
    	
    }

    @FXML
    void mnHomePressed(ActionEvent event) {
    	new HomeScreenStaff(staff);
    }

    @FXML
    void mnImportPressed(ActionEvent event) {
    	// new WorkScreenStaffImportReport(staff);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	new ProfileScreenStaff(staff);
    }

    @FXML
    void sendReportPressed(ActionEvent event) {
    	// TODO
    }

    @FXML
    void updateCheckPressed(ActionEvent event) {
    	try {
    		boolean found = false;
    		for (Item i: itemsList) {
    			if (i.getName() == currentName) {
    				found = true;
    				i.setQuantity(Integer.parseInt(currentStock));
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

}
