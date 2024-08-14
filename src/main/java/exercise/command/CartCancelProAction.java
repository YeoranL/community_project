package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.CartDBBean;
import exercise.bean.CartDataBean;
import exercise.process.CommandAction;

public class CartCancelProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		CartDataBean cart = new CartDataBean();		
		cart.setExCode(request.getParameter("exCode"));
		cart.setUserId(request.getParameter("loginID"));

		CartDBBean dbPro = CartDBBean.getInstance();
		dbPro.cancelCartItem(cart);
		
		return "/cart/cartCancelPro.jsp";
	}
}
