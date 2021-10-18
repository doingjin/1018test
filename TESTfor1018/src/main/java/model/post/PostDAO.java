package model.post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class PostDAO {
	/*
	 PNUM INT PRIMARY KEY,			
	TITLE VARCHAR(30),
	MID VARCHAR(10),
	CONTENT VARCHAR(1000),
	PDATE DATE DEFAULT SYSDATE 
	 */

	private String INSERTP="INSERT INTO POST VALUES ((SELECT (NVL(MAX(PNUM),0)+1) FROM POST),?,?,?,SYSDATE)";
	private String UPDATEP="UPDATE POST SET TITLE=?,CONTENT=? WHERE PNUM=?";
	private String DELETEP="DELETE FROM POST WHERE PNUM=?";
	private String GETP="SELECT * FROM POST WHERE PNUM=?";
	private String GETPLIST="SELECT * FROM POST ORDER BY PNUM DESC";


	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// C
	public void insertP(PostVO pvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(INSERTP);
			pstmt.setString(1,  pvo.getTitle());
			pstmt.setString(2,  pvo.getMid());
			pstmt.setString(3,  pvo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}

	// U
	public void updateP(PostVO pvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(UPDATEP);
			pstmt.setString(1,  pvo.getTitle());
			pstmt.setString(2,  pvo.getContent());
			pstmt.setInt(3,  pvo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}

	// D
	public void deleteP(PostVO pvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(DELETEP);
			pstmt.setInt(1,  pvo.getPnum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}

	// R - selectONE
	public PostVO getP(PostVO pvo) {
		PostVO data=null;
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(GETP);
			pstmt.setInt(1,  pvo.getPnum());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setMid(rs.getString("mid"));
				data.setContent(rs.getString("content"));
				data.setPdate(rs.getDate("pdate"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
		return data;
	}
	// R - selectALL
	public ArrayList<PostVO> getPList() {
		ArrayList<PostVO> datas=new ArrayList<PostVO>();
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(GETPLIST);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PostVO data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setTitle(rs.getString("title"));
				data.setMid(rs.getString("mid"));
				data.setContent(rs.getString("content"));
				data.setPdate(rs.getDate("pdate"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
		return datas;
	}

}
