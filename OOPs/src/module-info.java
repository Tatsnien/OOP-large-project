module OOPs {
	exports system.service;
	exports system;
	exports system.screen.manager;
	exports data;
	exports test;
	exports personnel;
	exports system.notice;
	exports system.screen.director;
	exports system.screen.staff;
	exports customer;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires transitive javafx.base;
	
	opens system to javafx.fxml;
	opens system.screen.director to javafx.fxml;
	opens system.screen.manager to javafx.fxml;
	opens system.screen.staff to javafx.fxml;
	opens system.screen.cashier.home to javafx.fxml;
	opens system.screen.cashier.work to javafx.fxml;
	opens system.screen.cashier.profile to javafx.fxml;
}