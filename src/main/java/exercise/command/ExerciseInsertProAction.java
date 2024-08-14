package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.ExerciseDBBean;
import exercise.bean.ExerciseDataBean;
import exercise.process.CommandAction;

public class ExerciseInsertProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 회원가입 정보
		ExerciseDataBean ex = new ExerciseDataBean();
		ex.setExCode(request.getParameter("exCode"));
		ex.setExName(request.getParameter("exName"));
		ex.setExLocation(request.getParameter("exLocation"));
		ex.setExDate(request.getParameter("exDate"));
		ex.setExMembercount(Integer.parseInt(request.getParameter("exMembercount")));
		ex.setUserId(request.getParameter("userId"));
		ex.setExPrice(request.getParameter("exPrice"));

		// 회원가입처리
		ExerciseDBBean dbPro = ExerciseDBBean.getInstance();
		dbPro.insertExercise(ex);

		return "/exercise/exerciseInsertPro.jsp";
	}

}
