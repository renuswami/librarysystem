package com.java.lms.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.lms.dao.impl.LibraryDaoImpl;
import com.java.lms.dto.LibraryDTO;
import com.java.lms.iservice.ILibraryService;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class LibraryServiceImpl implements ILibraryService {

	LibraryDaoImpl libraryDaoImpl = new LibraryDaoImpl();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void addBooks(LibraryDTO libraryDTO) throws SQLException {
		LibraryDTO bookcode = libraryDaoImpl.getBookByCode(libraryDTO.getBookcode());
		if (bookcode == null) {
			int isInsert = libraryDaoImpl.addBooks(libraryDTO);
			if (isInsert > 0) {
				System.out.println("BooK ADDED SeccussfullY.. \n");
			} else {
				System.out.println("ErroR in ADD BooK !! \n");
			}
		} else {
			System.out.println("BooK AlreadY ADDED in LibrarY !! \n ");
			 libraryDTO.setBook_quantity(bookcode.getBook_quantity() + libraryDTO.getBook_quantity());
			 System.out.println("YoU CaN INCRESE ThiS BookCodE QuantitY :-) \n PresS ENTER FoR UPDATE-QUANTITY of ThiS BookCodE (;");
				sc.nextLine();
			 libraryDaoImpl.updateBookQuantity(libraryDTO);
				int isIssue = libraryDaoImpl.issueBooks(libraryDTO);
				if (isIssue == 1) {
					System.out.println("BooK QuantitY SeccussfullY UPDATED.. \n");
				} else {
					System.out.println("ErroR in UPDATE BooK QuantitY!! \n");
				}
		}
	}

	@Override
	public void viewBooks() throws SQLException {
		List<LibraryDTO> list = libraryDaoImpl.viewBooks();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("BookSrNo" + " " + "BookName" + " " + "BookCode" + " " + "BookQuantity" + " " + "IssueBooks");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (LibraryDTO lib : list) {
			System.out.println(lib.getId() + " 	  " + lib.getBookname() + "       " + lib.getBookcode() + "	 "
					+ lib.getBook_quantity() + "	 " + lib.getIssuebook());
		}
	}

	@Override
	public void deleteBooks(LibraryDTO libraryDTO) throws SQLException {

		LibraryDTO bookcode = libraryDaoImpl.getBookByCode(libraryDTO.getBookcode());
		if (bookcode != null) {
			int isDelete = libraryDaoImpl.deleteBooks(libraryDTO);
			if (isDelete == 1) {
				System.out.println("BooK REMOVE SeccussfullY...");
			} else {
				System.out.println("ErroR in REMOVE!!");
			}
		} else {
			System.out.println("BooK NOT EXIST in LibrarY !!");
		}
	}

	@Override
	public void issueBooks(LibraryDTO libraryDTO) throws SQLException {
		LibraryDTO bookcode = libraryDaoImpl.getBookByCode(libraryDTO.getBookcode());
		if (bookcode != null) {		
			if(bookcode.getBook_quantity() > bookcode.getIssuebook()){
				libraryDTO.setIssuebook(bookcode.getIssuebook() + 1);
				int isIssue = libraryDaoImpl.issueBooks(libraryDTO);
				if (isIssue == 1) {
					System.out.println("BooK ISSUED..");
				} else {
					System.out.println("ErroR in ISSUE booK !!");
				}
			} else {
				System.out.println("This BooK STOCK-NOT-AVAILABLE in LibrarY !!");
			}
		}else{
			System.out.println("ThiS BooK NOT-AVAILABLE in LibrarY!!");
		}
	}

	@Override
	public void returnBooks(LibraryDTO libraryDTO) throws SQLException {
		LibraryDTO bookcode = libraryDaoImpl.getBookByCode(libraryDTO.getBookcode());
		if (bookcode != null) {
			if(bookcode.getIssuebook() >= 1){
				libraryDTO.setIssuebook(bookcode.getIssuebook() - 1);
				int isIssue = libraryDaoImpl.issueBooks(libraryDTO);
				if (isIssue == 1) {
					System.out.println("Book RETURNED..");
				} else {
					System.out.println("ErroR in RETURN booK!!");
				}
			}else{
				System.out.println("booK NOT-ISSUED !!");
			}
		} else {
			System.out.println("book not available in library !!");
		}
	}
}
