
package basic.container;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventHandler {
	public void start(Stage primaryStage) throws Exception {

		VBox root = new VBox();
		root.setPadding(new Insets(10, 10, 10, 10));

		ImageView iv = new ImageView();
		iv.setFitWidth(200);
		iv.setPreserveRatio(true);
		iv.setImage(new Image("/basic/images/javafx.jpg"));

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);

		Button btnPrev = new Button();
		btnPrev.setText("이전");
		Button btnNext = new Button("다음");
		HBox.setHgrow(btnNext, Priority.ALWAYS);
		btnNext.setMaxWidth(Double.MAX_VALUE);
		hbox.getChildren().add(btnPrev);
		hbox.getChildren().add(btnNext);
		VBox.setMargin(hbox, new Insets(10));

		// 이벤트 핸들러를 해당 컨트롤에 등록.

		/*
		 * btnNext.setOnAction(new EventHandler<ActionEvent>() {
		 * 
		 * });
		 */
		btnNext.setOnAction((ae) -> {
			int loc = 1;
			if (loc == 10)
				loc = 1;
			iv.setImage(new Image("/basic/images/fruit" + loc++ + ".jpg"));
		});

		root.getChildren().add(iv);
		root.getChildren().add(hbox);

		Scene scene = new Scene(root); // 스테이지>신>컨테이너 primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("VBox 예제");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
