package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.process.CommandAction;

public class LoginFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("type", Integer.valueOf(1));
		
		return "/member/loginForm.jsp";
	}
}