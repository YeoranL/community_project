package exercise.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.ExerciseDBBean;
import exercise.bean.ExerciseDataBean;
import exercise.process.CommandAction;

public class MainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<ExerciseDataBean> exerciseList = null;
		int count = 0;

		ExerciseDBBean exerciseProcess = ExerciseDBBean.getInstance();
		count = exerciseProcess.getExerciseCount();

		if (count > 0) {
			exerciseList = exerciseProcess.selectExercise2();
			request.setAttribute("exerciseList", exerciseList);
		}

		// 뷰에서 사용할 속성
		request.setAttribute("count", count);
		request.setAttribute("type", 1);
		return "/main.jsp";
	}
}