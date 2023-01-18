package com.java.lms.iservice;

import java.sql.SQLException;
import com.java.lms.dto.LibraryDTO;

public interface ILibraryService {

	void addBooks(LibraryDTO libraryDTO) throws SQLException;
	
	void viewBooks() throws SQLException;

	void deleteBooks(LibraryDTO libraryDTO) throws SQLException;
	
	void issueBooks(LibraryDTO libraryDTO) throws SQLException;

	void returnBooks(LibraryDTO libraryDTO) throws SQLException;

}
