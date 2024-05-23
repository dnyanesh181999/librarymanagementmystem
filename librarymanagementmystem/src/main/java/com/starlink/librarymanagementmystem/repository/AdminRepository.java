package com.starlink.librarymanagementmystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.starlink.librarymanagementmystem.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

}
