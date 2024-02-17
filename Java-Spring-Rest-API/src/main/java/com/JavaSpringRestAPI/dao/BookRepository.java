package com.JavaSpringRestAPI.dao;

import com.JavaSpringRestAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
