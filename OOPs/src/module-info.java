module OOPs {
	exports system.service;
	exports system;
	exports data;
	exports test;
	exports personnel;
	exports system.notice;
	exports customer;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires transitive javafx.base;
	
	opens system to javafx.fxml;
	opens system.screen.director.home to javafx.fxml;
	opens system.screen.director.profile to javafx.fxml;
	opens system.screen.manager.home to javafx.fxml;
	opens system.screen.manager.profile to javafx.fxml;
	opens system.screen.staff.home to javafx.fxml;
	opens system.screen.staff.profile to javafx.fxml;
	opens system.screen.cashier.home to javafx.fxml;
	opens system.screen.cashier.work to javafx.fxml;
	opens system.screen.cashier.profile to javafx.fxml;
}