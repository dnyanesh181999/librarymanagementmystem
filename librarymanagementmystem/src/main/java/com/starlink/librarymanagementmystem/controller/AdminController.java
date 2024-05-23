package com.starlink.librarymanagementmystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starlink.librarymanagementmystem.model.Admin;
import com.starlink.librarymanagementmystem.servicei.AdminServicei;
import com.starlink.librarymanagementmystem.servicei.BookServicei;

@RestController("/admin")
public class AdminController {
@Autowired
AdminServicei as;
@Autowired
BookServicei bs;

@PostMapping(value = "/admin",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
public ResponseEntity<Admin> registerAdmin(@RequestBody Admin ad) {
	Admin adm = as.regiterAdmin(ad);
	
	return new ResponseEntity<Admin>(adm,HttpStatus.OK);
}

@GetMapping(value = "/admin/{username}/{password}",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
public ResponseEntity<Admin>loginAdmin(@PathVariable String username,@PathVariable String password){
	Admin ad = as.loginAdmin(username,password);
	return new ResponseEntity<Admin>(ad,HttpStatus.OK);
	
	
}
	

}
