package com.java.lms.query;

import com.java.lms.dto.AdminDTO;

public class Query {

	static AdminDTO adminDTO = new AdminDTO();

	public static final String ADMIN_LIST = "select * from admin where isActive=1 ";

	public static final String ADD_ADMIN = " insert into admin set librarianId = ?, name = ? ";

	public static final String DELETE_ADMIN = "update admin set isActive=0 where librarianId = ? ";
	
	public static final String ADMIN_BY_ID = "select * from admin where isActive = 1 and librarianId = ? ";

	public static final String ADD_BOOKS = "insert into library set bookname = ? , bookcode = ? , book_quantity = ? ";

	public static final String BOOK_LIST = "select * from library where isActive = 1 ";

	public static final String DELETE_BOOK = "update library set isActive = 0 where bookcode = ? ";

	public static final String ISSUEE_BOOKS = "update library set issuebook =? where bookcode = ? ";
	
	public static final String BOOK_BY_BOOKCODE = "select * from library where isActive = 1 and bookcode = ?";

	public static final String UPDATE_BOOK_QUANTIT = "update library set book_quantity = ? where bookcode = ? ";

}
