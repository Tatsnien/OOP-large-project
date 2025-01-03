package system.screen.manager.work.report;

import javax.swing.JFrame;

import personnel.StoreBranchManager;
//import system.service.ManagerService;

public class WorkScreenManagerReportController {

	private StoreBranchManager manager;
	private JFrame frame;
//	private ManagerService service;
	
	public WorkScreenManagerReportController(StoreBranchManager manager) {
		this.manager = manager;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// TODO FXML
}
