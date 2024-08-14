package exercise.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.bean.BoardDataBean;
import exercise.process.CommandAction;

public class WriteProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 회원가입 정보
		BoardDataBean board = new BoardDataBean();		
		board.setNo(Integer.parseInt(request.getParameter("no")));
		board.setWriter(request.getParameter("writer"));
		board.setEmail(request.getParameter("email"));
		board.setSubject(request.getParameter("subject"));
		board.setPass(request.getParameter("pass"));
		//board.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		board.setRef(Integer.parseInt(request.getParameter("ref")));
		board.setStep(Integer.parseInt(request.getParameter("step")));
		board.setDepth(Integer.parseInt(request.getParameter("depth")));
		//board.setRegdate(request.getTimestamp("regdate"));
		board.setRegdate(new Timestamp(System.currentTimeMillis()));
		board.setContent(request.getParameter("content"));
		board.setIp(request.getRemoteAddr());
		
		// 회원가입처리
		BoardDBBean dbPro = BoardDBBean.getInstance();
		dbPro.insertArticle(board);
		
		return "/board/writePro.jsp";
	}
}
