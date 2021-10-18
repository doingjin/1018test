package model.common;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBCP {
	public static Connection connect() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext(); 
			Context envContext = (Context) initContext.lookup("java:/comp/env");
																			
			DataSource ds = (DataSource) envContext.lookup("jdbc/orcl");
			conn = ds.getConnection();

		} catch (Exception e) {
			System.out.println("connect()에서 오류");
			e.printStackTrace();
		}
		return conn;
	}

	public static void disconnect(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("disconnect()에서 오류");
			e.printStackTrace();
		}
	}
}