package com.bookapp.service;

import java.util.List;



import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDTO;
import com.bookapp.model.BookMapper;
import com.bookapp.repository.IBookRepository;
@Service
public class BookServiceImpl implements IBookService {

	private IBookRepository ibookRepository;
	@Autowired
	public BookServiceImpl(IBookRepository ibookRepository) {
		this.ibookRepository = ibookRepository;
	}
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public void addBook(BookDTO bookDTO) {
		Book book = bookMapper.convertToDocument(bookDTO);
		ibookRepository.insert(book);	
	}
	@Override
	public BookDTO updateBook(BookDTO bookDTO) {
		Book book = bookMapper.convertToDocument(bookDTO);
		Book nbook = ibookRepository.save(book);
		return bookMapper.convertToDTO(nbook);
		
	}
	@Override
	public void deleteBook(int bookId) {
		ibookRepository.deleteById(bookId);	
	}
	
	@Override
	public List<BookDTO> getAll() {
		List<Book> books = ibookRepository.findAll();
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
		
	}
	
//	@Override
//	public BookDTO getById(int bookId) throws BookNotFoundException {
//		return  ibookRepository
//				.findById(bookId).orElseThrow(() ->  new BookNotFoundException("No Book Found for Id: "+ bookId));
//                		
//	}
	
	@Override
	public List<BookDTO> getByDatePublished(int year) throws BookNotFoundException {
		return null;
	}

	@Override
	public List<BookDTO> getByAuthorContains(String author) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuthorContaining(author);
		if(books.isEmpty())
			throw new BookNotFoundException("Author not found");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}

	@Override
	public List<BookDTO> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByCategory(category);
		if(books.isEmpty())
			throw new BookNotFoundException("Category not found");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}

	@Override
	public List<BookDTO> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByPriceLessThan(price);
		if(books.isEmpty())
			throw new BookNotFoundException("Price less than this");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}

	@Override
	public List<BookDTO> getByAuthPrice(String author, double price) throws BookNotFoundException {
		List<Book> books = ibookRepository.getByAuthPrice(author,price);
		if(books.isEmpty())
			throw new BookNotFoundException("Price less than this");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}
	
	@Override
	public List<BookDTO> findByAuth(String author) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuth(author);
		if(books.isEmpty())
			throw new BookNotFoundException("Author not found");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}
	
	@Override
	public List<BookDTO> findByAuthororTitle(String author,String title) throws BookNotFoundException {
		List<Book> books = ibookRepository.findByAuthororTitle(author,title);
		if(books.isEmpty())
			throw new BookNotFoundException("Author or title not found");
		List<BookDTO> bookDtos = books.stream()
				.map(book->bookMapper.convertToDTO(book))
				.toList();
		return bookDtos;
	}
	
	@Override
	public List<BookDTO> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDTO getById(int bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	private List<BookDTO> convertList(List<Book> books) {
        if(books.isEmpty())
            throw new BookNotFoundException("Author not found");
        List<BookDTO> bookDtos = 
                books.stream()
                .map(book->bookMapper.convertToDTO(book))
                .toList();
        return bookDtos;
}
	@Override
	public List<BookDTO> findByAuthPrice(String author, double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BookDTO> findByAuthOrTitle(String author, String title) {
		// TODO Auto-generated method stub
		return null;
	}
}
