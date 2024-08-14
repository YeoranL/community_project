package exercise.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exercise.process.CommandAction;

@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "propertyConfig", value = "commandMapping.properties") })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	public Controller() {
		super();
	}

	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서
	// HashMap 객체인 commandMap 에 저장(서블릿이 만들어질 때 딱 한번만 실행하는 함수)

	// 서블릿 컨트롤러가 생성될 때 commandMapping.properties 정보를 가지고
	// 모든 ****Action 객체를 만들어서 Map<String, Object> commandMap에 저장한다,
	// 딱 한 번만 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		// initParams 에서 propertyConfig 의 값을 읽어옴 >> commandMapping.properties
		// props = "commandMapping.properties";
		String props = config.getInitParameter("propertyConfig");

		// properties 파일이 저장된 폴더
		String realFolder = "/property";

		// 웹어플리케이션 루트 경로
		ServletContext context = config.getServletContext();

		// realFolder 를 웹어플리케이션 시스템상의 절대경로로 변경
		// D:\myProject\myjsp\~~~\wtpwebapps\shoppingmall\property
		String realPath = context.getRealPath(realFolder) + "\\" + props;	// \\는 이스케이프

		// 명령어와 처리클래스의 매핑정보를 저장할 Properties 객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		try {
			// command.properties 파일의 내용을 읽어옴
			f = new FileInputStream(realPath);
			// command.properties 의 내용을 Properties 객체 pr 에 저장
			pr.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}

		// Set 객체의 iterator()메소드를 사용해 Iterator 객체를 얻어냄
		Iterator<?> keyIter = pr.keySet().iterator();
		// Iterator 객체에 저장된 명령어와 처리클래스를 commandMap 에 저장
		while (keyIter.hasNext()) {
			// command = /mg/managerMain.do
			// className = bookshop.command.ManagerMainAction
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);	//패키지 ~ 클래스이름까지
			try {
				// 이름으로 클래스 로드
				Class<?> commandClass = Class.forName(className);

				// Object commandInstance = commandClass.newInstance();
				// 객체 생성
				Object commandInstance = commandClass.getDeclaredConstructor().newInstance();
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		requestPro(request, response);
	}

	// 웹브라우저의 요청을 분석하고, 해당 로직의 처리를 할 모델 실행 및
	// 처리 결과를 뷰에 보냄
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		try {
			// http://localhost:9999/shoppingmall/XXX.do
			// request.getRequestURI() = /shoppingmall/XXX.do == command
			// request.getContextPath() = /shoppingmall
			String command = request.getRequestURI();
			// shoppingmall이 처음에 존재하는지 확인
			if (command.indexOf(request.getContextPath()) == 0)
				// shoppingmall 뒤 /mg/mamagerMain.do가 저장됨
				command = command.substring(request.getContextPath().length());
			com = (CommandAction) commandMap.get(command);
			view = com.requestPro(request, response);		//화면을 보여주는 return값
		} catch (Throwable e) {
			e.printStackTrace();
		}
		request.setAttribute("cont", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}