package ch53_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	public static void main(String[] args) throws SQLException {
		// mysql 연결 문자열 jdbc:mysql ://호스트/데이터베이스
		String url = "jdbc:mysql://localhost/java?serverTimezone=UTC";
		String id = "java"; // mysql 접속 아이디
		String password = "java1234"; // mysql 접속 비밀번호
		// DB접속
		Connection conn = null; // java.sql.Connection
		// SQL명령어 실행
		Statement stmt = null;
		// select 명령어의 결과셋을 조회
		ResultSet rs = null;

		try {// DB연동 작업은
				// mysql에 접속하기 위한 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			// db에 접속
			conn = DriverManager.getConnection(url, id, password);
			// SQL 명령어 작성
			String sql = "select * from books";
			// SQL 실행을 위한 객체 생성
			stmt = conn.createStatement();
			// SQL을 실행한 후 실행결과(결과셋)를 읽을 객체 생성
			rs = stmt.executeQuery(sql);
			System.out.println("도서코드\t도서이름");
			while (rs.next()) {// 다음 레코드가 있으면
				// 결과셋.get자료형("필드명")
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				System.out.println(book_id + "\t" + title);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// DB 연동 관련 리소스 정리
			// 오픈한 역순으로 닫음
			// ResultSet => Statement => Connection
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
