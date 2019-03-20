package ch55_mysqldaodto;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarDAO {
	public Connection dbConn() {// db접속을 위한 커넥션을 리턴하는 코드
		Connection conn = null;
		try {
			FileInputStream fis = new FileInputStream("c:\\db.prop");
			Properties prop = new Properties();
			prop.load(fis); // 파일 내용을 읽어서 Properties 객체로 저장
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String password = prop.getProperty("password");
			conn = DriverManager.getConnection(url, id, password); // db접속

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; // db 커넥션 리턴
	}

	// car 테이블의 레코드 목록을 리턴하는 코드
	public List<CarDTO> listCar() {
		List<CarDTO> items = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConn(); // db접속을 위한 커넥션이 연결됨
			String sql = "select * from car"; // 실행할 sql 명령어
			pstmt = conn.prepareStatement(sql); // sql 실행을 위한 객체 생성
			rs = pstmt.executeQuery(); // sql 실행 결과셋이 rs에 전달됨
			while (rs.next()) { // 다음 레코드가 있으면 true
				// 레코드 1개를 dto에 저장
				String license_number = rs.getString("license_number");
				String company = rs.getString("company");
				String type = rs.getString("type");
				int year = rs.getInt("year");
				int efficiency = rs.getInt("efficiency");
				CarDTO dto = new CarDTO(license_number, company, type, year, efficiency);

				// dto를 ArrayList에 추가
				items.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items; // ArrayList를 리턴
	}

	public void insertCar(CarDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn();
			String sql = "insert into car(license_number, company, type, year, efficiency) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLicense_number());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getType());
			pstmt.setInt(4, dto.getYear());
			pstmt.setInt(5, dto.getEfficiency());
			pstmt.executeUpdate(); // insert query 실행(레코드가 추가됨)
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int deleteCar(String license_number) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConn(); // db 접속
			// 실행할 sql 명령어
			String sql = "delete from car where license_number = ?";
			pstmt = conn.prepareStatement(sql); // sql실행을 위한 객체 생성
			pstmt.setString(1, license_number); // 1번 물음표에 들어갈 값
			// 레코드 삭제 처리(삭제된 레코드 갯수가 result 변수에 저장됨)
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
