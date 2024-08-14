package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.process.CommandAction;

public class WriteFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 제목글과 답변글의 구분
		int no = 0, ref = 1, step = 0, depth = 0;
		try {
			if (request.getParameter("no") != null) {
				no = Integer.parseInt(request.getParameter("no"));
				ref = Integer.parseInt(request.getParameter("ref"));
				step = Integer.parseInt(request.getParameter("step"));
				depth = Integer.parseInt(request.getParameter("depth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 해당 뷰에서 사용할 속성
		request.setAttribute("no", no);
		request.setAttribute("ref", ref);
		request.setAttribute("step", step);
		request.setAttribute("depth", depth);
		request.setAttribute("type", Integer.valueOf(1));
		
		return "/board/writeForm.jsp";
	}
}