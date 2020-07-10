package tech.oldwang.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.oldwang.service.CategoryService;
import tech.oldwang.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class DeleteCategoryServlet
 */
@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId = (String)request.getParameter("categoryId");
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.deleteCategory(categoryId);
		request.getServletContext().setAttribute("categoryDb", CategoryServiceImpl.categoryDb);
		response.sendRedirect(request.getContextPath() + "/categoryList.jsp?time=" + new Date().getTime());
		return;
	}

}
