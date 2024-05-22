package com.starlink.librarymanagementmystem.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student s) {
		System.out.println("Student saved sucessfully");
		return null;
	}
	
}
