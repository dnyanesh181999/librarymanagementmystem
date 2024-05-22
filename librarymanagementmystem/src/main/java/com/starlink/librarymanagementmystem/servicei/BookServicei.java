package com.starlink.librarymanagementmystem.servicei;

import java.util.List;

import com.starlink.librarymanagementmystem.model.Book;

public interface BookServicei {

	public Book saveBook(Book b);

	public List<Book> getAllBooks();

}
