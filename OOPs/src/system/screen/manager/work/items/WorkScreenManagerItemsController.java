package system.screen.manager.work.items;

import javax.swing.JFrame;

import personnel.StoreBranchManager;
import system.service.ItemManagementService;

public class WorkScreenManagerItemsController {
	private JFrame frame;
	private StoreBranchManager manager;
	private ItemManagementService service;
	
	public WorkScreenManagerItemsController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = new ItemManagementService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// TODO DO FXML
}
