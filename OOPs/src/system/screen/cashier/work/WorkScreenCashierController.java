package system.screen.cashier.work;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import customer.Cart;
import customer.Customer;
import customer.MemberCustomer;
import data.Item;
import data.ItemGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import payment.Bill;
import payment.CashPaymentService;
import payment.*;
import personnel.Cashier;
import system.screen.cashier.home.HomeScreenCashier;
import system.screen.cashier.profile.ProfileScreenCashier;
import system.service.ItemManagementService;

public class WorkScreenCashierController {
	
	private JFrame frame;
	private Cashier cashier;
	private Cart cart;
	private PaymentService paymentService;
	private ItemManagementService itemBranchService;
	private ItemManagementService itemCartService;
	
	public WorkScreenCashierController(Cashier cashier) {
		this.cashier = cashier;
		this.cart = new Cart();
		this.paymentService = new CashPaymentService(cart);
		this.itemBranchService = new ItemManagementService(cashier);
		this.itemCartService = new ItemManagementService(cart.getItemsOrdered(), cart.getQty());
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

    @FXML
    private TableColumn<ItemGroup, Integer> colBarcode;

    @FXML
    private TableColumn<ItemGroup, String> colName;

    @FXML
    private TableColumn<ItemGroup, Integer> colQty;
    
    @FXML
    private TableColumn<ItemGroup, Float> colSellingPrice;
    
    @FXML
    private TableColumn<ItemGroup, Float> colPurchasePrice;

    @FXML
    private TableColumn<ItemGroup, Float> colItemTotal;

    @FXML
    private Label lbPaymentStatus;

    @FXML
    private Label lbSubTotal;

    @FXML
    private Label lbTax;

    @FXML
    private Label lbTotal;
    
    @FXML
    private Label lbAddItemStatus;

    @FXML
    private ToggleGroup paymentMethods;

    @FXML
    private RadioButton rbCard;

    @FXML
    private RadioButton rbCash;

    @FXML
    private RadioButton rbOnline;

    @FXML
    private TableView<ItemGroup> tblItem;
    
    @FXML
    private TextField tfBarcode;

    @FXML
    private TextField tfQty;

    @FXML
    private TextField tfReceivedMoney;
    
    public void initialize() {
    	colBarcode.setCellValueFactory(
				new PropertyValueFactory<>("barcode"));
		
		colName.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		
		colQty.setCellValueFactory(
				new PropertyValueFactory<>("qty"));
		
		colSellingPrice.setCellValueFactory(
				new PropertyValueFactory<>("price"));
		
		colPurchasePrice.setCellValueFactory(
				new PropertyValueFactory<>("price"));
		
		colItemTotal.setCellValueFactory(
				new PropertyValueFactory<>("total"));
		
		tblItem.setItems(cart.getGroup());
    }
    
    @FXML
    void rbCardPressed(ActionEvent event) {
    	paymentService = new CardPaymentService(cart);
    }

    @FXML
    void rbCashPressed(ActionEvent event) {
    	paymentService = new CashPaymentService(cart);
    }

    @FXML
    void rbOnlinePressed(ActionEvent event) {
    	paymentService = new OnlinePaymentService(cart);
    }
    
    @FXML
    void btnUpdatePressed(ActionEvent event) {
    	// Handle item not in branch
    	int idxBranch = itemBranchService.searchItemIndex(tfBarcode.getText().strip());
    	if (idxBranch == -1) {
    		lbAddItemStatus.setText("Item not found.");
    		return;
    	}
    	
    	// Handle cashier makes an invalid input
    	int qty = 0;
    	Item item = itemBranchService.getItems().get(idxBranch);
    	try {
    		qty = Integer.parseInt(tfQty.getText());
    	} catch (Exception e) {
    		lbAddItemStatus.setText("Invalid quantity.");
    		return;
    	}
    	
    	// Handle quantity is larger than store capacity
    	if (qty > itemBranchService.getQty().get(idxBranch)) {
    		lbAddItemStatus.setText("Not enough items available.");
    		return;
    	}
    	
    	// Normal
    	int idxCart = itemCartService.searchItemIndex(tfBarcode.getText().strip());
    	if (idxCart == -1)
    		cart.addItem(item, qty);
    	else {
    		itemCartService.getQty().set(idxCart, qty);
    		cart.getGroup().set(idxCart, new ItemGroup(item, qty));
    	}
    	
    	tfBarcode.setText("");
    	tfQty.setText("");
    	lbSubTotal.setText(paymentService.calculateSubTotal() + "");
		lbTax.setText(paymentService.calculateTax() + "");
		lbTotal.setText(paymentService.calculateTotal() + "");
		lbAddItemStatus.setText("");
    }

    @FXML
    void btnPurchasePressed(ActionEvent event) {
    	float receivedMoney = 0;
    	try {
    		receivedMoney = Float.parseFloat(tfReceivedMoney.getText());    		
    	}
    	catch (Exception e) {
    		lbPaymentStatus.setText("Invalid value!");
    		return;
    	}
    	
    	if (receivedMoney < Float.parseFloat(lbTotal.getText())) {
    		lbPaymentStatus.setText("Not enough money!");
    		return;
    	}
    	else {
    		paymentService.makePayment();
    		cart.clearCart();
    		
    		tfBarcode.setText("");
        	tfQty.setText("");
        	tfReceivedMoney.setText("");
    		lbSubTotal.setText("-");
    		lbTax.setText("-");
    		lbTotal.setText("-");
    		lbAddItemStatus.setText("");
    	}    	
    }

    @FXML
	void mnHomePressed(ActionEvent event) {
		this.frame.setVisible(false);
		new HomeScreenCashier(this.cashier);
    }

    @FXML
    void mnProfilePressed(ActionEvent event) {
    	System.out.println("Home -> Profile");
    	this.frame.setVisible(false);
		new ProfileScreenCashier(this.cashier);
    }

    @FXML
    void mnWorkPressed(ActionEvent event) {

    }

}
