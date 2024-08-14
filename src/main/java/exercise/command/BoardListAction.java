package exercise.command;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.BoardDBBean;
import exercise.bean.BoardDataBean;
import exercise.process.CommandAction;

public class BoardListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 5;// 한 페이지의 글의 개수
		int currentPage = Integer.parseInt(pageNum);
		// 한 페이지의 시작글 번호
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;

		List<BoardDataBean> boardList = null;
		BoardDBBean boardProcess = BoardDBBean.getInstance();
		count = boardProcess.getArticleCount();

		if (count > 0) {
			boardList = boardProcess.getArticles(startRow, endRow);
			request.setAttribute("boardList", boardList);
		} else {
			boardList = Collections.emptyList();
		}

		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호

		// 뷰에서 사용할 속성
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("type", 0);
		return "/board/boardList.jsp";
	}
}