package system.screen.cashier;

import java.util.*;

import javax.swing.JFrame;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import personnel.*;
import system.notice.Notice;

public class HomeScreenCashierController {
	
	private Cashier cashier;
	private JFrame frame;
	private Scene scene;
	
	@FXML
    private Label lbName;

    @FXML
    private VBox vbNotice;
    
    public HomeScreenCashierController(Cashier cashier) {
    	this.cashier = cashier;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	public void initialize() {
		lbName.setText(cashier.getName());
		
		List<Notice> notices = cashier.getAccount().getNotices();
		for (int i = 0; i < notices.size(); ++i) {
			Notice notice = notices.get(i);
			if (i != 0)
				createSeparator();
			createNoticeLabel(notice, i + 1);
		}
	}
	
	private void createSeparator() {
		Separator sep = new Separator();
	}
	
	private void createNoticeLabel(Notice notice, int nb) {
		HBox label_date = new HBox();
		label_date.setAlignment(Pos.CENTER_LEFT);
		label_date.setSpacing(10);
		
		Label lbTitle = new Label();
		lbTitle.setText(notice.getTitle());
		lbTitle.setFont(new Font("Arial", 16));
		
		Label lbDate = new Label();
		lbDate.setText(notice.printDate());
		
		label_date.getChildren().add(lbTitle);
		label_date.getChildren().add(lbDate);
		
		vbNotice.getChildren().add(label_date);
	}

}
