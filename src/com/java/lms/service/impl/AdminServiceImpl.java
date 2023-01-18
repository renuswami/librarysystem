package com.java.lms.service.impl;

import java.sql.SQLException;
import java.util.List;
import com.java.lms.dao.impl.AdminDaoImpl;
import com.java.lms.dto.AdminDTO;
import com.java.lms.iservice.IAdminService;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */
public class AdminServiceImpl implements IAdminService {

	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();

	@Override
	public void saveAdmin(AdminDTO adminDTO) throws SQLException {
		AdminDTO librarianId = adminDaoImpl.getAdminById(adminDTO.getLibrarianId());
		if(librarianId == null){
			int isIsert = adminDaoImpl.saveAdmin(adminDTO);
			if (isIsert>0) {
				System.out.println("LibrariaN ADD seccussfully....");
			}else{
				System.out.println("ErroR in ADD LibrariaN!!");
			}
		}else{
			System.out.println("LibrariaN AlreadY ADDED in LibrarY!!");
		}
	}

	@Override
	public List<AdminDTO> viewAdmin() throws SQLException {
		List<AdminDTO> list = adminDaoImpl.viewAdmin();
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Librarian-Id" + " " + "Libraian-Name");
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (AdminDTO adminDTO : list) {
			System.out.println(adminDTO.getLibrarianId() + "		" + adminDTO.getName());
		}
		return list;
	}

	@Override
	public void deleteAdmin(AdminDTO adminDTO) throws SQLException {
		AdminDTO librarianId = adminDaoImpl.getAdminById(adminDTO.getLibrarianId());
		if(librarianId != null){
			int isDelete = adminDaoImpl.deleteAdmin(adminDTO);
			if (isDelete > 0) {
				System.out.println("UseR DELETE SeccussfullY...");
			} else {
				System.out.println("ErroR in DELETE!!");
			}
		}else{
			System.out.println("LibrarianId NOT Exist!!");
		}	
	}
}
