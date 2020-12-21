package com.guru.example.rollinsbuild.repositories;

import com.guru.example.rollinsbuild.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
