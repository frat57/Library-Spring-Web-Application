package com.luv2code.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Publisher;

@Component
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
