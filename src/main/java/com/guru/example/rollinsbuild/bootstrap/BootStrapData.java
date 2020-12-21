package com.guru.example.rollinsbuild.bootstrap;

import com.guru.example.rollinsbuild.model.Author;
import com.guru.example.rollinsbuild.model.Book;
import com.guru.example.rollinsbuild.model.Publisher;
import com.guru.example.rollinsbuild.repositories.AuthorRepository;
import com.guru.example.rollinsbuild.repositories.BookRepository;
import com.guru.example.rollinsbuild.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Quantum Books");
        publisher.setCity("Frisco");
        publisher.setState("TX");
        publisher = publisherRepository.save(publisher);


        Author eric = new Author("Eric", "Evans");
        Book domainDrivenDesign = new Book("domain Driven Design", "131315498");

        eric.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(eric);
        publisher.getBooks().add(domainDrivenDesign);

        authorRepository.save(eric);
        bookRepository.save(domainDrivenDesign);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("J2EE Development without EJB", "23424315498");

        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        publisher.getBooks().add(noEjb);


        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);
    }
}
