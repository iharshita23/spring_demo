package com.bookapp.model;

import org.springframework.stereotype.Component;
@Component
public class BookMapper {

		public Book convertToDocument(BookDTO bookDTO) {
			Book book = new Book();
			book.setTitle(bookDTO.getTitle());
			book.setAuthor(bookDTO.getAuthor());
			book.setCategory(bookDTO.getCategory());
			book.setPrice(bookDTO.getPrice());
			book.setBookId(bookDTO.getBookId());
			return book;
		}
		
		public BookDTO convertToDTO(Book book) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle(book.getTitle());
			bookDTO.setAuthor(book.getAuthor());
			bookDTO.setCategory(book.getCategory());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setBookId(book.getBookId());
			return bookDTO;
		}
}
