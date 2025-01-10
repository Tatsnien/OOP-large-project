module OOPs {
	exports system.service;
	exports system;
	exports data;
	exports test;
	exports personnel;
	exports customer;
	exports payment;

	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.swing;
	requires transitive javafx.base;
	
	opens system to javafx.fxml;
	opens system.screen.director.home to javafx.fxml;
	opens system.screen.director.profile to javafx.fxml;
	opens system.screen.director.work.branch to javafx.fxml;
	opens system.screen.director.work.personnel to javafx.fxml;
	opens system.screen.director.work.expense to javafx.fxml;
	opens system.screen.director.work.item to javafx.fxml;
	opens system.screen.manager.home to javafx.fxml;
	opens system.screen.manager.profile to javafx.fxml;
	opens system.screen.manager.work.expense to javafx.fxml;
	opens system.screen.manager.work.item to javafx.fxml;
	opens system.screen.manager.work.personnel to javafx.fxml;
	opens system.screen.staff.home to javafx.fxml;
	opens system.screen.staff.profile to javafx.fxml;
	opens system.screen.staff.work.check to javafx.fxml;
	opens system.screen.staff.work.importing to javafx.fxml;
	opens system.screen.cashier.home to javafx.fxml;
	opens system.screen.cashier.work to javafx.fxml;
	opens system.screen.cashier.profile to javafx.fxml;
}