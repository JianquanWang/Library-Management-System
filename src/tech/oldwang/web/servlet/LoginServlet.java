package tech.oldwang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.oldwang.domain.User;
import tech.oldwang.service.UserService;
import tech.oldwang.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code1 = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String code2 = request.getParameter("verifyCode");
		if(code2 == null || !code2.equalsIgnoreCase(code1)) {
			request.setAttribute("msg", "captcha wrong, please try again!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		// 接收数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 封装数据
		User user = new User(username, password);
		
		// 接收user list
		List<User> userList = (List<User>) getServletContext().getAttribute("userList");
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(userList, user);
		
		// 判断是否登录
		if(existUser == null) {
			request.setAttribute("msg", "Username or password incorrect, please try again!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath() + "/categoryList.jsp");
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
