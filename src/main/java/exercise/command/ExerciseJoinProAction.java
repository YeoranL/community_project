package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.CartDBBean;
import exercise.bean.CartDataBean;
import exercise.process.CommandAction;

public class ExerciseJoinProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 회원가입 정보
		CartDataBean cart = new CartDataBean();		
		cart.setExCode(request.getParameter("exCode"));
		cart.setUserId(request.getParameter("loginID"));
		
		// 회원가입처리
		CartDBBean dbPro = CartDBBean.getInstance();
		dbPro.joinExercise(cart);
		
		return "/exercise/exerciseJoinPro.jsp";
	}
}
