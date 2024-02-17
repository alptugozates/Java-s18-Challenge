package com.JavaSpringRestAPI.service;

import com.JavaSpringRestAPI.dao.AuthorRepository;
import com.JavaSpringRestAPI.dao.BookRepository;
import com.JavaSpringRestAPI.entity.Author;
import com.JavaSpringRestAPI.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
    @Service
    public class AuthorServiceImpl implements AuthorService {
        private final AuthorRepository authorRepository;
        private final BookRepository bookRepository;

        @Autowired
        public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
            this.authorRepository = authorRepository;
            this.bookRepository = bookRepository;
        }

        @Override
        public List<Author> getAllAuthors() {
            return authorRepository.findAll();
        }

        @Override
        public Author getAuthorById(Long id) {
            Optional<Author> optionalAuthor = authorRepository.findById(id);
            return optionalAuthor.orElse(null);
        }

        @Override
        public Author addAuthor(Author author) {
           return authorRepository.save(author);
        }

        @Override
        public Author addBookToAuthor(Long authorId, Long bookId) {
            Author author = authorRepository.findById(authorId).orElse(null);
            Book book = bookRepository.findById(bookId).orElse(null);
            if (author != null && book != null) {
                author.getBooks().add(book);
                return authorRepository.save(author);
            }
            return null;
        }

        @Override
        public Author updateAuthor(Long authorId, Author updatedAuthor) {
            Optional<Author> optionalExistingAuthor = authorRepository.findById(authorId);

            if (optionalExistingAuthor.isPresent()) {
                Author existingAuthor = optionalExistingAuthor.get();
                // Update the fields of existingAuthor with the values from updatedAuthor
                existingAuthor.setFirstName(updatedAuthor.getFirstName());
                existingAuthor.setLastName(updatedAuthor.getLastName());
               return authorRepository.save(existingAuthor);
            } else {
               return null;
            }
        }

        @Override
        public void deleteAuthor(Long id) {
            authorRepository.deleteById(id);
        }
}
