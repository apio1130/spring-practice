package com.practice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDataJpaApplication.class);

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Start Application....");

		repository.save(new Book("Java"));
		repository.save(new Book("Node"));
		repository.save(new Book("Python"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(System.out::println);

		System.out.println("\nfindById(1L)");
		repository.findById(1L).ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));

		System.out.println("\nfindByName('Node')");
		repository.findByName("Node").forEach(System.out::println);
	}

}
