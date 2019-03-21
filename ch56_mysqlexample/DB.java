package ch56_mysqlexample;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public static Connection getConn() {
		Connection conn = null;
		try {
			// db접속정보가 저장되어 있는 Properties 파일의 내용을 불러옴
			FileInputStream fis = new FileInputStream("C:\\Users\\sjy04\\eclipse-workspace\\LifeSoft\\db.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			Class.forName(driver); // 생략가능
			// db접속
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
