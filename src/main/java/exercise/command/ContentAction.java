package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.bean.BoardDataBean;
import exercise.process.CommandAction;

public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 해당글번호
		int no = Integer.parseInt(request.getParameter("no"));

		String pageNum = request.getParameter("pageNum");
		BoardDBBean dbPro = BoardDBBean.getInstance();

		BoardDataBean article = dbPro.getArticle(no);
		// 해당 뷰에서 사용할 속성
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		return "/board/content.jsp";// 해당
	}

}
