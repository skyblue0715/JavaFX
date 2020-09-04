package basic.control;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.text.AbstractDocument.Content;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Boardcontroller implements Initializable {
	@FXML
	TableView<Board> boardView;
	@FXML
	TextField txtTitle;
	@FXML
	ComboBox<String> comboPublic;
	@FXML
	TextField txtExitDate;
	@FXML
	TextArea txtArea;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		TableColumn<Board, String> tcTitle = new TableColumn<>("Title");
		tcTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
		tcTitle.setPrefWidth(80);
		boardView.getColumns().add(tcTitle);

		TableColumn<Board, String> tcPublicity = new TableColumn<>("공개여부");
		tcPublicity.setCellValueFactory(new PropertyValueFactory<>("publicity"));
		tcPublicity.setPrefWidth(80);
		boardView.getColumns().add(tcPublicity);

		boardView.setItems(getBoardList());

		boardView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Board>() {

			@Override
			public void changed(ObservableValue<? extends Board> observable, Board oldValue, Board newValue) {
				// TODO Auto-generated method stub
				txtTitle.setText(newValue.getTitle());
				comboPublic.setValue(newValue.getPublicity());
				txtExitDate.setText(newValue.getExitDate());
				txtArea.setText(newValue.getContent());
			}
		});
	}

	public ObservableList<Board> getBoardList() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr", passwd = "hr";

		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String sql = "select * from new_board order by 1";
		ObservableList<Board> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board(rs.getString("title"), rs.getString("password"), rs.getString("publicity"),
						rs.getString("exit_date"), rs.getString("content"));
				list.add(board);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
