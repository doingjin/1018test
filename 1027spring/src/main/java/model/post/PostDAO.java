package model.post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class PostRowMapper implements RowMapper<PostVO> {

	@Override
	public PostVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostVO data=new PostVO();
		data.setPnum(rs.getInt("pnum"));
		data.setTitle(rs.getString("title"));
		data.setMid(rs.getString("mid"));
		data.setContent(rs.getString("content"));
		data.setPdate(rs.getDate("pdate"));
		data.setImgname(rs.getString("imgname"));
		return data;
	}
	
}

@Repository
public class PostDAO {
	/*
	 PNUM INT PRIMARY KEY,			
	TITLE VARCHAR(30),
	MID VARCHAR(10),
	CONTENT VARCHAR(1000),
	PDATE DATE DEFAULT SYSDATE 
	 */

	private String INSERTP="INSERT INTO POST VALUES ((SELECT (NVL(MAX(PNUM),0)+1) FROM POST),?,?,?,SYSDATE,?)";
	private String UPDATEP="UPDATE POST SET TITLE=?,CONTENT=? WHERE PNUM=?";
	private String DELETEP="DELETE FROM POST WHERE PNUM=?";
	private String GETP="SELECT * FROM POST WHERE PNUM=?";
	private String GETPLIST="SELECT * FROM POST ORDER BY PNUM DESC";

	@Autowired
	private JdbcTemplate jdbctemplate;

	// C
	public void insertP(PostVO pvo) {
		jdbctemplate.update(INSERTP,pvo.getTitle(),pvo.getMid(),pvo.getContent(),pvo.getImgname());
	}

	// U
	public void updateP(PostVO pvo) {
		jdbctemplate.update(UPDATEP,pvo.getTitle(),pvo.getContent(),pvo.getPnum());
	}

	// D
	public void deleteP(PostVO pvo) {
		jdbctemplate.update(DELETEP,pvo.getPnum());
	}

	// R - selectONE
	public PostVO getP(PostVO pvo) {
		Object[] args= { pvo.getPnum() };
		return jdbctemplate.queryForObject(GETP, args, new PostRowMapper());
	}
	
	// R - selectALL
	public List<PostVO> getPList() {
		return jdbctemplate.query(GETPLIST, new PostRowMapper());
	}
	
	public int getTotalCount() {
		String sql="SELECT COUNT(*) FROM POST";
		return jdbctemplate.queryForObject(sql, Integer.class);
	}
	
	public List<PostVO> getPList(int startRow, int endRow){
		String SQL ="SELECT * FROM (SELECT ROWNUM AS RNUM, A.PNUM,A.TITLE,A.MID,A.CONTENT,A.PDATE,A.IMGNAME FROM (SELECT * FROM POST ORDER BY PNUM DESC ) A) WHERE RNUM BETWEEN "+startRow+" AND "+endRow;
		//Object[] args= {startRow,endRow};
		return jdbctemplate.query(SQL, new PostRowMapper());
	}
}
