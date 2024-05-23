package com.starlink.librarymanagementmystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.model.Book;
import com.starlink.librarymanagementmystem.servicei.BookServicei;

import jakarta.validation.Valid;
@RestController
//@RequestMapping(value = "/book",consumes = {"application/xml","application/json"},produces = {"application/xml","application/json"})
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
	
	
	@GetMapping("/searchByName/{bookName}")
	public ResponseEntity<Book> searchByName(@PathVariable String bookName)
	{
		 Book book=bs.serachByName(bookName);
		 
		 return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@GetMapping("/serchById/{bookId}")
	public ResponseEntity<Book> serchById(@PathVariable Integer bookId)
	{
		Book booki=bs.searchById(bookId);
		return new ResponseEntity<Book>(booki,HttpStatus.OK);
	}
	
	@GetMapping("/searchByAuthor/{bookAuthorName}")
	public ResponseEntity<Book> searchByAuthor(@PathVariable String bookAuthorName)
	{
		Book book=bs.searchByAuthor(bookAuthorName);
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@PutMapping("/upadteBook/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @RequestBody Book b)
	{
		Book book=bs.updateBook(bookId,b);
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{bookId}")
	public ResponseEntity<Book> deleteById(@PathVariable Integer bookId)
	{
		Book book=bs.deleteById(bookId);
		
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}

}
