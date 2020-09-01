package basic.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//ui: View.fxml(909page)
//control: ViewController.java
public class ViewExample extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AnchorPane root1=FXMLLoader.load(this.getClass().getResource("View.fxml"));
		Scene scene=new Scene(root1);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	  public static void main(String[] args) {
	      Application.launch(args);
	   }

}

