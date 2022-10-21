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
        Publisher publisher = new Publisher();
        publisher.setName("Harper");
        publisher.setAddress("NY");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        authorRepository.save(eric);

        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", " 3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);



        publisherRepository.save(publisher);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        publisher.getBooks().add(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Publisher Information " + publisherRepository.count());
        System.out.println("First Spring Project Demo Successful");
        System.out.println("Publisher number of Books " + publisher.getBooks().size());
    }
}
