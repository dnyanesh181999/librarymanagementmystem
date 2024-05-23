package com.starlink.librarymanagementmystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.model.Student;
import com.starlink.librarymanagementmystem.sevicei.studentservicei;

@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired
studentservicei ssi;
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student s) {
		System.out.println("Student saved sucessfully");
		System.out.println("Changes by pranav deshmukh");
		return null;
	}
	@GetMapping("/getStudentByName/{name}")
	public ResponseEntity<Student> getStudentByName(@PathVariable String name){
		Student studen  =ssi.getStudentByName(name);
		return new ResponseEntity<Student>(studen,HttpStatus.OK);
	}
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		Student studen  =ssi.getStudentById(id);
		return new ResponseEntity<Student>(studen,HttpStatus.OK);
	}
	@GetMapping("/getStudentById/{username}")
	public ResponseEntity<Student> getStudentByUserName(@PathVariable String username){
		Student studen  =ssi.getStudentByUserName(username);
		return new ResponseEntity<Student>(studen,HttpStatus.OK);
	}
	@GetMapping("/getStudentByIssueBook/{issuebookname}")
	public ResponseEntity<Student> getStudentsByIssueBookedName(@PathVariable String issuebookname){
		Student studen  =ssi.getStudentByUserName(issuebookname);
		return new ResponseEntity<Student>(studen,HttpStatus.OK);
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<Student>updateStudent(@RequestBody Student s)
	{
		
		Student student=ssi.updateStudent(s);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
