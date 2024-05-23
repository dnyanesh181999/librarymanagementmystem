package com.starlink.librarymanagementmystem.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starlink.librarymanagementmystem.exceptions.AuthorNotFoundException;
import com.starlink.librarymanagementmystem.exceptions.BookDataNotSaved;
import com.starlink.librarymanagementmystem.exceptions.NoAnyBookAvailable;
import com.starlink.librarymanagementmystem.exceptions.BookIdNotFound;
import com.starlink.librarymanagementmystem.exceptions.BookNameNotFound;
import com.starlink.librarymanagementmystem.exceptions.BookNotFoundForUpdateException;
import com.starlink.librarymanagementmystem.exceptions.IdNotFoundForDeleteException;
import com.starlink.librarymanagementmystem.model.Book;
import com.starlink.librarymanagementmystem.repository.BookRepository;
import com.starlink.librarymanagementmystem.servicei.BookServicei;

@Service
public class BookServiceimpl implements BookServicei{
@Autowired
BookRepository br;

@Override
public Book saveBook(Book b) {
	Book book = br.save(b);
	if(book!=null) {
		return book;
	}
	else {
		throw new BookDataNotSaved("Internal Database problem");
	}
	
}

@Override
public List<Book> getAllBooks() {
	List<Book> bList = (List<Book>) br.findAll();
	if(bList.isEmpty()) {
		throw new NoAnyBookAvailable("Not currently Book persents");
	}
	else {
		return bList;
	}
	
}

@Override
public Book serachByName(String bookName) {
	
	
	Book book=br.findBybookName(bookName);
	if(book!=null)
	{
		return book;
	}
	else
	{
		throw new BookNameNotFound("Book Not Available");
	}
	
}

@Override
public Book searchById(Integer bookId) {
	Optional<Book> op=br.findById(bookId);
	
	if(op.isPresent())
	{
		Book book=op.get();
		return book;
	}
	else
	{
		throw new BookIdNotFound("Book Not Available");
	}
}

@Override
public Book searchByAuthor(String bookAuthorName) {
	
	Book book=br.findBybookAuthorName(bookAuthorName);
	if(book!=null)
	{
		return book;
	}
	else
	{
	
		throw new AuthorNotFoundException("Author Not available");
	}
}

@Override
public Book updateBook(Integer bookId, Book b) {
	Optional<Book> op=br.findById(bookId);
	if(op.isPresent())
	{
		Book book=op.get();
		if(b.getBookName()!=null)
		{
			book.setBookName(b.getBookName());
		}
		if(b.getBookAuthorName()!=null)
		{
			book.setBookAuthorName(b.getBookAuthorName());
		}
		if(b.getBookType()!=null)
		{
			book.setBookType(b.getBookType());
		}
		if(b.getBookDepartment()!=null)
		{
			book.setBookDepartment(b.getBookDepartment());
		}
		if(b.getBookAvalabilityNumber()!=null)
		{
			book.setBookAvalabilityNumber(b.getBookAvalabilityNumber());
		}
		return br.save(book);
	}
	else
	{
		throw new BookNotFoundForUpdateException("Book not available for Update");
	}
}

@Override
public Book deleteById(Integer bookId) {
	
	Optional<Book> op=br.findById(bookId);
	if(op.isPresent())
	{
		br.delete(op.get());
	}
	else
	{
		throw new IdNotFoundForDeleteException("Id not found...!");
	}
	
	return null;
}




}
