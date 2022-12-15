package javaOracle.p14;

import java.sql.*;

public class OracleInsert {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##green";
		String password = "green1234";
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection succexx.\n");
			Statement stmt = conn.createStatement();

			String sql3 = "SELECT max(deptno) from dept";
			ResultSet rs2 = stmt.executeQuery(sql3);

			rs2.next();
			int n = rs2.getInt("max(deptno)") + 10;
			String str = Integer.toString(n);
			String ideptno = str, sdname = "IT", sloc = "SEOUL";
			String sql = "INSERT INTO dept VALUES ('" + ideptno + "','" + sdname + "','" + sloc + "')";
			boolean b = stmt.execute(sql);

			if (!b) {
				System.out.println("Insert success. \n");
			} else {
				System.out.println("Insert fail.\n");
			}
			// String sql = "SELECT * FROM dept";

			String sql2 = "SELECT deptno, dname, loc FROM dept order by deptno";

			ResultSet rs = stmt.executeQuery(sql2);

			while (rs.next()) {
				System.out.print(rs.getString("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.println(rs.getString("loc") + " ");
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
