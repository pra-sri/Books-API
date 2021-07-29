/**
 * 
 */
package com.book.dto;

/**
 * @author prasri1601@outlook.com
 *
 */
public class BookDTO {
	
	private Integer bookId;
	private String title ;
	private String authors ;
	private Float average_rating ;
	private String isbn ;
	private String language_code ;
	private Integer rating_count ;
	private Integer price ;
	
	
	public Integer getBookID() {
		return bookId;
	}
	public void setBookID(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Float getAverageRating() {
		return average_rating;
	}
	public void setAverageRating(Float averageRating) {
		this.average_rating = averageRating;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getLanguageCode() {
		return language_code;
	}
	public void setLanguageCode(String languageCode) {
		this.language_code = languageCode;
	}
	public Integer getRatingCount() {
		return rating_count;
	}
	public void setRatingCount(Integer ratingCount) {
		this.rating_count = ratingCount;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookDTO [bookID=" + bookId + ", title=" + title + ", authors=" + authors + ", average_rating="
				+ average_rating + ", isbn=" + isbn + ", language_code=" + language_code + ", rating_count="
				+ rating_count + ", price=" + price + "]";
	}
	
	

}
