package com.java.lms.iservice;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.dto.AdminDTO;

public interface IAdminService {
	
	void saveAdmin(AdminDTO adminDTO) throws SQLException;
	
	List<AdminDTO> viewAdmin() throws SQLException;
	
	void deleteAdmin(AdminDTO adminDTO) throws SQLException;

}
