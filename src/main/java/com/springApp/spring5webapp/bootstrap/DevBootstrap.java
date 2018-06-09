package com.springApp.spring5webapp.bootstrap;

import com.springApp.spring5webapp.model.Author;
import com.springApp.spring5webapp.model.Book;
import com.springApp.spring5webapp.model.Publisher;
import com.springApp.spring5webapp.repositories.AuthorRepository;
import com.springApp.spring5webapp.repositories.BookRepository;
import com.springApp.spring5webapp.repositories.PublisherRepository;
import javafx.application.Application;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initDataBase();
    }
    private void initDataBase(){

        System.out.print("Initialise Data Base ----------------------->  ");

        Publisher publisher = new Publisher();
        publisher.setName("Alice");

        publisherRepository.save(publisher);

        // Mohamed
        Author mohamed = new Author("Mohamed","Jarray");
        Book book_mohamed = new Book("Test Driven Development","1234",publisher);
        mohamed.getBooks().add(book_mohamed);
        book_mohamed.getAuthors().add(mohamed);

        authorRepository.save(mohamed);
        bookRepository.save(book_mohamed);

        // Eric
        Author eric = new Author("Eric","Hard");
        Book book_eric = new Book("Spring Boot 2","100",publisher);
        eric.getBooks().add(book_eric);

        authorRepository.save(eric);
        bookRepository.save(book_eric);
    }
}
