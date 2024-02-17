package com.JavaSpringRestAPI.controller;

import com.JavaSpringRestAPI.entity.Author;
import com.JavaSpringRestAPI.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/author")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
@GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Author getAuthorById(Long id){
      return  authorService.getAuthorById(id);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }
    @PostMapping("/{authorId}/add-book/{bookId}")
    public Author addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        return authorService.addBookToAuthor(authorId, bookId);
    }
    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
        return authorService.updateAuthor(id, updatedAuthor);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
