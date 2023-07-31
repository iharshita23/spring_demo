package com.bookapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

 

@RestController
@RequestMapping("/book-api/v1")
public class BookController {

 

    IBookService bookService;

 

    public BookController(IBookService bookService) {
        super();
        this.bookService = bookService;
    }

 
    @PostMapping("/books")
    void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
    
    @PutMapping("/books")
    Book updateBook(@RequestBody Book book) {
    	return bookService.updateBook(book);
    }
    @DeleteMapping("/books")
     void deleteBook(@PathVariable("bookId")int bookId) {
    	bookService.deleteBook(bookId);
    }

 

    @GetMapping("/books/{bookId}")
    Book getById(@PathVariable int bookId){
        return bookService.getById(bookId);
    }


    @GetMapping("/books")
    List<Book> getAll() {
        return bookService.getAll();
    }

 

    @GetMapping("/books/author/{author}")
    List<Book> getByAuthorContains(@PathVariable String author){
        return bookService.getByAuthorContains(author);
    }

    @GetMapping("/books/category")
    List<Book> getByAuthorCategory(@RequestParam("category") String category){
        return bookService.getByCategory(category);
    }

    @GetMapping("/books/price/{price}")
    List<Book> getByPriceLessThan(@PathVariable double price){
        return bookService.getByPriceLessThan(price);
    }

 


//    @GetMapping("/books/author/{author}/price/{price}")
//    List<Book> findByAuthPrice(@PathVariable String author,@PathVariable double price) {
//        return bookService.findByAuthPrice(author, price);
//    }
//
// 
//
//    @GetMapping("/books/authorTitle")
//    List<Book> findByAuthOrTitle(@RequestParam String author,@RequestParam String title) {
//        return bookService.findByAuthOrTitle(author, title);
    }


