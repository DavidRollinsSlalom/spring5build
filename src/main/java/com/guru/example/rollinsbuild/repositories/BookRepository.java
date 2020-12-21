package com.guru.example.rollinsbuild.repositories;

import com.guru.example.rollinsbuild.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
