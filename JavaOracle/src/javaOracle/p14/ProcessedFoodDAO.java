package javaOracle.p14;

//태화씨 코드

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProcessedFoodDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
	String user = "c##nanovia3";
	String password = "ehdrn1";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs1, rs2;
	
	public void list(){
		String big_ctg = "가공두부";
//		ArrayList<ProcessedFoodVo> list = new ArrayList<ProcessedFoodVo>();

		try {
			connDB();
			
//			String query = "SELECT * FROM processed_food ";
			String query2 = "SELECT FOOD_NAME, pf.DETAIL_CTG, pf.MANUFACTURER, n.\"Kcal\" \n"
					+ "FROM PROCESSED_FOOD pf, NUTRIENT n ";
			if(big_ctg != null) {
//				query += "where big_ctg = '" + big_ctg + "'";
				query2 += "WHERE pf.food_code = n.FOOD_CODE and pf.BIG_CTG = '" + big_ctg + "'\n"
						+ "ORDER BY FOOD_NAME";
			}
			System.out.println("SQL2 : " + query2);
			
			rs1 = stmt.executeQuery(query2);
			rs1.getRow();
			rs1.last();
			System.out.println("rs1.getRow() : " + rs1.getRow());
			// big_ctg 항목이 몇개인지 rs.getRow() 를 통해 알 수 있음.
			if(rs1.getRow() == 0) {
				
			} else {
				rs1.previous(); // 커서를 이전 위치로 되돌리기
				
				while(rs1.next()) { // 해당 결과가 있으면 조회해오는 것 
//					String foodName = rs1.getString("FOOD_NAME");
//					String detailCtg = rs1.getString("pf.DETAIL_ctg");
//					String manufacturer = rs1.getString("pf.MANUFACTURER");
//					int kcal = rs1.getInt("n.Kcal");
					
					System.out.print(rs1.getString("FOOD_NAME") + "\t");
					System.out.print(rs1.getString("pf.detail_ctg") + "\t");
					System.out.print(rs1.getString("pf.manufacturer") + "\t");
					System.out.print(rs1.getInt("n.kcal") + " ");
					
//					System.out.println("[food_name = " + foodName + "][detail_Ctg = " + detailCtg +
//							"][manufacturer = " + manufacturer + "][kcal = " + kcal + "]");
//					
//					
//					ProcessedFoodVo data = new ProcessedFoodVo(foodName, detailCtg, manufacturer, kcal);
//					list.add(data);
				}
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
//		return list;
	}
	
	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("statement create success.");
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void main(String[] args) {
	ProcessedFoodDAO dao = new ProcessedFoodDAO();
	dao.list();
	}
}
