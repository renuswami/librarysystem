package com.java.lms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.lms.dto.LibraryDTO;
import com.java.lms.idao.ILibaryDao;
import com.java.lms.query.Query;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class LibraryDaoImpl extends DataBase implements ILibaryDao {

	LibraryDTO libraryDTO = new LibraryDTO();
	int isInsert;
	
	@Override
	public int addBooks(LibraryDTO libraryDTO) throws SQLException {

		try {
			Connection con = getConnection();
			PreparedStatement psmt = con.prepareStatement(Query.ADD_BOOKS);
			psmt.setString(1, libraryDTO.getBookname());
			psmt.setString(2, libraryDTO.getBookcode());
			psmt.setInt(3, libraryDTO.getBook_quantity());
			return psmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<LibraryDTO> viewBooks() throws SQLException {
		List<LibraryDTO> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(Query.BOOK_LIST);
			while (rs.next()) {
				LibraryDTO lDTO = new LibraryDTO();
				lDTO.setId(rs.getInt(1));
				lDTO.setBookname(rs.getString(2));
				lDTO.setBookcode(rs.getString(3));
				lDTO.setBook_quantity(rs.getInt(4));
				lDTO.setIssuebook(rs.getInt(5));
				list.add(lDTO);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteBooks(LibraryDTO libraryDTO) throws SQLException {
		try {

			Connection con = getConnection();
			PreparedStatement stm = con.prepareStatement(Query.DELETE_BOOK);
			stm.setString(1, libraryDTO.getBookcode());
			int n = stm.executeUpdate();
			if(n > 0){
				return 1;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int issueBooks(LibraryDTO libraryDTO) throws SQLException {
		try {
			Connection con = getConnection();
			PreparedStatement stm = con.prepareStatement(Query.ISSUEE_BOOKS);
			stm.setInt(1, libraryDTO.getIssuebook());
			stm.setString(2, libraryDTO.getBookcode());
			int n = stm.executeUpdate();
			if(n > 0){
				return n;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public LibraryDTO getBookByCode(String bookcode) throws SQLException {
		List<LibraryDTO> libList = new ArrayList<LibraryDTO>();
		try {
			Connection con = getConnection();
			PreparedStatement stm= con.prepareStatement(Query.BOOK_BY_BOOKCODE);
			stm.setString(1, bookcode);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				LibraryDTO lDTO = new LibraryDTO();
				lDTO.setId(rs.getInt(1));
				lDTO.setBookname(rs.getString(2));
				lDTO.setBookcode(rs.getString(3));
				lDTO.setBook_quantity(rs.getInt(4));
				lDTO.setIssuebook(rs.getInt(5));
				libList.add(lDTO);
			}
			   if (!libList.isEmpty()) {
				 	  return libList.get(0);
				   }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int updateBookQuantity(LibraryDTO libraryDTO) throws SQLException {
		try {
			Connection con = getConnection();
			PreparedStatement stm = con.prepareStatement(Query.UPDATE_BOOK_QUANTIT);
			stm.setInt(1, libraryDTO.getBook_quantity());
			stm.setString(2, libraryDTO.getBookcode());
			int n = stm.executeUpdate();
			if(n > 0){
				return n;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
