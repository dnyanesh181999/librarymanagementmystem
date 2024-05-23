package com.starlink.librarymanagementmystem.sevicei;

import java.util.List;

import com.starlink.librarymanagementmystem.model.Student;

public interface studentservicei {

	Student saveStudent(Student s);

	Student getStudentByName(String studentname);

	Student getStudentById(int id);

	Student getStudentByUserName(String username);

	List<Student> getStudentsByIssueBookedName(String issuebookname);

	Student updateStudent(Student s);

}
