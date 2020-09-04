package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChartExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox=FXMLLoader.load(this.getClass().getResource("ChartRoot.fxml"));
		Scene scene=new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
public static void main(String[] args) {
	Application.launch(args);
}
}
