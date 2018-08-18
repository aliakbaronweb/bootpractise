package com.aliakbaronweb.bootpractise.bootstrap;

import com.aliakbaronweb.bootpractise.model.Author;
import com.aliakbaronweb.bootpractise.model.Book;
import com.aliakbaronweb.bootpractise.model.Publisher;
import com.aliakbaronweb.bootpractise.repositories.AuthorRepository;
import com.aliakbaronweb.bootpractise.repositories.BookRepository;
import com.aliakbaronweb.bootpractise.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;

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
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Publisher HarperPublisher = new Publisher();
        HarperPublisher.setName("Harper Collins");
        publisherRepository.save(HarperPublisher);

        //Eric
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ericBook = new Book();
        ericBook.setTitle("Domain Driven Design");
        ericBook.setIsbn("1234");
        ericBook.setPublisher(HarperPublisher);
        eric.setBooks(Collections.singleton(ericBook));
        ericBook.setAuthors(Collections.singleton(eric));

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        Publisher wroxPublisher = new Publisher();
        wroxPublisher.setName("worx");
        publisherRepository.save(wroxPublisher);

        //Rod
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jognson");

        Book rodBook = new Book();
        rodBook.setTitle("J2EE Development without EJB");
        rodBook.setIsbn("1234");
        rodBook.setPublisher(wroxPublisher);
        eric.setBooks(Collections.singleton(rodBook));
        rodBook.setAuthors(Collections.singleton(rod));

        authorRepository.save(rod);
        bookRepository.save(rodBook);
    }
}
