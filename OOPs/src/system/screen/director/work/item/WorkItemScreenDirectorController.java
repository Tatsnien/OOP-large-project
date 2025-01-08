package system.screen.director.work.item;

import java.util.ArrayList;
import javax.swing.JFrame;
import data.ItemGroup;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.profile.ProfileScreenDirector;
import system.screen.director.work.branch.WorkBranchScreenDirector;
import system.screen.director.work.expense.WorkExpenseScreenDirector;
import system.screen.director.work.personnel.WorkPersonnelScreenDirector;
import system.service.ItemService;

public class WorkItemScreenDirectorController {

	private Director director;
	private JFrame frame;
	private ItemService groups;
	
	public WorkItemScreenDirectorController(Director director) {
    	this.director = director;
    	this.groups = new ItemService(new ArrayList<>());
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	@FXML
    private TableColumn<ItemGroup, String> colBarcode;

    @FXML
    private TableColumn<ItemGroup, String> colInfo;

    @FXML
    private TableColumn<ItemGroup, String> colName;

    @FXML
    private TableColumn<ItemGroup, Integer> colQty;

    @FXML
    private TableColumn<ItemGroup, String> colType;

    @FXML
    private Label lbName;

    @FXML
    private Label lbStatus;

    @FXML
    private TableView<ItemGroup> tblItems;
    
    public void initialize() {
		lbName.setText(this.director.getName());
		
		colBarcode.setCellValueFactory(
				new PropertyValueFactory<>("barcode"));
		
		colInfo.setCellValueFactory(
				new PropertyValueFactory<>("itemInfo"));
		
		colName.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		
		colQty.setCellValueFactory(
				new PropertyValueFactory<>("qty"));
		
		colType.setCellValueFactory(
				new PropertyValueFactory<>("itemType"));
		
		tblItems.setItems((ObservableList<ItemGroup>) groups.getGroups());
		
	}

    @FXML
    void mnHomePressed(ActionEvent event) {
    	System.out.println("Items -> Home");
    	this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Items -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkBranchPressed(ActionEvent event) {
    	System.out.println("Items -> Branches");
    	this.frame.setVisible(false);
    	new WorkBranchScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Items -> Personnel");
    	this.frame.setVisible(false);
    	new WorkPersonnelScreenDirector(this.director);
    }
    
    @FXML
    void mnWorkExpensePressed(ActionEvent event) {
    	System.out.println("Items -> Expenses");
    	this.frame.setVisible(false);
    	new WorkExpenseScreenDirector(this.director);
    }

    @FXML
    void mnWorkItemPressed(ActionEvent event) {
    	
    }

}
