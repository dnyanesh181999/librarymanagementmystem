package com.starlink.librarymanagementmystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starlink.librarymanagementmystem.exceptions.BookDataNotSaved;
import com.starlink.librarymanagementmystem.exceptions.NoAnyBookAvailable;
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
}
