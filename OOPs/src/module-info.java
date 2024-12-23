module OOPs {
	exports system.service;
	exports system;
	exports system.screen.manager;
	exports data;
	exports test;
	exports system.screen.cashier;
	exports personnel;
	exports system.notice;
	exports system.screen.director;
	exports system.screen.staff;
	exports customer;

	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	
	opens system to javafx.fxml;
	opens system.screen.cashier to javafx.fxml;
	opens system.screen.director to javafx.fxml;
	opens system.screen.manager to javafx.fxml;
	opens system.screen.staff to javafx.fxml;
}