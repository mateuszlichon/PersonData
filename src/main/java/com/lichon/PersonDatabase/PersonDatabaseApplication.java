package com.lichon.PersonDatabase;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lichon.PersonDatabase.entity.Person;
import com.lichon.PersonDatabase.jdbc.PersonJdbcDao;

@SpringBootApplication
public class PersonDatabaseApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(PersonDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users => {}", dao.findAll());
		logger.info("User id 10001 => {}", dao.findById(10001));
		logger.info("Deleting 10002 => {}", dao.deleteById(10002));
		logger.info("Insertin 10004 => {}", dao.insertPerson(new Person(10004, "Ktos nowy", "Miejsce", new Date())));
		logger.info("Updating 10003 => {}", dao.update(new Person(10003, "Asterino", "Nowy kosmos", new Date())));
	}
}
