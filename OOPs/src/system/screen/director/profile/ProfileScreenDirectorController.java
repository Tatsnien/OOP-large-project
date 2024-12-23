package system.screen.director.profile;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import personnel.Director;
import system.screen.director.home.HomeScreenDirector;
import system.screen.director.work.WorkScreenDirector;

public class ProfileScreenDirectorController{

	private Director director;
	private JFrame frame;
	
	@FXML
    private Label lbName;

    @FXML
    private Label lbProfileId;

    @FXML
    private Label lbProfileName;

    @FXML
    private Label lbProfilePosition;

    @FXML
    private Label lbProfileSalary;

    
    public ProfileScreenDirectorController(Director director) {
    	this.director = director;
    }
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void initialize() {
		lbName.setText(director.getName());
		lbProfileName.setText(director.getName());
		lbProfileId.setText(director.getAccount().getId());
		lbProfilePosition.setText(director.getPosition());
		lbProfileSalary.setText(Math.round(director.getSalary() * 100) / 100.0 + " VNĐ");
	}
	
	@FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenDirector(this.director);
    }
    
    @FXML
    void mnProfilePressed(ActionEvent event) {
    	
    }

}
