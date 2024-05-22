package com.starlink.librarymanagementmystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starlink.librarymanagementmystem.model.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
