package com.lichon.PersonDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lichon.PersonDatabase.jpa.PersonJpaRepository;

@SpringBootApplication
public class PersonDatabaseApplicationJpa implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PersonDatabaseApplicationJpa.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 => {}", repository.findById(10001));
/*		logger.info("All users => {}", repository.findAll());
		logger.info("Deleting 10002 => {}", repository.deleteById(10002));
		logger.info("Insertin 10004 => {}", repository.insertPerson(new Person(10004, "Ktos nowy", "Miejsce", new Date())));
		logger.info("Updating 10003 => {}", repository.update(new Person(10003, "Asterino", "Nowy kosmos", new Date())));
*/	}
}
