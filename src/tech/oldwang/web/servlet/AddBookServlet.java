package tech.oldwang.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tech.oldwang.domain.Book;
import tech.oldwang.domain.Category;
import tech.oldwang.service.BookService;
import tech.oldwang.service.impl.BookServiceImpl;
import tech.oldwang.service.impl.CategoryServiceImpl;
import tech.oldwang.utils.UploadUtils;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
@MultipartConfig
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> map = new HashMap<String, String>();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		String url = null;
		try {
			List<FileItem> list = fileUpload.parseRequest(request);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					map.put(name, value);
				} else {
					String fileName = fileItem.getName();
					String uuidFileName = UploadUtils.getUuidFileName(fileName);
					InputStream is = fileItem.getInputStream();
					String path = getServletContext().getRealPath("/upload");
					// System.out.println("Upload Path:" + path);
					url = path + "\\" + uuidFileName;
					map.put("path", request.getContextPath() + "/upload/" + uuidFileName);
					OutputStream os = new FileOutputStream(url);
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = is.read(b)) != -1) {
						os.write(b, 0, len);
					}
					is.close();
					os.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bookId = map.get("bookId");
		String bookName = map.get("bookName");
		String bookPrice = map.get("bookPrice");
		String categoryId = map.get("categoryId");
		String remarks = map.get("remarks");
		// 校验价格
		String pattern = "([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(bookPrice);
		if(!m.find()) {
			request.getRequestDispatcher("/addBook.jsp").forward(request, response);
			return;
		}else {
			bookPrice = m.group(0);		
		}
		Category category = null;
		for (Category c : CategoryServiceImpl.categoryDb) {
			if (c.getId().equals(categoryId)) {
				category = c;
				break;
			}
		}
		if (category == null) {
			// request.getRequestDispatcher("/addCategory.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/addCategory.jsp");
			return;
		}
		for (Book b : BookServiceImpl.books) {
			if (b.getId().equals(bookId)) {
				request.getRequestDispatcher("/addBook.jsp").forward(request, response);
				return;
			}
		}
		Book book = new Book(bookId, bookName, category, Float.parseFloat(bookPrice), map.get("path"), remarks);
		BookService bookServlet = new BookServiceImpl();
		bookServlet.addBook(book);

		request.getServletContext().setAttribute("books", BookServiceImpl.books);
		request.getRequestDispatcher("/bookList.jsp").forward(request, response);
	}

}
