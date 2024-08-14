package dbcon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.err.println("Connection 생성실패");
		}
		System.out.println("Connection 생성성공");
		return conn;
	}
	
	public static void dbReleaseClose(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dbReleaseClose(Statement stmt, Connection con) {
		try {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dbReleaseClose(Connection con) {
		try {
			if(con != null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
