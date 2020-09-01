package basic.control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class root1Controller implements Initializable {
	@FXML
	private TextField txtTitle;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private ComboBox<String> comboPublic;
	@FXML
	private DatePicker dateExit;
	@FXML
	private TextArea txtContent;
	@FXML
	private Button btnReg;
	@FXML
	private Button btnCanCel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnReg.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				handleBtnRegAction();
			};

			public void handleBtnRegAction() {
				if (txtTitle.getText() == null || txtTitle.getText().equals("")) {
					showPopup("타이틀을 입력하세요");
				} else if (txtPassword.getText() == null || txtPassword.getText().equals("")) {
					showPopup("비밀번호를 입력하세요");
				} else if (comboPublic.getValue() == null || comboPublic.getValue().equals("")) {
					showPopup("공개여부를 지정하세요");
				}
			}
		});

		/*
		 * String title = txtTitle.getText(); System.out.println("title : " + title);
		 * 
		 * String password = txtPassword.getText(); System.out.println("password : " +
		 * password);
		 * 
		 * String strPublic = comboPublic.getValue(); System.out.println("public " +
		 * strPublic);
		 * 
		 * LocalDate localDate = dateExit.getValue(); if (localDate != null) {
		 * System.out.println("dateExit :" + localDate.toString()); } String
		 * content=txtContent.getText(); System.out.println("content:"+content);
		 */
	}

	public void showPopup(String msg) {
		// popup 타이틀 등록.
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: black; -fx-background-radius: 20;");
		hbox.setAlignment(Pos.CENTER);

		ImageView iv = new ImageView();
		iv.setImage(new Image("basic/images/dialog-info.png"));

		Label label = new Label();
		label.setText("타이틀을 등록하세요");
		label.setStyle("-fx-text-fill: yellow; ");
		hbox.getChildren().addAll(iv, label);

		Popup pop = new Popup();
		pop.getContent().add(hbox);
		pop.setAutoHide(true);
		pop.show(btnReg.getScene().getWindow());
	}
	public void showCustomDialog(String msg) {
		Stage stage=new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(btnReg.getScene().getWindow());
		
		AnchorPane ap=new AnchorPane();
		ap.setPrefSize(400, 150);
		
		ImageView iv=new ImageView();
		iv.setImage(new Image("basic/images/dialog-info.png"));
		iv.setFitWidth(50);
		iv.setFitHeight(50);
		iv.setLayoutX(15);
		iv.setLayoutY(15);
		iv.setPreserveRatio(true);
		
		Button btnOk=new Button("확인");
		btnOk.setLayoutX(336);
		btnOk.setLayoutY(104);
		btnOk.setOnAction((e)->stage.close());
		
		Label label=new Label(msg);
		label.setLayoutX(87);
		label.setLayoutY(33);
		label.setPrefSize(290, 15);
		
		Scene scene = new Scene(ap);
		stage.setScene(scene);
		stage.show();
	}
	/*
	 * public void handleBtnCancelAction(ActionEvent e) { Platform.exit(); }
	 */
}
