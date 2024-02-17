package com.JavaSpringRestAPI.dao;

import com.JavaSpringRestAPI.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
