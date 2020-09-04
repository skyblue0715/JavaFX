package basic.control;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import basic.common.ConnectionDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;

public class ChartController implements Initializable {
	@FXML
	private BarChart barChart;
	@FXML
	private PieChart pieChart;
	@FXML
	private AreaChart areaChart;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Data> list = FXCollections.observableArrayList();
		list.add(new PieChart.Data("AWT", 10));
		list.add(new PieChart.Data("Swing", 30));
		list.add(new PieChart.Data("SWT", 25));
		list.add(new PieChart.Data("JavaFx", 35));
		pieChart.setData(list);
		XYChart.Series<String, Integer> s1 = new XYChart.Series<>();
		XYChart.Series<String, Integer> s2 = new XYChart.Series<>();
		XYChart.Series<String, Integer> s3 = new XYChart.Series<>();
		XYChart.Series<String, Integer> s4 = new XYChart.Series<>();
		s1.setData(getSeries1());
		s1.setName("남자");

		s2.setData(getSeries2());
		s2.setName("여자");

		s3.setData(getSeries3());
		s3.setName("온도");

		s4.setData(getSeries4());
		s4.setName("코로나");
		barChart.getData().add(s1);
		barChart.getData().add(s2);

		areaChart.getData().add(s3);
		//areaChart.getData().add(s4);

	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries1() {
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("2015", 70));
		list.add(new XYChart.Data<String, Integer>("2016", 40));
		list.add(new XYChart.Data<String, Integer>("2017", 50));
		list.add(new XYChart.Data<String, Integer>("2018", 30));

		return list;

	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries2() {
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("2015", 70));
		list.add(new XYChart.Data<String, Integer>("2016", 40));
		list.add(new XYChart.Data<String, Integer>("2017", 50));
		list.add(new XYChart.Data<String, Integer>("2018", 30));

		return list;

	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries3() {
		Connection conn = ConnectionDB.getDB();
		String sql = "select * from receipt";
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new XYChart.Data<>(rs.getString("receipt_month"), rs.getInt("receipt_qty")));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;

	}

	public ObservableList<XYChart.Data<String, Integer>> getSeries4() {
		ObservableList<XYChart.Data<String, Integer>> list = FXCollections.observableArrayList();
		list.add(new XYChart.Data<String, Integer>("09", 5));
		list.add(new XYChart.Data<String, Integer>("10", 12));
		list.add(new XYChart.Data<String, Integer>("11", 15));
		list.add(new XYChart.Data<String, Integer>("12", 25));

		return list;

	}
}
