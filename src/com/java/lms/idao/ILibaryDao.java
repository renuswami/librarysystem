package com.java.lms.idao;

import java.sql.SQLException;
import java.util.List;

import com.java.lms.dto.LibraryDTO;

public interface ILibaryDao {

	int addBooks(LibraryDTO libraryDTO) throws SQLException;

	List<LibraryDTO> viewBooks() throws SQLException;

	int deleteBooks(LibraryDTO libraryDTO) throws SQLException;
	
	int issueBooks(LibraryDTO libraryDTO) throws SQLException;

	//int returnBooks(LibraryDTO libraryDTO) throws SQLException;

	LibraryDTO getBookByCode(String bookcode) throws SQLException;

	int updateBookQuantity(LibraryDTO libraryDTO) throws SQLException;

}
