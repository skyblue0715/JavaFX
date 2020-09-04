package basic.example2;

import java.io.Closeable;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
public class RootController implements Initializable {
	@FXML
	TableView<Student> tableView;
	@FXML
	Button btnAdd, btnBarChart;
@FXML Text txtId;
@FXML Text txtName;
@FXML Text txtKorean;
@FXML Text txtMath;
@FXML Text txtEnglish;

	ObservableList<Student> list;
	

	Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		StuDAO stuDAO=new StuDAO();
		
		TableColumn <Student,?> tvStu=new TableColumn();
		this.primaryStage = primaryStage;
		
		
	}
	public void showOverView() {
		list=StuDAO.getData();
		txtId.setCellValueFactory
		
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
