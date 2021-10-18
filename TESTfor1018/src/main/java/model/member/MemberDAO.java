package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.DBCP;

public class MemberDAO {
	/*MID VARCHAR(10) PRIMARY KEY,
	MPW VARCHAR(15)*/
	
	private String INSERTM="INSERT INTO MEMBER VALUES (?,?)";
	private String UPDATEM="UPDATE MEMBER SET MPW=? WHERE MID=?";
	private String DELETEM="DELETE FROM MEMBER WHERE MID=?";
	private String GETM="SELECT * FROM MEMBER WHERE MID=?";
	private String GETMLIST="SELECT * FROM MEMBER";


	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// C
	public void insertM(MemberVO mvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(INSERTM);
			pstmt.setString(1,  mvo.getMid());
			pstmt.setString(2,  mvo.getMpw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("🔥INSERTM🔥");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}
	
	// U
	public void updateM(MemberVO mvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(UPDATEM);
			pstmt.setString(1,  mvo.getMpw());
			pstmt.setString(2,  mvo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("🔥UPDATEM🔥");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}
	
	// D
	public void deleteM(MemberVO mvo) {
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(DELETEM);
			pstmt.setString(1,  mvo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("🔥DELETEM🔥");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
	}
	
	// R - selectONE / LogIn
	public MemberVO getM(MemberVO mvo) {
		MemberVO data=null;
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(GETM);
			pstmt.setString(1,  mvo.getMid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("🔥GETM🔥");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
		return data;
	}
	
	// R - selectALL
	public ArrayList<MemberVO> getMList() {
		ArrayList<MemberVO> datas=new ArrayList<MemberVO>();
		conn=DBCP.connect();
		try {
			pstmt=conn.prepareStatement(GETMLIST);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setMid(rs.getString("mid"));
				data.setMpw(rs.getString("mpw"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("🔥GETMLIST🔥");
			e.printStackTrace();
		} finally {
			DBCP.disconnect(conn, pstmt);
		}
		return datas;
	}
	
}
