package com.mphasis.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mphasis.dto.BookDTO;
import com.mphasis.exception.MphasisBookException;
import com.mphasis.service.BookService;


@RestController
@RequestMapping(value = "/")
public class BookAPI {
	
	@Autowired
	private BookService bookService ;
	@Autowired
	private Environment environment ;
	
	
	/* The below codes will be used to get book details by searching the DB using the provided BookId*/
	@GetMapping(value = "{bookId}")
	public ResponseEntity<BookDTO> getBookDetails(@PathVariable Integer bookId) throws MphasisBookException {
		try {
			BookDTO bookDTO = bookService.getBookDetails(bookId);
			return new ResponseEntity<>(bookDTO, HttpStatus.OK);
		}
		catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
		
	}
	
	
	/* The below codes will be used to get book details by searching the DB using the provided term, that is whether the provide 'term' is present in the title */
	@GetMapping(value = "search/{term}")
	public ResponseEntity<List<BookDTO>> searchBook(@PathVariable String term) throws MphasisBookException {
		try {
			List<BookDTO> bookDTO = bookService.searchBookByTerm("%"+term+"%");
			return new ResponseEntity<>(bookDTO, HttpStatus.OK);
		}
		catch(Exception exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, environment.getProperty(exception.getMessage()), exception);
		}
	}
	
	
	/* The below codes will be used to add book into the db using the given JSON format*/
	@PostMapping(value = "addbook")
	public ResponseEntity<String> addBook(@RequestBody BookDTO book) throws MphasisBookException {
		Integer bookId = bookService.addBook(book);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS")+bookId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}

}
