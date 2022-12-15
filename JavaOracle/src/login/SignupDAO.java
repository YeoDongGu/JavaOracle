package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SignupDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<SignupVo> list(String id, String pwd, String resi, String name) {
		ArrayList<SignupVo> list = new ArrayList<SignupVo>();
		try {
			connDB();
			String query = "select * from quiz ";
			if (id != null && pwd != null && resi != null && name != null) {
				query += "where quiz_id = '" + id.toLowerCase() + "'";
				query += "and quiz_pwd = '" + pwd.toLowerCase() + "'";
				query += "and resident_id = '" + resi.toLowerCase() + "'";
				query += "and name = '" + name.toLowerCase() + "'";
			}

			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected....");
				rs.previous();
				query = "insert into quiz(quiz_id,QUIZ_PWD,resident_id,name) ";
				query += "VALUES('" + id + "', '" + pwd + "', '" + resi + "', '" + name + "')";
				stmt.executeUpdate(query);
				System.out.println("Join complete");

			} else {
				System.out.println(rs.getRow() + "rows selected...");
				System.out.println("can not join");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
