package com.java.lms.dao.impl;

import java.sql.*;
import java.util.*;

import com.java.lms.dto.AdminDTO;
import com.java.lms.idao.IAdminDao;
import com.java.lms.query.Query;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */
public class AdminDaoImpl implements IAdminDao{
	DataBase db = new DataBase();
	
	@Override
	public int saveAdmin(AdminDTO adminDTO) throws SQLException {
		try {
			Connection con = db.getConnection();
			PreparedStatement psmt = con.prepareStatement(Query.ADD_ADMIN);
			psmt.setString(1, adminDTO.getLibrarianId());
			psmt.setString(2, adminDTO.getName());
			return psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<AdminDTO> viewAdmin() throws SQLException {
		List<AdminDTO> list = new ArrayList<AdminDTO>();
		try {
			Connection con = db.getConnection();
			PreparedStatement stm = con.prepareStatement(Query.ADMIN_LIST);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				AdminDTO dto = new AdminDTO();
				dto.setLibrarianId(rs.getString(2));
				dto.setName(rs.getString(3));
				list.add(dto);
				}  
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int deleteAdmin(AdminDTO adminDTO) throws SQLException {
		try {
			Connection con = db.getConnection();
			PreparedStatement stm = con.prepareStatement(Query.DELETE_ADMIN);
			stm.setString(1, adminDTO.getLibrarianId());
			return stm.executeUpdate();	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public AdminDTO getAdminById(String librarianId) throws SQLException {
		List<AdminDTO> libList = new ArrayList<AdminDTO>();
		try {
			Connection con = db.getConnection();
			PreparedStatement stm= con.prepareStatement(Query.ADMIN_BY_ID);
			stm.setString(1, librarianId);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				AdminDTO aDTO = new AdminDTO();
				aDTO.setId(rs.getInt(1));
				aDTO.setLibrarianId(rs.getString(2));
				aDTO.setName(rs.getString(3));
				
				libList.add(aDTO);
			}
			   if (!libList.isEmpty()) {
				 	  return libList.get(0);
				   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
