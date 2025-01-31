package system.screen.staff.home;

import java.util.List;

import javax.swing.JFrame;

import data.Notice;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import personnel.Staff;
import system.screen.staff.profile.ProfileScreenStaff;
import system.screen.staff.work.check.CheckScreenStaff;
import system.screen.staff.work.importing.ImportingScreenStaff;

public class HomeScreenStaffController {

	private Staff staff;
	private JFrame frame;
	
	@FXML
    private Label lbName;

    @FXML
    private VBox vbNotice;
    
    public HomeScreenStaffController(Staff staff) {
    	this.staff = staff;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(staff.getName());
		
		List<Notice> notices = staff.getAccount().getNotices();
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
		new ProfileScreenStaff(this.staff);
    }
    
    @FXML
    void mnCheckPressed(ActionEvent event) {
    	System.out.println("Home -> Check");
    	this.frame.setVisible(false);
		new CheckScreenStaff(this.staff);
    }
    
    @FXML
    void mnImportPressed(ActionEvent event) {
    	System.out.println("Home -> Import");
    	this.frame.setVisible(false);
		new ImportingScreenStaff(this.staff);
    }

}
