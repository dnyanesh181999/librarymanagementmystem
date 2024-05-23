package com.starlink.librarymanagementmystem.servicei;

import java.util.List;

import com.starlink.librarymanagementmystem.model.Book;

public interface BookServicei {

	public Book saveBook(Book b);

	public List<Book> getAllBooks();

	public Book serachByName(String bookName);

	public Book searchById(Integer bookId);

	public Book searchByAuthor(String bookAuthorName);

	public Book updateBook(Integer bookId, Book b);

	public Book deleteById(Integer bookId);

}
