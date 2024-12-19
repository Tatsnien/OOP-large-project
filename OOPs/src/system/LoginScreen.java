package system;

import data.StoreChain;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class LoginScreen extends Application{
	private StoreChain storeChain;
	
	@Override
	public void start(Stage stage) throws Exception{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
		Parent root = loader.load();
		
		LoginScreenController controller = loader.getController();
		controller.setStage(stage);
		
		Scene scene = new Scene(root);
		stage.setTitle("Login");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
