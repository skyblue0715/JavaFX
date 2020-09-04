package basic.example2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.attribute.standard.MediaSize.Engineering;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StuDAO {
	ObservableList<Student> list;
	private static PreparedStatement pstmt;
	private static Connection con;

	private int num;

	public StuDAO() {
		ConnectionDB connect = new ConnectionDB();
		if (connect == null) {
			con = connect.getDB();
		}
	}

	public ObservableList<Student> getData() {
		try {
			pstmt = con.prepareStatement("select*from student");

			list = FXCollections.observableArrayList();
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Student student=new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setKorean(rs.getInt("korean"));
				student.setMath(rs.getInt("math"));
				student.setEnglish(rs.getInt("english"));
				
				list.add(student);
				
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}return list;
	}
}
