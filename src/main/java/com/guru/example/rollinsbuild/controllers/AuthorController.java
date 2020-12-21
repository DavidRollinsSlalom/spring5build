package com.guru.example.rollinsbuild.controllers;

import com.guru.example.rollinsbuild.repositories.AuthorRepository;
import com.guru.example.rollinsbuild.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }


}
