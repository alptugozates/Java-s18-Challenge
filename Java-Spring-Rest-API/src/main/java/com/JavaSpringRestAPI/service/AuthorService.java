package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.entity.Author;
import com.JavaSpringRestAPI.entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    Author addAuthor(Author author);

    Author addBookToAuthor(Long authorId, Long bookId);

    Author updateAuthor(Long authorId, Author updatedAuthor);

    void deleteAuthor(Long id);
}
