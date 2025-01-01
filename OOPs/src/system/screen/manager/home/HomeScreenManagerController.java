package system.screen.manager.home;

import java.util.List;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import personnel.StoreBranchManager;
import system.notice.Notice;
import system.screen.manager.profile.ProfileScreenManager;
import system.screen.manager.work.discount.WorkScreenManagerDiscount;
import system.screen.manager.work.expense.WorkScreenManagerExpense;
import system.screen.manager.work.items.WorkScreenManagerItems;
import system.screen.manager.work.personnel.WorkScreenManagerPersonnel;
import system.screen.manager.work.report.WorkScreenManagerReport;

public class HomeScreenManagerController {

	private StoreBranchManager manager;
	private JFrame frame;
	
	@FXML
    private Label lbName;

    @FXML
    private Menu mnHome;

    @FXML
    private Menu mnProfile;

    @FXML
    private Menu mnWork;

    @FXML
    private MenuItem mnWorkExpenses;
    
    @FXML
    private MenuItem mnWorkDiscounts;

    @FXML
    private MenuItem mnWorkItems;

    @FXML
    private MenuItem mnWorkPersonnel;

    @FXML
    private VBox vbNotice;

    
    public HomeScreenManagerController(StoreBranchManager manager) {
    	this.manager = manager;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(manager.getName());
		
		List<Notice> notices = manager.getAccount().getNotices();
		for (int i = 0; i < notices.size(); ++i) {
			Notice notice = notices.get(i);
			if (i != 0)
				createSeparator();
			createNoticeLabel(notice, i + 1);
			System.out.println("Notice " + (i + 1) + " added.");
		}
	}
	
	private void createSeparator() {
		Separator sep = new Separator();
		vbNotice.getChildren().add(sep);
	}
	
	private void createNoticeLabel(Notice notice, int nb) {
		HBox label_date = new HBox();
		label_date.setAlignment(Pos.CENTER_LEFT);
		label_date.setSpacing(10);
		
		Label lbTitle = new Label();
		lbTitle.setText(notice.getTitle());
		lbTitle.setFont(new Font("Arial", 16));
		lbTitle.setStyle("-fx-font-weight: bold;");
		
		Label lbDate = new Label();
		lbDate.setText(notice.printDate());
		
		label_date.getChildren().add(lbTitle);
		label_date.getChildren().add(lbDate);
		
		vbNotice.getChildren().add(label_date);
	}
	
	 @FXML
    void mnHomePressed(ActionEvent event) {

    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Home -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenManager(this.manager);
    }
    
    @FXML
    void mnWorkExpensesPressed(ActionEvent event) {
    	System.out.println("Work -> Expenses");
    	this.frame.setVisible(false);
    	new WorkScreenManagerExpense(this.manager);
    }

    @FXML
    void mnWorkItemsPressed(ActionEvent event) {
    	System.out.println("Work -> Items");
    	this.frame.setVisible(false);
    	new WorkScreenManagerItems(this.manager);
    }

    @FXML
    void mnWorkPersonnelPressed(ActionEvent event) {
    	System.out.println("Work -> Personnel");
    	this.frame.setVisible(false);
    	new WorkScreenManagerPersonnel(this.manager);
    }

    @FXML
    void mnWorkReportsPressed(ActionEvent event) {
    	System.out.println("Work -> Reports");
    	this.frame.setVisible(false);
    	new WorkScreenManagerReport(this.manager);
    }
    
    @FXML
    void mnWorkDiscountsPressed(ActionEvent event) {
    	System.out.println("Work -> Discounts");
    	this.frame.setVisible(false);
    	new WorkScreenManagerDiscount(this.manager);
    }
}
