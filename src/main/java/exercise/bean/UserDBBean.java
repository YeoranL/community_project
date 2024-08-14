package exercise.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcon.DBUtil;
import work.crypt.BCrypt;
import work.crypt.SHA256;

public class UserDBBean {
	// LogonDBBean 전역 객체 생성 <- 한개의 객제만 생성해서 공유
	private static UserDBBean instance = new UserDBBean();

	// LogonDBBean객체를 리턴하는 메소드
	public static UserDBBean getInstance() {
		return instance;
	}

	private UserDBBean() {}

	// 회원 가입 처리에서 사용하는 메소드
	public void insertMember(UserDataBean user) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("insert into TB_USER values (USER_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPassword()/*bcPass*/);
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserPhone());
			pstmt.setString(6, user.getBirthday());
			pstmt.setString(7, user.getPostcode());
			pstmt.setString(8, user.getAddr());
			pstmt.setString(9, user.getAddr1());
			pstmt.setString(10, user.getAddr2());
			pstmt.setString(11, user.getKakao().equals("on") ? "Y" : "N");
			pstmt.setString(12, user.getMailing().equals("on") ? "Y" : "N");
			pstmt.setString(13, user.getSns().equals("on") ? "Y" : "N");
			pstmt.setString(14, user.getSecurity().equals("on") ? "Y" : "N");
			pstmt.setInt(15, user.getIsInstructor());
			pstmt.setString(16, user.getInsExercise());
			pstmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(pstmt, conn);
		}
	}

	// 로그인 폼 처리의 사용자 인증 처리에서 사용하는 메소드
	public int userCheck(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from tb_user where user_id = ? and user_password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = 1; // 인증성공
			} else {
				x = -1;// 아이디 없음
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}

	// 아이디 중복 확인에서 아이디의 중복 여부를 확인하는 메소드
	public int confirmId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("select user_id from tb_user where user_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())// 아이디 존재
				x = 1; // 같은 아이디 있음
			else
				x = -1;// 같은 아이디 없음
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}

	// 주어진 id에 해당하는 회원정보를 얻어내는 메소드
	public UserDataBean getUser(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDataBean user = null;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("select * from tb_user where user_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디에 대한 레코드가 존재
				user = new UserDataBean();// 데이터저장빈 객체생성
				user.setUserId(rs.getString("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserEmail(rs.getString("user_email"));
				user.setUserPhone(rs.getString("user_phone"));
				user.setBirthday(rs.getString("birthday"));
				user.setPostcode(rs.getString("postcode"));
				user.setAddr(rs.getString("addr"));
				user.setAddr1(rs.getString("addr1"));
				user.setAddr2(rs.getString("addr2"));
				user.setKakao(rs.getString("kakao"));
				user.setMailing(rs.getString("mailing"));
				user.setSns(rs.getString("sns"));
				user.setSecurity(rs.getString("security"));
				user.setIsInstructor(rs.getInt("is_instructor"));
				user.setInsExercise(rs.getString("ins_exercise"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return user;// 데이터 저장빈 객체 member 리턴
	}

	// 주어진 id, passwd에 해당하는 회원정보를 얻어내는 메소드
	public UserDataBean getMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDataBean user = null;

		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = DBUtil.getConnection();

			String orgPass = passwd;
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement("select * from tb_user where user_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디에 대한 레코드가 존재
				String dbpasswd = rs.getString("passwd");
				// 사용자가 입력한 비밀번호와 테이블의 비밀번호가 같으면 수행
				if (BCrypt.checkpw(shaPass, dbpasswd)) {
					user = new UserDataBean();// 데이터저장빈 객체생성
					user.setUserId(rs.getString("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setUserEmail(rs.getString("user_email"));
					user.setUserPhone(rs.getString("user_phone"));
					user.setBirthday(rs.getString("birthday"));
					user.setPostcode(rs.getString("postcode"));
					user.setAddr(rs.getString("addr"));
					user.setAddr1(rs.getString("addr1"));
					user.setAddr2(rs.getString("addr2"));
					user.setKakao(rs.getString("kakao"));
					user.setMailing(rs.getString("mailing"));
					user.setSns(rs.getString("sns"));
					user.setSecurity(rs.getString("security"));
					user.setIsInstructor(rs.getInt("is_instructor"));
					user.setInsExercise(rs.getString("ins_exercise"));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return user;// 데이터 저장빈 객체 member 리턴
	}

	// 회원 정보 수정을 처리하는 메소드
	@SuppressWarnings("resource")
	public int updateMember(UserDataBean user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = DBUtil.getConnection();

			String orgPass = user.getUserPassword();
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement("select passwd from tb_user where user_id = ?");
			pstmt.setString(1, user.getUserId());
			rs = pstmt.executeQuery();

			if (rs.next()) {// 해당 아이디가 있으면 수행
				String dbpasswd = rs.getString("passwd");
				if (BCrypt.checkpw(shaPass, dbpasswd)) {
					pstmt = conn.prepareStatement("update tb_user set user_name=?,user_phone=? " + "where user_id=?");
					pstmt.setString(1, user.getUserName());
					pstmt.setString(2, user.getUserPhone());
					pstmt.setString(3, user.getUserId());
					pstmt.executeUpdate();
					x = 1;// 회원정보 수정 처리 성공
				} else
					x = 0;// 회원정보 수정 처리 실패
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}

	// 회원 정보를 삭제하는 메소드
	@SuppressWarnings("resource")

	public int deleteMember(String id, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = -1;

		SHA256 sha = SHA256.getInsatnce();
		try {
			conn = DBUtil.getConnection();

			String orgPass = passwd;
			String shaPass = sha.getSha256(orgPass.getBytes());

			pstmt = conn.prepareStatement("select user_password from tb_user where user_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if (BCrypt.checkpw(shaPass, dbpasswd)) {
					pstmt = conn.prepareStatement("delete from tb_user where user_id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					x = 1;// 회원탈퇴처리 성공
				} else
					x = 0;// 회원탈퇴 처리 실패
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}
	
	
	//관리자-회원정보보기
	public List<UserDataBean> selectUserList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserDataBean> userList = null;

		try {
			conn = DBUtil.getConnection();

			pstmt = conn.prepareStatement("select NO,USER_ID,USER_NAME,USER_EMAIL,USER_PHONE,BIRTHDAY, '(' || POSTCODE || ') ' || addr || ' ' || nvl(addr1,'') || nvl(addr2,'') as total_addr,\r\n"
					+ "decode(IS_INSTRUCTOR,1,'일반','강사') as is_InstructorNm, nvl(INS_EXERCISE,'해당사항없음') as INS_EXERCISE\r\n"
					+ "from tb_user \r\n"
					+ "where user_id != 'admin' order by no");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				userList = new ArrayList<UserDataBean>();
				do { 
					UserDataBean user = new UserDataBean();// 데이터저장빈 객체생성
					user.setNo(rs.getInt("no"));
					user.setUserId(rs.getString("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setUserEmail(rs.getString("user_email"));
					user.setUserPhone(rs.getString("user_phone"));
					user.setBirthday(rs.getString("birthday"));
					user.setTotalAddr(rs.getString("total_addr"));
					user.setIsInstructorNm(rs.getString("is_InstructorNm"));
					user.setInsExercise(rs.getString("ins_exercise"));
					userList.add(user);
				}while(rs.next()); 
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return userList;
	}
}
