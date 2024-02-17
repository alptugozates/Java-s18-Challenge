package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.dao.CategoryRepository;
import com.JavaSpringRestAPI.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(updatedCategory.getName());
            return categoryRepository.save(category);
        }
        return null;
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
