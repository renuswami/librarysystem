package com.java.lms.controller;

import java.sql.SQLException;
import java.util.*;

import com.java.lms.dto.AdminDTO;
import com.java.lms.service.impl.AdminServiceImpl;

/**
 * 
 * @author Renu Swami(ax1009)
 *
 */

public class AdminController {
	
	AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
	AdminDTO adminDTO = new AdminDTO();
	Scanner sc = new Scanner(System.in);
	
	public void callAdminPanal() throws SQLException {
		 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(
				  "EnteR 1 FoR ADD LibrariN... \n EnteR 2 FoR VIEW LibrariN... \n"
				+ " EnteR 3 FoR DELETE LibrariN...\n!!PresS AnY NumbeR OtheR FoR EXIT!! ");

		switch (sc.nextInt()) {
		case 1:
			System.out.println("ADD LibrariaN Id ");
			sc.nextLine();
			String librarianId = sc.nextLine();
			if(librarianId.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")){
			adminDTO.setLibrarianId(librarianId);
			System.out.println("ADD LibrariaN NamE ");
			String name = sc.nextLine();
			    if(name.matches("[a-zA-Z][a-zA-Z ]*")){
			    	adminDTO.setName(name);
			    	adminServiceImpl.saveAdmin(adminDTO);
			    }else {
			    	System.out.println("Invalid NamE PleasE INSERT-CURRECT NamE !!");
			    }	
			    }else{
			          System.out.println("PleasE EnteR NUMBER & ALPHABETS !!");
			    } 		
			callAdminPanal();
			break;
		case 2:
			adminServiceImpl.viewAdmin();
			callAdminPanal();
			break;
		case 3:
			System.out.println("EnteR LibrarianId for DELETE UseR !!");
			sc.nextLine();
			adminDTO.setLibrarianId(sc.nextLine());
			adminServiceImpl.deleteAdmin(adminDTO);
			callAdminPanal();
			break;
		default:
			System.out.println("ThanK YoU FoR UsinG OnlvoidinE LibrarY SysteM :)");
			break;
		}
		sc.close();
	}
}
