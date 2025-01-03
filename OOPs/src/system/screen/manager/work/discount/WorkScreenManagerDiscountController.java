package system.screen.manager.work.discount;

import javax.swing.JFrame;

import personnel.StoreBranchManager;
import system.service.DiscountManagerService;

public class WorkScreenManagerDiscountController {

	private JFrame frame;
	private StoreBranchManager manager;
	private DiscountManagerService service;
	
	public WorkScreenManagerDiscountController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = new DiscountManagerService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	// TODO Implement FXML "workmanagerdiscount.fxml"
}
