package javaOracle.p11;
import java.sql.*;
public class OracleInsert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost = 내pc의 아이피 주소 127.0.0.1 도 동일한 의미
		String user = "c##green";
		String password = "green1234";
		
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url,user,password);
			System.out.println("oracle connection success.\n");
			
			Statement stmt = conn.createStatement();
			
//			String sql = "SELECT * FROM dept";
			String sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				System.out.print(rs.getString("deptno")+" ");
//				System.out.print(rs.getString("dname")+" ");
//				System.out.println(rs.getString("loc")+" ");
//			}
			while(rs.next()) {
				System.out.print(rs.getString("stu_id")+" ");
				System.out.print(rs.getString("resident_id")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.print(rs.getString("year")+" ");
				System.out.print(rs.getString("address")+" ");
				System.out.println(rs.getString("dept_id")+" ");
			}
		}catch (ClassNotFoundException e) {
			System.out.println("jdbc driver loading fail.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("oracle connection fail.");
			e.printStackTrace();
		}

	}

}
