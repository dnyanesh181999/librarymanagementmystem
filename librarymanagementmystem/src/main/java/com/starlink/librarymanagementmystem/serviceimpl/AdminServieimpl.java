package com.starlink.librarymanagementmystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starlink.librarymanagementmystem.exceptions.AdminNotSavedException;
import com.starlink.librarymanagementmystem.exceptions.InvalidUserNameAndPassword;
import com.starlink.librarymanagementmystem.model.Admin;
import com.starlink.librarymanagementmystem.repository.AdminRepository;
import com.starlink.librarymanagementmystem.servicei.AdminServicei;
@Service
public class AdminServieimpl implements AdminServicei{
	@Autowired
	AdminRepository ar;

	@Override
	public Admin regiterAdmin(Admin ad) {
		if(ad!=null) {
			Admin admin=ar.save(ad);
			if(admin!=null) {
				return admin;
			}
			else {
				return null;
			}
		}
		else {
			throw new AdminNotSavedException("Unable to rigitser admin data");
		}
	}

	@Override
	public Admin loginAdmin(String username, String password) {
		Admin ad=ar.findByAdminNameAndAdminPassword(username, password);
		if(ad!=null) {
			return ad;
		}
		else {
			throw new InvalidUserNameAndPassword("Invalid username and password");
		}
		
		
	}

}
