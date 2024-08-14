package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.bean.BoardDataBean;
import exercise.process.CommandAction;

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		int no = Integer.parseInt(request.getParameter("no"));
		String pageNum = request.getParameter("pageNum");
		
		//DB연동 book_id에 해당하는 상품을 얻내서 book에 저장
		BoardDBBean bookProcess = BoardDBBean.getInstance();
		BoardDataBean article =  bookProcess.updateGetArticle(no);
		
		request.setAttribute("pageNum", pageNum);
        request.setAttribute("article", article);
		request.setAttribute("type", 0);
		return "/board/updateForm.jsp";
	}
}
