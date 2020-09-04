package basic.example2;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//UI : root.fxml(기본), addForm.fxml(추가), BarChart.fxml(차트)
//Control : RootController.java
public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Root.fxml"));
		
		
		BorderPane root=loader.load();
		
		RootController controller=loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene=new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
public static void main(String[] args)  {
	//Application.launch(args);
	ConnectionDB db=new ConnectionDB();
	db.runDB();
}
}
