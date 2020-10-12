package com.luv2code.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.luv2code.springdemo.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query(value = "SELECT c FROM Book c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.series_name LIKE '%' || :keyword || '%'"
            + " OR c.author.name LIKE '%' || :keyword || '%'"
            + " OR c.isbn LIKE '%' || :keyword || '%'")
	public List<Book> search(@Param("keyword") String keyword);
}
