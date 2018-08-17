package com.aliakbaronweb.bootpractise.bootstrap;

import com.aliakbaronweb.bootpractise.model.Author;
import com.aliakbaronweb.bootpractise.model.Book;
import com.aliakbaronweb.bootpractise.repositories.AuthorRepository;
import com.aliakbaronweb.bootpractise.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ericBook = new Book();
        ericBook.setTitle("Domain Driven Design");
        ericBook.setIsbn("1234");
        ericBook.setPublisher("Harper Collins");
        eric.setBooks(Collections.singleton(ericBook));
        ericBook.setAuthors(Collections.singleton(eric));

        authorRepository.save(eric);
        bookRepository.save(ericBook);

        //Rod
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Jognson");

        Book rodBook = new Book();
        rodBook.setTitle("J2EE Development without EJB");
        rodBook.setIsbn("1234");
        rodBook.setPublisher("wrox");
        eric.setBooks(Collections.singleton(rodBook));
        rodBook.setAuthors(Collections.singleton(rod));

        authorRepository.save(rod);
        bookRepository.save(rodBook);
    }
}
