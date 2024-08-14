package exercise.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbcon.DBUtil;

public class BoardDBBean {

	private static BoardDBBean instance = new BoardDBBean();

	public static BoardDBBean getInstance() {
		return instance;
	}

	private BoardDBBean() {
	}

	public List<BoardDataBean> getArticles(int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDataBean> articleList = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from (select rownum rnum, no, writer, email, subject, pass,\r\n"
					+ "regdate, readcount, ref, step, depth, content, ip from (select * from tb_board \r\n"
					+ "order by ref desc, step asc)) where rnum>=? and rnum<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<BoardDataBean>();// 수정<4>
				do {
					BoardDataBean article = new BoardDataBean();
					article.setNo(rs.getInt("no"));
					article.setWriter(rs.getString("writer"));
					article.setEmail(rs.getString("email"));
					article.setSubject(rs.getString("subject"));
					article.setPass(rs.getString("pass"));
					article.setRegdate(rs.getTimestamp("regdate"));
					article.setReadcount(rs.getInt("readcount"));
					article.setRef(rs.getInt("ref"));
					article.setStep(rs.getInt("step"));
					article.setDepth(rs.getInt("depth"));
					article.setContent(rs.getString("content"));
					article.setIp(rs.getString("ip"));
					articleList.add(article);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return articleList;
	}

	public boolean insertArticle(BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no = article.getNo();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		int nober = 0;
		boolean flag = false;
		String sql = "";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select max(no) from tb_board");
			rs = pstmt.executeQuery();
			if (rs.next())
				nober = rs.getInt(1) + 1;
			else
				nober = 1;
			if (no != 0) {// 답변글일경우
				sql = "update tb_board set step=step+1 where ref= ? and step> ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				step = step + 1;
				depth = depth + 1;
			} else {// 새 글일 경우
				ref = nober;
				step = 0;
				depth = 0;
			} // 쿼리를 작성

			sql = "insert into tb_board(no, writer, email, subject, pass,regdate, ref, step, depth, content, ip)"
					+ "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPass());
			pstmt.setTimestamp(5, article.getRegdate());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, step);
			pstmt.setInt(8, depth);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				flag = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return flag;
	}

	// 글 내용가져오기
	public BoardDataBean getArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("update tb_board set readcount=readcount+1 where no = ?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("select * from tb_board where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new BoardDataBean();
				article.setNo(rs.getInt("no"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return article;
	}

	// 단순히 no에 해당하는 게시물만 가져오는 메소드
	public BoardDataBean updateGetArticle(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDataBean article = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select * from tb_board where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new BoardDataBean();
				article.setNo(rs.getInt("no"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return article;
	}

	// 전체글갯수
	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from tb_board");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return x;
	}

	//게시글 수정하는 메소드
	public int updateArticle(BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		String sql = "";
		int result = -1;// 결과값
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select pass from tb_board where no = ?");
			pstmt.setInt(1, article.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpasswd = rs.getString("pass");// 비밀번호 비교
				if (dbpasswd.equals(article.getPass())) {
					sql = "update tb_board set writer=?,email=?,subject=?,content=? where no=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNo());
					pstmt.executeUpdate();
					result = 1;// 수정성공
				} else {
					result = 0;// 수정실패
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return result;
	}
	
	//게시글 삭제하는 메소드
	public int deleteArticle(int no, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbPass = "";
		int result = -1;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("select pass from tb_board where no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPass = rs.getString("pass");
				if (dbPass.equals(pass)) {
					pstmt = conn.prepareStatement("delete from tb_board where no=?");
					pstmt.setInt(1, no);
					pstmt.executeUpdate();
					result = 1; // 글삭제 성공
				} else
					result = 0; // 비밀번호 틀림
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.dbReleaseClose(rs, pstmt, conn);
		}
		return result;
	}
}
