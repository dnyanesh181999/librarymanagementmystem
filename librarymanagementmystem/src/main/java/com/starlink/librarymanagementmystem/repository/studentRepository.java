package com.starlink.librarymanagementmystem.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starlink.librarymanagementmystem.model.Student;

@Repository
public interface studentRepository extends CrudRepository<Student, Integer>{
public Student findStudentBystudentName(String name);

 Student findStudentBystudentUserName(String username);

}
