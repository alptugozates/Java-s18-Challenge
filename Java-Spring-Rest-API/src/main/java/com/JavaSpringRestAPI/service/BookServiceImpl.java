package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.dao.AuthorRepository;
import com.JavaSpringRestAPI.dao.BookRepository;
import com.JavaSpringRestAPI.dao.CategoryRepository;
import com.JavaSpringRestAPI.entity.Author;
import com.JavaSpringRestAPI.entity.Book;
import com.JavaSpringRestAPI.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public void saveBookWithCategory(Long categoryId, Book book) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            book.setCategory(category);
            bookRepository.save(book);
        } else {
            // Handle the case when the category is not found
        }
    }

    @Override
    public void saveBookByAuthor(Long categoryId, Long authorId, Book book) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if (optionalCategory.isPresent() && optionalAuthor.isPresent()) {
            Category category = optionalCategory.get();
            Author author = optionalAuthor.get();

            book.setCategory(category);
            book.setAuthor(author);
            bookRepository.save(book);
        } else {
            // Handle the case when the category or author is not found
        }
    }

    @Override
    public void updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalExistingBook = bookRepository.findById(id);

        if (optionalExistingBook.isPresent()) {
            Book existingBook = optionalExistingBook.get();
            existingBook.setName(updatedBook.getName());
            bookRepository.save(existingBook);
        } else {

        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
