package basic.control;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//UI : Button.fxml
//Controller : ButtonController.java
public class ButtonExample extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {
      BorderPane root = FXMLLoader.load(getClass().getResource("root.fxml")); // FXML파일 읽어오기

      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

 

}