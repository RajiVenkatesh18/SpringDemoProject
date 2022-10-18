package com.springdemo.demo.bootstrap;

import com.springdemo.demo.domain.Author;
import com.springdemo.demo.domain.Book;
import com.springdemo.demo.domain.Publisher;
import com.springdemo.demo.repositories.AuthorRepository;
import com.springdemo.demo.repositories.BookRepository;
import com.springdemo.demo.repositories.PublisherRepository;
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

        System.out.println("Started in BootStrap");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", " 3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setName("Harper");
        publisher.setAddress("NY");

        publisherRepository.save(publisher);


        System.out.println("Started in BootStrap");
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Publisher Information " + publisherRepository.count());

    }
}
