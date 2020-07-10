package tech.oldwang.service;

import java.util.List;

import tech.oldwang.domain.Book;

public interface BookService {
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(String bookId);
	public Book getBooksById(String bookID);
	public List<Book> getBooksByCatoryName(String catgoryName);
}
