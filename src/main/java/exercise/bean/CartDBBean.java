package exercise.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcon.DBUtil;

public class CartDBBean {
	private static CartDBBean instance = new CartDBBean();

	public static CartDBBean getInstance() {
		return instance;
	}

	private CartDBBean() {}
	
	//운동신청
	public void joinExercise(CartDataBean cart) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into tb_cart values (CART_SEQ.nextval,?,?)");
			pstmt.setString(1, cart.getUserId());
			pstmt.setString(2, cart.getExCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(pstmt, conn);
		}
	}
	
	//운동신청목록 조회
	public List<CartDataBean> selectCartList(String userId) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<CartDataBean> cartList = null;

		try {
			conn = DBUtil.getConnection();
			
			String sql = "select c.no as no, c.ex_code as ex_code, e.ex_name as ex_name, e.ex_location as ex_location, e.ex_date as ex_date, e.ex_price as ex_price, "
					+ "(select user_name from tb_user where user_id = e.user_id) as ins_name "
					+ "from tb_cart c inner join tb_exercise e on c.ex_code = e.ex_code "
					+ "where c.user_id = ? order by c.no";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			cartList = new ArrayList<>();
			while (rs != null && rs.next()) {
	            CartDataBean cart = new CartDataBean();
	            ExerciseDataBean ex = new ExerciseDataBean();
	            cart.setNo(rs.getInt("no"));
	            cart.setExCode(rs.getString("ex_code"));
	            ex.setExName(rs.getString("ex_name"));
	            ex.setExLocation(rs.getString("ex_location"));
	            ex.setExDate(rs.getString("ex_date"));
	            ex.setExPrice(rs.getString("ex_price"));
	            ex.setInsName(rs.getString("ins_name"));
	            cart.setExercise(ex);                    
	            cartList.add(cart);
	        }
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return cartList;
	}
	
	//신청운동삭제
	public void cancelCartItem(CartDataBean cart) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("delete from tb_cart where user_id = ? and ex_code = ?");
			pstmt.setString(1, cart.getUserId());
			pstmt.setString(2, cart.getExCode());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(pstmt, conn);
		}
	}


}
