package system.screen.staff.work.check;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;

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
import javafx.scene.paint.Color;
import personnel.Staff;
import system.DAO;
import system.notice.Notice;
import system.screen.staff.home.HomeScreenStaff;
import system.screen.staff.profile.ProfileScreenStaff;
import system.screen.staff.work.importing.ImportingScreenStaff;
import system.service.ItemService;
import system.service.StoreBranchService;

public class CheckScreenStaffController {
	
	private Staff staff;
	private JFrame frame;
	private ItemService itemService;
	private ObservableList<ItemGroup> missingGroups;
	private String currentName;
	private String currentStock;
	
	public CheckScreenStaffController(Staff staff) {
		this.staff = staff;
		this.itemService = this.staff.getItemService();
		
		this.missingGroups = FXCollections.observableArrayList();
		this.missingGroups.addAll(this.itemService.getGroups());
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	@FXML
	private TableColumn<ItemGroup, String> colBarcode;
	
	@FXML
	private TableColumn<ItemGroup, String> colName;
	
	@FXML
	private TableColumn<ItemGroup, String> colType;

	@FXML
    private TableColumn<ItemGroup, Integer> colCount;

    @FXML
    private Label lbName;

    @FXML
    private Label lbSendReportStatus;

    @FXML
    private Label lbUpdateCheckStatus;

    @FXML
    private TableView<ItemGroup> tblItems;

    @FXML
    private TextField tfItemBarcode;

    @FXML
    private TextField tfItemCount;
    
    private void printError(Label lbStatus, String message) {
    	System.out.println(message);
		lbStatus.setTextFill(Color.RED);
		lbStatus.setText(message);
    }
    
    private void printSuccessful(Label lbStatus, String message) {
    	lbStatus.setTextFill(Color.GREEN);
    	lbStatus.setText(message);
    }

    @FXML
    void sendReportPressed(ActionEvent event) {
    	// Create notice to manager
    	Notice notice = new Notice(
    			this.staff,
    			StoreBranchService.searchManager(this.staff.getWorkingBranchNumber()),
    			"Check stock");
    	
    	String content = "";
    	if (this.missingGroups.size() > 0) {
    		content = "Missing items:\n";
    		for (ItemGroup group : this.missingGroups)
    			content += group.getItemInfo() + ", quantity: " + group.getQty();
    	}
    	else
    		content = "No missing items.";

    	// Save notice
    	notice.setContent(content);
    	(new DAO()).saveNotices(Arrays.asList(new Notice[]{notice}));
    	
    	// Save items
    	for (ItemGroup group : itemService.getGroups())
    		if (missingGroups.contains(group))
    			group.setQty(group.getQty() - missingGroups.get(missingGroups.indexOf(content)).getQty());
    	(new DAO()).saveItems(this.itemService.getGroups());
    	tblItems.refresh();
    }

    @FXML
    void updateCheckPressed(ActionEvent event) {
    	if (this.missingGroups.contains(tfItemBarcode.getText())) {
    		int qty = 0;
    		int idx = this.missingGroups.indexOf(tfItemBarcode.getText());
    		try {
    			qty = Integer.parseInt(tfItemCount.getText());
    		} catch (Exception e) {
    			printError(lbUpdateCheckStatus, "Invalid quantity. Please enter a number.");
    			return;
    		}
    		if (qty > this.missingGroups.get(idx).getQty()) {
    			printError(lbUpdateCheckStatus, "Invalid quantity. Not enough items.");
    			return;
    		}
    		this.missingGroups.get(idx).setQty(this.missingGroups.get(idx).getQty() - qty);
    		printSuccessful(lbUpdateCheckStatus, "Successfully updated.");
    		tblItems.refresh();
    	}
    	else 
    		printError(lbUpdateCheckStatus, "Item not in items list");
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
