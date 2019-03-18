package ch54_properties;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class SqlInsertTest {
	public static void main(String[] args) {
		Connection conn = null; // DB접속을 위한 객체
		Statement stmt = null; // sql 문장을 실행시키는 객체
		try {
			// db 접속에 필요한 정보들을 properties 파일에 저장한 후 불러오는 방식
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\sjy04\\eclipse-workspace\\LifeSoft\\src\\ch54_properties\\db.prop");
			Properties prop = new Properties();
			// Properties 파일에 저장된 내용들을 불러옴
			prop.load(fis);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			System.out.println("driver:" + driver);
			System.out.println("url:" + url);
			System.out.println("id:" + id);
			System.out.println("password:" + password);

			Class.forName(driver); // dirver클래스 로딩
			conn = DriverManager.getConnection(url, id, password); // db접속
			String title = "C언어";
			String publisher = "금성출판사";
			int year = 2017;
			int price = 45000;
			String sql = "insert into books (title, publisher, year, price)" + "values('" + title + "','" + publisher
					+ "','" + year + "," + price + ")";
			stmt = conn.createStatement(); // Statement 객체 생성
			stmt.executeQuery(sql); // sql이 실행됨(레코드가 추가됨)
			System.out.println("추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
