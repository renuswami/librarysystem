package com.java.lms.controller;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class LibrarySystemController{

	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		AdminController adminController = new AdminController();
		LibraryController libraryController = new LibraryController();
		System.out.println("EnteR 1 FoR ADMIN-PANAL & 2 FoR LIBRARY-PANAL :)");
	
		while(!sc.hasNextInt()){
			System.out.println("PleasE EnteR CURRECT-CASE !!");
			sc.next();
		}
		int n=sc.nextInt();
		switch (n) {
		case 1:
			adminController.callAdminPanal();
			break;
		case 2:
			libraryController.callLibraryPanal();
			break;
		default:
			System.out.println("PleasE ChoosE ADMIN-PANAL or LIBRARY-PANAL!!");
			break;
		}
	}
}
