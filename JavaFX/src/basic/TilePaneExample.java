package basic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application{

	@Override
	public void start(Stage arg0) throws Exception {
		TilePane tilepane=new TilePane();
		tilepane.setPrefTileHeight(100);
		tilepane.setPrefWidth(100);
		
		ImageView iv=new ImageView();
		ImageView iv2=new ImageView();
		ImageView iv3=new ImageView();
		ImageView iv4=new ImageView();
		
		iv.setImage(new Image("/basic/images/javafx.jpg"));
		iv.setImage(new Image("/basic/images/fruit1.jpg"));
		iv.setImage(new Image("/basic/images/fruit2.jpg"));
		iv.setImage(new Image("/basic/images/fruit3.jpg"));
		tilepane.getChildren().add(iv);
		tilepane.getChildren().add(iv2);
		tilepane.getChildren().add(iv3);
		tilepane.getChildren().add(iv4);
		Scene scene=new Scene(tilepane);
		arg0.setScene(scene);
		arg0.show();
		arg0.setTitle("컨테이너 예제");
	}
public static void main(String[] args) {
	Application.launch(args);
}
	
}
