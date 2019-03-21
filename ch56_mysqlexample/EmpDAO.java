package ch56_mysqlexample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	public void insertEmp(EmpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DB.getConn();
			String sql = "insert into emp values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpno()); // 1번 물음표
			pstmt.setString(2, dto.getEname());
			pstmt.setDate(3, dto.getHiredate());
			pstmt.setInt(4, dto.getSal());
			pstmt.executeUpdate(); // 레코드가 추가됨
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

	// 사원 목록을 리스트에 저장하여 리턴하는 코드
	public List<EmpDTO> listEmp() {
		List<EmpDTO> items = new ArrayList<>(); // 리스트 선언
		Connection conn = null; // db 접속 객체
		PreparedStatement pstmt = null; // sql 실행 객체
		ResultSet rs = null; // 결과셋을 탐색하는 객체
		try {
			conn = DB.getConn(); // db접속 처리
			String sql = "select * from emp";
			pstmt = conn.prepareStatement(sql); // sql 실행 객체 생성
			rs = pstmt.executeQuery(); // 쿼리 실행 후 결과셋을 rs에 전달
			while (rs.next()) {// 다음 레코드가 있으면
				// 결과셋.get자료형("필드명")
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");

				EmpDTO dto = new EmpDTO(empno, ename, hiredate, sal);
				items.add(dto); // 리스트에 dto(레코드 1개)추가
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
		return items; // 리스트 리턴
	}
}
