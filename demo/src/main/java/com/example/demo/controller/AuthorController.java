package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
