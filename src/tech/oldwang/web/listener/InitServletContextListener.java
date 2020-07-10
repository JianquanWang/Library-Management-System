package tech.oldwang.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tech.oldwang.domain.Book;
import tech.oldwang.domain.Category;
import tech.oldwang.domain.User;
import tech.oldwang.service.impl.BookServiceImpl;
import tech.oldwang.service.impl.CategoryServiceImpl;

/**
 * Application Lifecycle Listener implementation class InitServletContextListener
 *
 */
@WebListener
public class InitServletContextListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	List<User> userList = new ArrayList<User>();
    	User user1 = new User("Admin", "123456");
    	User user2 = new User("Admin2", "abcdef");
    	User user3 = new User("JianquanWang", "qwerty");
    	userList.add(user1);
    	userList.add(user2);
    	userList.add(user3);
    	sce.getServletContext().setAttribute("userList", userList);
    	sce.getServletContext().setAttribute("categoryDb", CategoryServiceImpl.categoryDb);
    	//sce.getServletContext().setAttribute("books", BookServiceImpl.books);
    }
	
}
