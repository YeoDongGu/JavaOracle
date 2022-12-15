package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<LoginVo> list(String id, String pwd) {
		ArrayList<LoginVo> list = new ArrayList<LoginVo>();
		try {
			connDB();
			String query = "select *from quiz ";
			if (id != null && pwd != null) {
				query += "where quiz_id = '" + id.toLowerCase() + "'";
				query += "and quiz_pwd = '" + pwd.toLowerCase() + "'";

			}
			System.out.println("SQL : " + query);

			rs = stmt.executeQuery(query);
			rs.last();

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + "rows selected.....");
				rs.previous();
				while (rs.next()) {
					String qid = rs.getString("QUIZ_ID");
					String qpwd = rs.getString("QUIZ_PWD");
					System.out.println(qid);
					System.out.println(qpwd);

					LoginVo data = new LoginVo(qid, qpwd);
					list.add(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	
	public ArrayList<SignupVo> list(String id, String pwd,String name,String resi){
		ArrayList<SignupVo> list = new ArrayList<SignupVo>();
		
		try {
			connDB();
			
			String query = "SELECT * FROM quiz ";
			if(id != null && pwd != null && name != null && resi != null) {
				query += "where quiz_id = '" + id.toLowerCase() + "'";
				query += "and quiz_resident_id = '" + resi.toLowerCase() + "'";
			}
			System.out.println("SQL : " +query);
			rs = stmt.executeQuery(query);
			rs.last();
			
			if(rs.getRow() == 0) {
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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
