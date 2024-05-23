package com.starlink.librarymanagementmystem.servicei;

import com.starlink.librarymanagementmystem.model.Admin;

public interface AdminServicei {

	public Admin regiterAdmin(Admin ad);

	public Admin loginAdmin(String username, String password);

}
