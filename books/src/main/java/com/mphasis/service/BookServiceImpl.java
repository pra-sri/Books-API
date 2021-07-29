package com.mphasis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.dto.BookDTO;
import com.mphasis.entity.Book;
import com.mphasis.repository.BookRepository;
import com.mphasis.exception.MphasisBookException;

@Service(value = "bookService")
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;


	@Override
	public BookDTO getBookDetails(Integer bookId) throws MphasisBookException {
		
		Optional<Book> optional = bookRepository.findById(bookId);
		
		Book book = optional.orElseThrow( () -> new MphasisBookException("BookService.BOOK_NOT_FOUND"));
		
			BookDTO bookDTO = new BookDTO();
			bookDTO.setAuthors(book.getAuthors());
			bookDTO.setAverageRating(book.getAverageRating());
			bookDTO.setBookID(book.getBookID());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setLanguageCode(book.getLanguageCode());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setRatingCount(book.getRatingCount());
			bookDTO.setTitle(book.getTitle());
			
		
		return bookDTO;
		
	}
	
	@Override
	public List<BookDTO> searchBookByTerm(String term) throws MphasisBookException {
		
			List<BookDTO> bookDTOs = new ArrayList<>();
			List<Book> searchResult = bookRepository.findByTitleLike(term) ;
			
			if (searchResult.isEmpty())
				throw new MphasisBookException("BookService.BOOK_NOT_FOUND");
			searchResult.forEach( book -> {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setAuthors(book.getAuthors());
				bookDTO.setAverageRating(book.getAverageRating());
				bookDTO.setBookID(book.getBookID());
				bookDTO.setIsbn(book.getIsbn());
				bookDTO.setLanguageCode(book.getLanguageCode());
				bookDTO.setPrice(book.getPrice());
				bookDTO.setRatingCount(book.getRatingCount());
				bookDTO.setTitle(book.getTitle());
				bookDTOs.add(bookDTO);
				
			});
			return bookDTOs ;
		
		
	}
	
	@Override
	public Integer addBook(BookDTO bookDto) throws MphasisBookException {
		
			Book book = new Book();
			book.setBookID(bookDto.getBookID());
			book.setAuthors(bookDto.getAuthors());
			book.setAverageRating(bookDto.getAverageRating());
			
			book.setIsbn(bookDto.getIsbn());
			book.setLanguageCode(bookDto.getLanguageCode());
			book.setPrice(bookDto.getPrice());
			book.setRatingCount(bookDto.getRatingCount());
			book.setTitle(bookDto.getTitle());
			
			bookRepository.save(book);
		return book.getBookID();
		
	}
	
	

}
