package mybi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mybi.header.MybiRecord;

public class DatabaseManager {
	/*
	 * 추후 Connection pool 
	 * id,password 부분 xml로 빼보기
	 * */
	public void RecordSQL(List<MybiRecord> mybList) {
//		String Jdbc_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String Jdbc_url = "jdbc:sqlserver://210.125.146.96:1433;DatabaseName=MybiCard";
		String Jdbc_driver = "com.mysql.jdbc.Driver";
		String Jdbc_url = "jdbc:mysql://210.115.182.218:3306/MybiCard?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			Class.forName(Jdbc_driver);
			conn = DriverManager.getConnection(Jdbc_url, "root", "Dbnis3258!@#$");

			String sql = "INSERT INTO mybi("
					+ "사업자번호,"
					+ "운수사, "
					+ "카드거래일자, "
					+ "카드번호, "
					+ "카드거래시간, "
					+ "카드사구분, "
					+ "카드사명, "
					+ "단말코드, "
					+ "버스구분, "
					+ "차량번호, "
					+ "노선코드, "
					+ "정류장코드, "
					+ "정류장명, "
					+ "일반건수, "
					+ "학생건수, "
					+ "소인건수, "
					+ "기타건수, "
					+ "거래금액, "
					+ "환승FLAG, "
					+ "이전노선코드, "
					+ "이전거래일자, "
					+ "이전거래시간, "
					+ "이전정류장코드, "
					+ "이전정류장명,"
					+ "DATA구분,"
					+ "FILENAME) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			String charsetName = "euc-kr";
			System.out.println("List size =>"+mybList.size());
			for(MybiRecord mybiRecord: mybList) {
				System.out.println("fileName " +mybiRecord.getFileName());
				pstmt.setString(1, new String(mybiRecord.get사업자번호(), charsetName));
				pstmt.setString(2, new String(mybiRecord.get운수사(), charsetName));
				pstmt.setString(3, new String(mybiRecord.get카드거래일자(), charsetName));
				pstmt.setString(4, new String(mybiRecord.get카드번호(), charsetName));
				pstmt.setString(5, new String(mybiRecord.get카드거래시간(), charsetName));
				pstmt.setString(6, new String(mybiRecord.get카드사구분(), charsetName));
				pstmt.setString(7, new String(mybiRecord.get카드사명(), charsetName));
				pstmt.setString(8, new String(mybiRecord.get단말코드(), charsetName));
				pstmt.setString(9, new String(mybiRecord.get버스구분(), charsetName));
				pstmt.setString(10, new String(mybiRecord.get차량번호(), charsetName));
				pstmt.setString(11, new String(mybiRecord.get노선코드(), charsetName));
				pstmt.setString(12, new String(mybiRecord.get정류장코드(), charsetName));
				pstmt.setString(13, new String(mybiRecord.get정류장명(), charsetName));
				
				pstmt.setInt(14, Integer.parseInt(new String(mybiRecord.get일반건수())));// 문제
				pstmt.setInt(15, Integer.parseInt(new String(mybiRecord.get학생건수())));// 문제
				pstmt.setInt(16, Integer.parseInt(new String(mybiRecord.get소인건수())));// 문제
				pstmt.setInt(17, Integer.parseInt(new String(mybiRecord.get기타건수())));// 문제
				pstmt.setInt(18, Integer.parseInt(new String(mybiRecord.get거래금액())));// 문제
				pstmt.setInt(19, Integer.parseInt(new String(mybiRecord.get환승FLAG())));// 문제
				pstmt.setInt(20, Integer.parseInt(new String(mybiRecord.get이전노선코드())));// 문제
				
				pstmt.setString(21, new String(mybiRecord.get이전거래일자(), charsetName));
				pstmt.setString(22, new String(mybiRecord.get이전거래시간(), charsetName));
				pstmt.setInt(23, Integer.parseInt(new String(mybiRecord.get이전정류장코드())));// 문제
				pstmt.setString(24, new String(mybiRecord.get이전정류장명(), charsetName));
				
				// new field
				pstmt.setString(25, new String(mybiRecord.getDATA구분(),charsetName));
				pstmt.setString(26, mybiRecord.getFileName());
				//pstmt.executeUpdate();
				pstmt.addBatch();
			
				
			}
			
			pstmt.executeBatch();
			//pstmt.executeLargeUpdate(); //쿼리 실행시 2배로 들어감 ?
			
			
		

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		System.out.println("Recoord 삽입 성공");
	}
	
	/*public void MataSQL(MybiMata mybiMata){
		String Jdbc_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String Jdbc_url = "jdbc:sqlserver://210.125.146.96:1433;DatabaseName=MybiCard";
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			Class.forName(Jdbc_driver);
			conn = DriverManager.getConnection(Jdbc_url, "test", "s21-4server");

			String sql = "INSERT INTO Meta_Mybi values(id.NEXTVAL,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			String charsetName = "euc-kr";

			pstmt.setString(1, mybiMata.getTitle());
			pstmt.setString(2, mybiMata.getSize());
			pstmt.setString(3, mybiMata.getPath());
			pstmt.setString(4, mybiMata.getUpdated());
			pstmt.setString(5, mybiMata.getTime());
			
			
			
			pstmt.executeUpdate();
			
			 * pstmt.addBatch();
			pstmt.executeBatch();
			pstmt.executeLargeUpdate(); //쿼리 실행시 2배로 들어감 ?
			
		

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
		System.out.println("Recoord 삽입 성공");
	}
	*/

}
