package com.mphasis.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.mphasis.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{


	public List<Book> findByTitleLike(String term);

}
