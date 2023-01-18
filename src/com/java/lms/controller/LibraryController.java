package com.java.lms.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.lms.dto.LibraryDTO;
import com.java.lms.service.impl.LibraryServiceImpl;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class LibraryController {

	Scanner sc = new Scanner(System.in);
	LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
	LibraryDTO libraryDTO = new LibraryDTO();
	
	public void callLibraryPanal() throws SQLException {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" EnteR 1 FoR ADD BooKs...\n EnteR 2 FoR VIEW BookLisT...\n EnteR 3 FoR REMOVE BooKs FroM LibrarY...\n "
				+ "EnteR 4 FoR ISSUE BooKs...\n EnteR 5 FoR RETURN BooKs...\n !!PresS AnY OtheR NumbeR FoR ExiT!! ");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("ADD BooK NamE...");
			sc.nextLine();
			String bookname = sc.nextLine();
			if(bookname.matches("[a-zA-Z][a-zA-Z ]*")){
			libraryDTO.setBookname(bookname);
			System.out.println("ADD BooK CodE");
			String bookcode = sc.nextLine();
	        if(bookcode.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")){
			libraryDTO.setBookcode(bookcode);
			System.out.println("ADD BooK QuantitY");
			libraryDTO.setBook_quantity(sc.nextInt());
			libraryServiceImpl.addBooks(libraryDTO);
	        }else{
		          System.out.println("PleasE EnteR NUMBER & ALPHABETS !!");
		        }
			}else{
				System.out.println("PleasE ADD VALID Book-Name!!");
			}
			callLibraryPanal();
			break;
		case 2:
			libraryServiceImpl.viewBooks();
			callLibraryPanal();
			break;
		case 3:
			System.out.println("EnteR BOOKCODE for DELETE BooK..");
			sc.nextLine();
			libraryDTO.setBookcode(sc.nextLine());
			libraryServiceImpl.deleteBooks(libraryDTO);
			callLibraryPanal();
			break;
		case 4:
			System.out.println("EnteR BOOKCODE for ISSUE BooK");
			sc.nextLine();
			libraryDTO.setBookcode(sc.nextLine());
			libraryServiceImpl.issueBooks(libraryDTO);
			callLibraryPanal();
			break;
		case 5:
			System.out.println("EnteR BOOKCODE for RETURN BooK");
			sc.nextLine();
			libraryDTO.setBookcode(sc.nextLine());
			libraryServiceImpl.returnBooks(libraryDTO);
			callLibraryPanal();
			break;
	
		default:
			exit();			
			break;
		}
	}
	
	private void exit() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("ThanK YoU FoR UsinG OnlinE LibrarY SysteM :)");
	}
}
