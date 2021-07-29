package com.mphasis.service;

import java.util.List;

import com.mphasis.dto.BookDTO;
import com.mphasis.exception.MphasisBookException;


public interface BookService {
	
	public BookDTO getBookDetails(Integer bookId) throws MphasisBookException ;

	public List<BookDTO> searchBookByTerm(String term) throws MphasisBookException ;

	

	public Integer addBook(BookDTO book) throws MphasisBookException ;
	
	
	

}
