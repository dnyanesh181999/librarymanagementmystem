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
	Optional<Student> student = srepos.findById(studentId);
	if(student.isPresent())
	{
		Student s1=student.get();
		if(s.getStudentName()!=null)
		{
			s1.setStudentName(s.getStudentName());
		}
		if(s.getStudentUserName()!=null)
		{
			s1.setStudentUserName(s.getStudentUserName());
		}
		if(s.getStudentPassword()!=null)
		{
			s1.setStudentPassword(s.getStudentPassword());
		}
		if(s.getStudentEmail()!=null)
		{
			s1.setStudentEmail(s.getStudentEmail());
		}
		if(s.getStudentContact()!=null)
		{
			s1.setStudentContact(s.getStudentContact());
		}
		if(s.getStudentAddress().getAddressLocal()!=null)
		{
			s1.getStudentAddress().setAddressLocal(s.getStudentAddress().getAddressLocal());
		}
		if(s.getStudentAddress().getAddressPermanent()!=null)
		{
			s1.getStudentAddress().setAddressPermanent(s.getStudentAddress().getAddressPermanent());
		}
		if(s.getStudentAddress().getCity()!=null)
		{
			s1.getStudentAddress().setCity(s.getStudentAddress().getCity());
		}
			if(s.getStudentAddress().getDistrict()!=null)
			{
				s1.getStudentAddress().setDistrict(s.getStudentAddress().getDistrict());
			}
			if(s.getStudentAddress().getPincode()>0)
			{
				s1.getStudentAddress().setPincode(s.getStudentAddress().getPincode());
			}
			if(s.getStudentAddress().getState()!=null)
			{
				s1.getStudentAddress().setState(s.getStudentAddress().getState());
			}
		
		
			
		return srepos.save(s);
	}
	else {
		throw new StudentNotFoundException("Student Not found for Update");
	}
	
}
	
}
//public Product updateProduct(Product p, Integer productId) {
//	Optional<Product> opt=prrepo.findById(productId);
//if(opt.isPresent())
//{
//	Product product=opt.get();
//	if(p.getProductName()!=null)
//	{
//		product.setProductName(p.getProductName());
//	}
//	if(p.getProductPrice()!=null)
//	{
//		product.setProductPrice(p.getProductPrice());
//	}
//	if(p.getProductType()!=null)
//	{
//		product.setProductType(p.getProductType());
//	}
//	
//	return prrepo.save(product);
//}
//else {
//	return null;
//}
//	
//}
