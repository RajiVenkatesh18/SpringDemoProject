package com.springdemo.demo.repositories;

import com.springdemo.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

import java.util.concurrent.Flow;

public interface PublisherRepository extends CrudRepository<Flow.Publisher, Long> {
}
