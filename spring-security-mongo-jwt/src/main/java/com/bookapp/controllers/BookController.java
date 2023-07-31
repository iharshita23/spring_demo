package com.bookapp.controllers;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.bookapp.model.BookDTO;
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
    ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/books")
    ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
    	BookDTO bookdtos = bookService.updateBook(bookDTO);
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.add("desc", "Updating books");
    	 return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(bookdtos);
    }
    
    @DeleteMapping("/books")
    ResponseEntity<Void> deleteBook(@PathVariable("bookId")int bookId) {
    	bookService.deleteBook(bookId);
    	return ResponseEntity.status(HttpStatus.CREATED).build();
    }

 

    @GetMapping("/books/{bookId}")
    BookDTO getById(@PathVariable int bookId){
        return bookService.getById(bookId);
    }


    @GetMapping("/books")
    ResponseEntity <List<BookDTO>> getAll() {
        List<BookDTO> bookdtos = bookService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the list of books");
        headers.add("time retreived", LocalDateTime.now().toString());
        ResponseEntity<List<BookDTO>> responseEntity = new ResponseEntity<>(bookdtos,headers,HttpStatus.OK);
        return responseEntity;       
    }


    @GetMapping("/books/author/{author}")
    ResponseEntity <List<BookDTO>> getByAuthorContains(@PathVariable("author") String author)throws BookNotFoundException{
        List<BookDTO> bookdtos = bookService.getByAuthorContains(author);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting the list of books by author and category");
        return ResponseEntity.ok().headers(headers).body(bookdtos);
    }
    
    @GetMapping("/books/category")
        ResponseEntity <List<BookDTO>> getByAuthorCategory(@RequestParam("category") String category) throws BookNotFoundException {
            List<BookDTO> bookdtos = bookService.getByCategory(category);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "Getting the list of books by author and category");
            return ResponseEntity.ok().headers(headers).body(bookdtos);
        }
    
        @GetMapping("/books/price/{price}")
        ResponseEntity <List<BookDTO>> getByPriceLessThan(@PathVariable double price) throws BookNotFoundException {
            List<BookDTO> bookdtos =  bookService.getByPriceLessThan(price);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "Getting the list of books by price less than");
            return ResponseEntity.ok().headers(headers).body(bookdtos);
        }

//    @GetMapping("/books/author/{author}/price/{price}")
//    List<BookDTO> findByAuthPrice(@PathVariable String author,@PathVariable double price) {
//        return bookService.findByAuthPrice(author, price);
//    }
//
// 
//
//    @GetMapping("/books/authorTitle")
//    List<BookDTO> findByAuthOrTitle(@RequestParam String author,@RequestParam String title) {
//        return bookService.findByAuthOrTitle(author, title);
//    }

}
