package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.process.CommandAction;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String pageNum = request.getParameter("pageNum");
		String pass = request.getParameter("pass");
		
		BoardDBBean dbPro = BoardDBBean.getInstance();
		int check = dbPro.deleteArticle(no, pass);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", check);
		
		return "/board/deletePro.jsp";
	}

}
