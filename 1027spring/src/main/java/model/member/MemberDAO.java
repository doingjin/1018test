package model.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemberRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("mid"));
		data.setMpw(rs.getString("mpw"));
		return data;
	}
	
}

@Repository
public class MemberDAO {
	/*MID VARCHAR(10) PRIMARY KEY,
	MPW VARCHAR(15)*/
	
	private String INSERTM="INSERT INTO MEMBER VALUES (?,?)";
	private String UPDATEM="UPDATE MEMBER SET MPW=? WHERE MID=?";
	private String DELETEM="DELETE FROM MEMBER WHERE MID=?";
	private String GETM="SELECT * FROM MEMBER WHERE MID=?";
	private String GETMLIST="SELECT * FROM MEMBER";


	@Autowired
	private JdbcTemplate jdbctemplate;

	// C
	public void insertM(MemberVO mvo) {
		jdbctemplate.update(INSERTM,mvo.getMid(),mvo.getMpw());
	}
	
	// U
	public void updateM(MemberVO mvo) {
		jdbctemplate.update(UPDATEM,mvo.getMpw(),mvo.getMid());
	}
	
	// D
	public void deleteM(MemberVO mvo) {
		jdbctemplate.update(DELETEM,mvo.getMid());
	}
	
	// R - selectONE / LogIn
	public MemberVO getM(MemberVO mvo) {
		Object[] args= {mvo.getMid()};
		return jdbctemplate.queryForObject(GETM, args, new MemberRowMapper());
	}
	
	// R - selectALL
	public List<MemberVO> getMList() {
		return jdbctemplate.query(GETMLIST, new MemberRowMapper());
	}
	
}
