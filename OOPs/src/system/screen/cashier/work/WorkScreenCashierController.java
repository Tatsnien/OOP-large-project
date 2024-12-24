package system.screen.cashier.work;

import java.awt.FlowLayout;
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
import system.service.MembershipService;

public class WorkScreenCashierController {
	
	private JFrame frame;
	private Cashier cashier;
	private Customer customer;
	private Cart cart;
	private Bill bill;
	private PaymentService paymentService;
	private MembershipService membershipService;
	
	public WorkScreenCashierController(Cashier cashier) {
		this.cashier = cashier;
		this.bill = new Bill();
		this.customer = new Customer();
		this.membershipService = new MembershipService();
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		this.cart = customer.getCart();
		this.paymentService = new CashPaymentService(customer.getCart());
	}
	
	public String getPriceToString(float price) {
		return Double.toString(Math.round(price * 100) / 100.0);
	}

    @FXML
    private TableColumn<Item, Integer> colBarcode;

    @FXML
    private TableColumn<Item, String> colName;

    @FXML
    private TableColumn<Item, Integer> colQty;
    
    @FXML
    private TableColumn<Item, Float> colSellingPrice;
    
    @FXML
    private TableColumn<Item, Float> colPurchasePrice;

    @FXML
    private TableColumn<Item, Float> colItemTotal;
    
    @FXML
    private Label lbPhoneNbStatus;

    @FXML
    private Label lbDiscount;

    @FXML
    private Label lbMemberName;

    @FXML
    private Label lbName;

    @FXML
    private Label lbPaymentStatus;

    @FXML
    private Label lbSubTotal;

    @FXML
    private Label lbTax;

    @FXML
    private Label lbTotal;

    @FXML
    private ToggleGroup paymentMethods;

    @FXML
    private RadioButton rbCard;

    @FXML
    private RadioButton rbCash;

    @FXML
    private RadioButton rbOnline;

    @FXML
    private TableView<Item> tblItem;

    @FXML
    private TextField tfPhoneNb;

    @FXML
    private TextField tfReceivedMoney;
    
    public void initialize() {
    	colBarcode.setCellValueFactory(
				new PropertyValueFactory<>("barcode"));
		
		colName.setCellValueFactory(
				new PropertyValueFactory<>("name"));
		
		colQty.setCellValueFactory(
				new PropertyValueFactory<>("quantity"));
		
		colSellingPrice.setCellValueFactory(
				new PropertyValueFactory<>("sellingPrice"));
		
		colPurchasePrice.setCellValueFactory(
				new PropertyValueFactory<>("purchasePrice"));
		
		colItemTotal.setCellValueFactory(
				new PropertyValueFactory<>("itemTotalPrice"));
		
		tblItem.setItems(customer.getCart().getItemsOrdered());
    }
    
    @FXML
    void btnSearchPressed(ActionEvent event) {
    	int phoneNumber = 0;
    	try {
    		phoneNumber = Integer.parseInt(tfPhoneNb.getText().strip());
    	}
    	catch (Exception e) {
    		lbPhoneNbStatus.setText("Invalid phone number");
    		tfPhoneNb.setText("");
    		lbMemberName.setText("-");
    	}
    	
    	lbPhoneNbStatus.setText("");
    	MemberCustomer member = membershipService.searchMemberCustomer(phoneNumber);
    	
    	if (member != null) {
    		lbMemberName.setText(member.getName().toUpperCase());
    		customer = member;
    		customer.setCart(cart);
    	}
    	else
    		lbMemberName.setText("-");
    }
    
    private String showInputDialog(int phoneNumber) {
        JDialog inputDialog = new JDialog(this.frame, "Input Dialog", true);
        inputDialog.setSize(400, 150);
        inputDialog.setLayout(new BoxLayout(inputDialog.getContentPane(), BoxLayout.Y_AXIS));
        inputDialog.setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
        
        JTextField nameField = new JTextField(20);

        inputDialog.add(new JLabel("Phone Number: " + phoneNumber));
        inputDialog.add(new JLabel("Name: "));
        inputDialog.add(nameField);

        // Create and add a submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
                inputDialog.dispose();
			}
        });
        inputDialog.add(submitButton);

        inputDialog.setVisible(true);
        
        return nameField.getText().strip();
    }
    
    @FXML
    void btnAddPressed(ActionEvent event) {
    	if (tfPhoneNb.getText() == "") {
    		lbPhoneNbStatus.setText("Please enter phone number.");
    		return;
    	}
    	if (lbMemberName.getText().equals("-")) {
    		lbPhoneNbStatus.setText("Press \"Search\" first.");
    		return;
    	}
    	
    	int phoneNumber = Integer.parseInt(tfPhoneNb.getText().strip());
    	String memberName = showInputDialog(phoneNumber);
    	
    	MemberCustomer newMember = new MemberCustomer(phoneNumber, memberName);
    	lbPhoneNbStatus.setText("Member \"" + phoneNumber + "\" added");
    	tfPhoneNb.setText("");
    	lbMemberName.setText("-");
    	membershipService.addMemberCustomer(newMember);
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	if (tfPhoneNb.getText() == "") {
    		lbPhoneNbStatus.setText("Please enter phone number.");
    		return;
    	}
    	if (lbMemberName.getText().equals("-")) {
    		lbPhoneNbStatus.setText("Press \"Search\" first.");
    		return;
    	}
    	
    	lbPhoneNbStatus.setText("Member \"" + ((MemberCustomer) this.customer).getPhoneNumber() + "\" deleted");
    	tfPhoneNb.setText("");
    	lbMemberName.setText("-");
    	membershipService.removeMemberCustomer((MemberCustomer) this.customer);
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
    		// Make payment
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
