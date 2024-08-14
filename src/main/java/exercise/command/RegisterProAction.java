package exercise.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.bean.UserDBBean;
import exercise.bean.UserDataBean;
import exercise.process.CommandAction;

public class RegisterProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");

		// 회원가입 정보
		UserDataBean user = new UserDataBean();		
		user.setUserId(request.getParameter("user_id"));
		user.setUserPassword(request.getParameter("user_password"));
		user.setUserName(request.getParameter("user_name"));
		user.setUserEmail(request.getParameter("user_email"));
		user.setUserPhone(request.getParameter("user_phone"));
		user.setBirthday(request.getParameter("birthday"));
		user.setPostcode(request.getParameter("postcode"));
		user.setAddr(request.getParameter("addr"));
		user.setAddr1(request.getParameter("addr1"));
		user.setAddr2(request.getParameter("addr2"));
		user.setKakao(request.getParameter("kakao"));
		user.setMailing(request.getParameter("mailing"));
		user.setSns(request.getParameter("sns"));
		user.setSecurity(request.getParameter("security"));
		user.setIsInstructor(Integer.parseInt(request.getParameter("is_instructor")));
		user.setInsExercise(request.getParameter("ins_exercise"));
		
		// 회원가입처리
		UserDBBean dbPro = UserDBBean.getInstance();
		dbPro.insertMember(user);
		return "/member/registerPro.jsp";
	}
}