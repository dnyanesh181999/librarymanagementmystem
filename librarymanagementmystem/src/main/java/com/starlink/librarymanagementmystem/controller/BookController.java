package com.starlink.librarymanagementmystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.model.Book;
import com.starlink.librarymanagementmystem.servicei.BookServicei;

import jakarta.validation.Valid;
@RestController
@RequestMapping(value = "/book",consumes = {"application/xml","application/json"},produces = {"application/xml","application/json"})
public class BookController {
	@Autowired
	BookServicei bs;
	@PostMapping("/book")
	public ResponseEntity<Book>saveBook(@Valid @RequestBody Book b){
		Book book = bs.saveBook(b);
		if(book!=null) {
			return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/books")
	public ResponseEntity<List<Book>>getAllBooks(){
		List<Book> bList = bs.getAllBooks();
		return new ResponseEntity<List<Book>>(bList,HttpStatus.OK);
	}

}
