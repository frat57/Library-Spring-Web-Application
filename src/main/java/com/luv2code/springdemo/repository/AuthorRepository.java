package com.luv2code.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Author;

@Component
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
