package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.DB;

public class BookDAO {
	public ArrayList<BookDTO> bookList() {
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		Connection conn = null; // DB접속 객체
		PreparedStatement pstmt = null; // SQL 실행객체
		ResultSet rs = null; // 결과셋 처리 객체
		try {

			conn = DB.dbConn();
			String sql = "select * from book";
			// SQL실행객체 생성
			pstmt = conn.prepareStatement(sql);
			// SQL 실행 후 결과셋이 rs에 리턴됨
			rs = pstmt.executeQuery();
			// 결과셋.next() 다음 레코드가 있으면 true
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				// 결과셋.get자료형("컬럼")
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
