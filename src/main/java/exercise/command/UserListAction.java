package exercise.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.UserDBBean;
import exercise.bean.UserDataBean;
import exercise.process.CommandAction;

public class UserListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<UserDataBean> userList = null;

		UserDBBean userProcess = UserDBBean.getInstance();

		userList = userProcess.selectUserList();
		request.setAttribute("userList", userList);


		// 뷰에서 사용할 속성
		request.setAttribute("type", 0);
		return "/mgmember/userList.jsp";
	}
}
