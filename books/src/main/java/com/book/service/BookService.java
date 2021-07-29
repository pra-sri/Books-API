package com.book.service;

import java.util.List;

import com.book.dto.BookDTO;
import com.book.exception.MphasisBookException;


public interface BookService {
	
	public BookDTO getBookDetails(Integer bookId) throws MphasisBookException ;

	public List<BookDTO> searchBookByTerm(String term) throws MphasisBookException ;

	

	public Integer addBook(BookDTO book) throws MphasisBookException ;
	
	
	

}
