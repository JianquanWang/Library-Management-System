package tech.oldwang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import tech.oldwang.domain.Book;
import tech.oldwang.service.BookService;
import tech.oldwang.service.impl.BookServiceImpl;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Search Book");
		BookService bookService = new BookServiceImpl();
		String catgoryName = request.getParameter("searchContent");
		List<Book> list = bookService.getBooksByCatoryName(catgoryName);
//		
//		request.getServletContext().setAttribute("books", list);
//		request.getRequestDispatcher("/bookList.jsp").forward(request, response);
		
		String json = JSON.toJSONString(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(json);
		System.out.println(json);
	}

}
