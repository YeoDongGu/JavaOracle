package javaOracle.p14;

import java.sql.*;

public class OracleInsert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##nanovia3";
		String password = "ehdrn1";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection succexx.\n");
			Statement stmt = conn.createStatement();

			String sql3 = "SELECT yadmnm from covid";
			ResultSet rs2 = stmt.executeQuery(sql3);

			String sql2 = "SELECT sidonm, sggunm, yadmnm , telno FROM covid";

			ResultSet rs = stmt.executeQuery(sql2);
			while (rs.next()) {
//				if (rs.getString("sidonm") == "경기") {
				System.out.print(rs.getString("sidonm") + "\t");
				System.out.print(rs.getString("sggunm") + "\t");
				System.out.print(rs.getString("telno") + "\t");
				System.out.println(rs.getString("yadmnm"));
//				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
