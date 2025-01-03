package system.screen.manager.work.expense;

import javax.swing.JFrame;

import personnel.StoreBranchManager;
import system.service.ExpenseManagementService;

public class WorkScreenManagerExpenseController {
	private JFrame frame;
	private StoreBranchManager manager;
	private ExpenseManagementService service;
	
	public WorkScreenManagerExpenseController(StoreBranchManager manager) {
		this.manager = manager;
		this.service = new ExpenseManagementService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
