package com.starlink.librarymanagementmystem.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.exceptions.BookIdNotFound;
import com.starlink.librarymanagementmystem.model.Admin;
import com.starlink.librarymanagementmystem.model.Book;
import com.starlink.librarymanagementmystem.model.IssueBook;
import com.starlink.librarymanagementmystem.model.Student;
import com.starlink.librarymanagementmystem.servicei.AdminServicei;
import com.starlink.librarymanagementmystem.servicei.BookServicei;
import com.starlink.librarymanagementmystem.sevicei.studentservicei;
import com.starlink.librarymanagementmystem.utility.AddDaysInCurrentDays;

@RestController("/admin")
public class AdminController {
@Autowired
AdminServicei adminService;
@Autowired
BookServicei bookServicei;
@Autowired
studentservicei studentservcei;

@PostMapping(value = "/admin",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
public ResponseEntity<Admin> registerAdmin(@RequestBody Admin ad) {
	Admin adm = adminService.regiterAdmin(ad);
	
	return new ResponseEntity<Admin>(adm,HttpStatus.OK);
}

@GetMapping(value = "/admin/{username}/{password}",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
public ResponseEntity<Admin>loginAdmin(@PathVariable String username,@PathVariable String password){
	Admin ad = adminService.loginAdmin(username,password);
	return new ResponseEntity<Admin>(ad,HttpStatus.OK);
	
	
}
@GetMapping(value = "/adminBooks")
public ResponseEntity<List<Book>>getAllBooksByAdmin(){
	List<Book>bList=bookServicei.getAllBooks();
	return new ResponseEntity<List<Book>>(bList,HttpStatus.OK);
}
@PostMapping(value = "/adminBook")
public ResponseEntity<Book>saveBookByAdmin(@RequestBody Book b){
	 Book book=bookServicei.saveBook(b);
	 if(book!=null) {
		 
			return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
		}
}
@GetMapping(value = "/adminBook/{bookAuthorName}")
public ResponseEntity<Book>searchByNameByAdmin(@PathVariable String bookAuthorName){
	Book b=bookServicei.searchByAuthor(bookAuthorName);
	return new ResponseEntity<Book>(b,HttpStatus.OK);	
	
}

@DeleteMapping(value = "/adminBook/{bookId}")
public ResponseEntity<Book>deleteBookByIdByAdmin(@PathVariable Integer bookId){
	Book b =bookServicei.deleteById(bookId);
	return new ResponseEntity<Book>(b,HttpStatus.OK);

	
}

@PutMapping(value = "/issueBook/{bookId}")
public ResponseEntity<Student>issueBook(@RequestBody Student student,@PathVariable Integer bookId){
	Book book=bookServicei.searchById(bookId);
	if(book!=null && book.getBookAvalabilityNumber()>0) {
		IssueBook issuebook = new IssueBook();
		issuebook.setBookId(book.getBookId());
		issuebook.setBookAuthorName(book.getBookAuthorName());
		issuebook.setBookDepartment(book.getBookDepartment());
		issuebook.setBookName(book.getBookName());
		issuebook.setBookType(book.getBookType());
		issuebook.setBookIssueDate(new Date());
		issuebook.setBookReturnDate(AddDaysInCurrentDays.AddDaysCalculator());
		issuebook.setPenaltyfees(0.00);
		student.getIssuebooks().add(issuebook);
		Student s=studentservcei.updateStudent(student);
		if(s!=null) {
			Long noOfBook=book.getBookAvalabilityNumber()-1;
			book.setBookAvalabilityNumber(noOfBook);
			bookServicei.updateBook(bookId, book);
			
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);

		}
	}
	else {
		throw new BookIdNotFound("Book Not Present with ID"+bookId);
	}
	
	
	
}
@PutMapping(value = "/returnBook/{bookId}")
public ResponseEntity<Student>returnBook(@RequestBody Student student,@PathVariable Integer bookId){
	Book book=bookServicei.searchById(bookId);
	student.getIssuebooks().forEach((a)->{
		if(a.getBookId()==bookId) {
			
		}
	});
	
	
	
	return new ResponseEntity<Student>(HttpStatus.OK);
}



}
