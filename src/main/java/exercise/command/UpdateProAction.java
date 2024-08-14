package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.bean.BoardDataBean;
import exercise.process.CommandAction;

public class UpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String pageNum = request.getParameter("pageNum");
		BoardDataBean article = new BoardDataBean();
		article.setNo(Integer.parseInt(request.getParameter("no")));
		article.setWriter(request.getParameter("writer"));
		article.setEmail(request.getParameter("email"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPass(request.getParameter("pass"));
		BoardDBBean dbPro = BoardDBBean.getInstance();
		int check = dbPro.updateArticle(article);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		return "/board/updatePro.jsp";
	}

}
