package com.java.lms.idao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.dto.AdminDTO;

public interface IAdminDao {
	
	int saveAdmin(AdminDTO adminDTO) throws SQLException;
	
	List<AdminDTO> viewAdmin() throws SQLException;
	
	int deleteAdmin(AdminDTO adminDTO) throws SQLException;

	AdminDTO getAdminById(String librarianId) throws SQLException;

}
