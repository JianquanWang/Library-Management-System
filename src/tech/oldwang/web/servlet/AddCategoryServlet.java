package tech.oldwang.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.oldwang.domain.Category;
import tech.oldwang.service.CategoryService;
import tech.oldwang.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryId = (String) request.getParameter("categoryId");
		String categoryName = (String) request.getParameter("categoryName");
		// 正则判断
		String pattern = "^ca\\d{4}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(categoryId);

		CategoryService categoryService = new CategoryServiceImpl();
		if (m.find()) {
			int success = categoryService.addCategory(categoryId, categoryName);
			if (success == 0) {
				request.getSession().setAttribute("msg", "");
				response.sendRedirect(request.getContextPath() + "/categoryList.jsp?time=" + new Date().getTime());
			} else {
				// id 或 name 已存在
				request.getSession().setAttribute("msg", "NO. or Name exsited, please try again.");
				request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
			}
		} else {
			request.getSession().setAttribute("msg", "IDshould be format ca0000, please try again.");
			request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
		}

	}

}
