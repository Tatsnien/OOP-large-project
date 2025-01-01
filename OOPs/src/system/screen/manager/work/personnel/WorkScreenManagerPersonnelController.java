package system.screen.manager.work.personnel;

import javax.swing.JFrame;

import personnel.StoreBranchManager;
import system.service.PersonnelManagementService;

public class WorkScreenManagerPersonnelController {
	private JFrame frame;
	private StoreBranchManager manager;
	private PersonnelManagementService service;
	
	public WorkScreenManagerPersonnelController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = new PersonnelManagementService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
