package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.dao.CategoryRepository;
import com.JavaSpringRestAPI.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getCategoryById(Long id);
    public Category createCategory(Category category);
    public Category updateCategory(Long id, Category updatedCategory);
    public void deleteCategory(Long id);
}
