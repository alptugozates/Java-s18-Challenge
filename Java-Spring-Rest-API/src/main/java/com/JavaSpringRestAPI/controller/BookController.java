package com.JavaSpringRestAPI.controller;

import com.JavaSpringRestAPI.entity.Book;
import com.JavaSpringRestAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/book")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{categoryId}")
    public void saveBookWithCategory(@PathVariable Long categoryId, @RequestBody Book book) {
        bookService.saveBookWithCategory(categoryId, book);
    }

    @PostMapping("/saveByAuthor/{categoryId}/{authorId}")
    public void saveBookByAuthor(@PathVariable Long categoryId, @PathVariable Long authorId, @RequestBody Book book) {
        bookService.saveBookByAuthor(categoryId, authorId, book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        bookService.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
