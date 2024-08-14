package exercise.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcon.DBUtil;

public class ExerciseDBBean {
	private static ExerciseDBBean instance = new ExerciseDBBean();

	public static ExerciseDBBean getInstance() {
		return instance;
	}

	private ExerciseDBBean() {}
	
	public List<ExerciseDataBean> selectExercise() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ExerciseDataBean> exerciseList = null;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("select * from tb_exercise order by no");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				exerciseList = new ArrayList<ExerciseDataBean>();
				do { 
					ExerciseDataBean ex = new ExerciseDataBean();// 데이터저장빈 객체생성
					ex.setNo(rs.getInt("no"));
					ex.setExCode(rs.getString("ex_code"));
					ex.setExName(rs.getString("ex_name"));
					ex.setExLocation(rs.getString("ex_location"));
					ex.setExDate(rs.getString("ex_date"));
					ex.setExMembercount(rs.getInt("ex_membercount"));
					ex.setUserId(rs.getString("user_id"));
					ex.setExPrice(rs.getString("ex_price"));
					exerciseList.add(ex);
				}while(rs.next()); 
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return exerciseList;
	}
	
	public List<ExerciseDataBean> selectExercise2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ExerciseDataBean> exerciseList = null;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("SELECT * FROM tb_exercise WHERE ROWNUM BETWEEN 1 AND 5 order by no");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				exerciseList = new ArrayList<ExerciseDataBean>();
				do { 
					ExerciseDataBean ex = new ExerciseDataBean();// 데이터저장빈 객체생성
					ex.setNo(rs.getInt("no"));
					ex.setExCode(rs.getString("ex_code"));
					ex.setExName(rs.getString("ex_name"));
					ex.setExLocation(rs.getString("ex_location"));
					ex.setExDate(rs.getString("ex_date"));
					ex.setExMembercount(rs.getInt("ex_membercount"));
					ex.setUserId(rs.getString("user_id"));
					ex.setExPrice(rs.getString("ex_price"));
					exerciseList.add(ex);
				}while(rs.next()); 
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return exerciseList;
	}
	
	//운동신청
	public void joinExercise(ExerciseDataBean ex) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into tb_cart values (CART_SEQ.nextval,?,?)");
			pstmt.setString(1, ex.getExCode());
			pstmt.setString(2, ex.getUserId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(pstmt, conn);
		}
	}


	public void insertExercise(ExerciseDataBean ex) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into tb_exercise values (EXERCISE_SEQ.nextval,?,?,?,?,?,?,?)");
			pstmt.setString(1, ex.getExCode());
			pstmt.setString(2, ex.getExName());
			pstmt.setString(3, ex.getExLocation());
			pstmt.setString(4, ex.getExDate());
			pstmt.setInt(5, ex.getExMembercount());
			pstmt.setString(6, ex.getUserId());
			pstmt.setString(7, ex.getExPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(pstmt, conn);
		}
	}
	
	public int getExerciseCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int x = 0;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("select count(*) from tb_exercise");
			rs = pstmt.executeQuery();

			if (rs.next())
				x = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}

}
