package com.starlink.librarymanagementmystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.starlink.librarymanagementmystem.exceptions.StudentNotFoundException;
import com.starlink.librarymanagementmystem.exceptions.StudentNotSaveException;
import com.starlink.librarymanagementmystem.model.IssueBook;
import com.starlink.librarymanagementmystem.model.Student;
import com.starlink.librarymanagementmystem.repository.studentRepository;
import com.starlink.librarymanagementmystem.sevicei.studentservicei;
@Service
public class StudentServiceImpl implements studentservicei {
@Autowired
studentRepository srepos;

@Override
public Student saveStudent(Student s) {
	Student stud=srepos.save(s);
	if(stud!=null)
	{
		return stud;
	}
	else {
		throw new StudentNotSaveException("Student Not Save Because Internal error");
	}

	
}

@Override
public Student getStudentByName(String studentname) {
	
	Student s= srepos.findStudentBystudentName(studentname);
	if(s!=null) {
		return s;
	}
	else {
		throw new StudentNotFoundException("Student Entered is not Available In Data");
	}
}

@Override
public Student getStudentById(int id) {
  Optional<Student> findById = srepos.findById(id);
  if(findById.isPresent())
  {
	  Student student = findById.get();  
	  return student;
  }
  else {
	  throw new StudentNotFoundException("Student Not Available by Id");
  }
}

@Override
public Student getStudentByUserName(String username) {
	Student s=srepos.findStudentBystudentUserName(username);
	if(s!=null)
	{
		return s;
	}
	else {
		throw new StudentNotFoundException("Student Not Available search by User Name");
	}

}


@Override
public List<Student> getStudentsByIssueBookedName(String issuebookname) {
	
	List<Student>resultList = new ArrayList<Student>();
	List<Student>students = (List<Student>) srepos.findAll();
	students.forEach((a)->{
		
		a.getIssuebooks().forEach((ab)->{
			
			if(ab.getBookName().equals(issuebookname)) {
				
				resultList.add(a);
			}
		});
	});
	if(!resultList.isEmpty()) {
		return resultList;
	}
	else {
		throw new StudentNotFoundException("Student not found by bookissued name");
	}
	
	

}

@Override
public Student updateStudent(Student s) {
	Integer studentId = s.getStudentId();
	Optional<Student> findById = srepos.findById(studentId);
	if(findById.isPresent())
	{
		Student student = findById.get();
		return srepos.save(s);
	}
	else {
		throw new StudentNotFoundException("Student Not found for Update");
	}
	
}
	
}
