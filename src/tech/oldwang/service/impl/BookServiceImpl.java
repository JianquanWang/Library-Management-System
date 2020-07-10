package tech.oldwang.service.impl;

import java.util.ArrayList;
import java.util.List;

import tech.oldwang.domain.Book;
import tech.oldwang.service.BookService;

public class BookServiceImpl implements BookService{
	public static final List<Book> books = new ArrayList<Book>();

	@Override
	public void addBook(Book book) {
		for(Book b : books) {
			if(b.getId().equals(book.getId())) {
				return;
			}
		}
		books.add(book);
		
	}

	@Override
	public void updateBook(Book book) {
		this.deleteBook(book.getId());
		books.add(book);	
	}

	@Override
	public void deleteBook(String bookId) {
		for(Book book : books) {
			if(book.getId().equals(bookId)){
				books.remove(book);
				return;
			}
		}
		
	}

	@Override
	public Book getBooksById(String bookID) {
		for(Book book : books) {
			if(book.getId().equals(bookID)) {
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> getBooksByCatoryName(String catgoryName) {
		List<Book> bookList = new ArrayList<Book>();
		for(Book book : books) {
			if(book.getCategory().getName().equals(catgoryName)) {
				bookList.add(book);
			}
		}
		return bookList;
	}
	
}
