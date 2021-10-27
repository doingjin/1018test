package model.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Pagination {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	// TOTAL Page Count
	public int getTotalCount() {
		String sql="SELECT COUNT(*) FROM POST";
		return jdbc.queryForObject(sql, Integer.class);
		/*Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		int total = 0;
		try {
			String SQL = "SELECT COUNT(*) FROM POST";
			pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println("getTotalCount()");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
		return total;*/
	}
	
	// getPList with PAGENATION
	public List<PostVO> getPList(int startRow, int endRow){
		String SQL ="SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.TITLE,A.MID,A.CONTENT,A.PDATE FROM (SELECT * FROM POST ORDER BY PNUM DESC ) A) WHERE RNUM BETWEEN "+startRow+" AND "+endRow;
		Object[] args= {startRow,endRow};
		return jdbc.query(SQL, args, new PostRowMapper());
		
		/*Connection conn = DBCP.connect();
		PreparedStatement pstmt = null;
		ArrayList<PostVO> datas = new ArrayList<PostVO>();
		System.out.println("start:"+startRow +" end:"+endRow);
		try {
			String SQL ="SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.TITLE,A.MID,A.CONTENT,A.PDATE FROM (SELECT * FROM POST ORDER BY PNUM DESC ) A) WHERE RNUM BETWEEN "+startRow+" AND "+endRow;
			pstmt = conn.prepareStatement(SQL);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO pvo = new PostVO();
				pvo.setPnum(rs.getInt("pnum"));
				pvo.setTitle(rs.getString("title"));
				pvo.setMid(rs.getString("mid"));
				pvo.setContent(rs.getString("content"));
				pvo.setPdate(rs.getDate("pdate"));
				datas.add(pvo);
			}
			System.out.println("Post의 datas: "+datas);
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCP.disconnect(conn, pstmt);
		}
		return datas;*/
	}
}
