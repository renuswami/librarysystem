package com.java.lms.dto;

public class LibraryDTO {
	
		private int id;
		private String bookname;
		private int issuebook;
		private int book_quantity;
		private String bookcode;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getBookname() {
			return bookname;
		}
		public void setBookname(String bookname) {
			this.bookname = bookname;
		}
		public int getIssuebook() {
			return issuebook;
		}
		public void setIssuebook(int issuebook) {
			this.issuebook = issuebook;
		}
		public int getBook_quantity() {
			return book_quantity;
		}
		public void setBook_quantity(int book_quantity) {
			this.book_quantity = book_quantity;
		}
		public String getBookcode() {
			return bookcode;
		}
		public void setBookcode(String bookcode) {
			this.bookcode = bookcode;
		}
}
