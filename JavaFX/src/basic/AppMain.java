package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox=new HBox();
		hbox.setPadding(new Insets(10));
		hbox.setSpacing(10);
		
		TextField tField=new TextField();
		tField.setPrefWidth(200);
		
		Button btn=new Button();
		btn.setText("확인");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				
			}
		});
		
		hbox.getChildren().add(tField);
		hbox.getChildren().add(btn);
		
		Scene scene=new Scene(hbox);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
