package com.springdemo.demo.repositories;

import com.springdemo.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
