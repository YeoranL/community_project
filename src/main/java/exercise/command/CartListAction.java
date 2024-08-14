package exercise.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.CartDBBean;
import exercise.bean.CartDataBean;
import exercise.process.CommandAction;

public class CartListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<CartDataBean> cartList = null;
		int count = 0;

		CartDBBean cartProcess = CartDBBean.getInstance();
		//count = exerciseProcess.getExerciseCount();

		String userId = request.getParameter("loginID");

		//if (count > 0) {
		cartList = cartProcess.selectCartList(userId);
			request.setAttribute("cartList", cartList);
		//}

		// 뷰에서 사용할 속성
		//request.setAttribute("count", count);
		request.setAttribute("type", 0);
		return "/cart/cartList.jsp";
	}

}
