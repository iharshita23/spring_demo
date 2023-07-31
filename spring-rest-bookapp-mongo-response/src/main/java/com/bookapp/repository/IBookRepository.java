package com.bookapp.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;
import com.bookapp.model.BookDTO;

@Repository
public interface IBookRepository extends MongoRepository<Book, Integer>{
//	CRUD operations
//	void addBook(Book book);
//	Book updateBook(Book book);
//	void deleteBook(int bookId);
//	Book updateBook(Book book);
	
	//derived queries
	
		List<Book> findByAuthorContaining(String author);
		List<Book> findByCategory(String category);
		List<Book> findByPriceLessThan(double price);
		
	//Custom queries - method name can be anything
		@Query("find({author:?1,price:{$lte:?2}})")
		List<Book> getByAuthPrice(String author,double price);
		
		@Query("{author:?0}")
		List<Book> findByAuth(String author);
		
		@Query("find($or:[{author:?0,title:?1}])")
		List<Book> findByAuthororTitle(String author,String title);
	
	
}
