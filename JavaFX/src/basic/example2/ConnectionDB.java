package basic.example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionDB {

	private static PreparedStatement pstmt;

	public static Connection getDB() throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr", passwd = "hr";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public void runDB() throws ClassNotFoundException, SQLException {
	// 커넥션생성
	Connection conn = getDB();
	// 실행 쿼리
	String sql = "SELECT ID, NAME, EMAIL FROM MEMBER";
	// Statement생성 후실행할 쿼리정보	등록
	Statement stmt = null;
	try {
		stmt = conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	// 결과를 담을 ResultSet 생성 후 결과 담기
	ResultSet rs = stmt.executeQuery(sql);
	// 결과를 담을 ArrayList생성
	ArrayList<Student> list = new ArrayList<Student>();
	// ResultSet에 담긴 결과를 ArrayList에 담기
	try {
		while(rs.next())
		{
			Student stu = new Student();
			stu.setId(rs.getString("ID"));
			stu.setName(rs.getString("NAME"));
			stu.setKorean(rs.getInt("KOREAN"));
			stu.setMath(rs.getInt("MATH"));
			stu.setEnglish(rs.getInt("ENGLISH"));
			list.add(stu);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // 결과물 출력
	for(
	int i = 0;i<list.size();i++)
	{
		System.out.println("회원아이디:" + list.get(i).getId());
		System.out.println("회원이름:" + list.get(i).getName());
		System.out.println("회원이메일:" + list.get(i).getKorean());
	}
	}
}
