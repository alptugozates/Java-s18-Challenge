package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    void saveBookWithCategory(Long categoryId, Book book);

    void saveBookByAuthor(Long categoryId, Long authorId, Book book);

    void updateBook(Long id, Book updatedBook);

    void deleteBook(Long id);

}
