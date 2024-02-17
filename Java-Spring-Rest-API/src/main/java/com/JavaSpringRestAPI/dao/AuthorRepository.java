package com.JavaSpringRestAPI.dao;

import com.JavaSpringRestAPI.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
