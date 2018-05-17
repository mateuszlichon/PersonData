package com.lichon.PersonDatabase.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lichon.PersonDatabase.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE) VALUES (?, ?, ?, ?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbcTemplate.update("UPDATE PERSON SET NAME = ?, LOCATION = ?, BIRTH_DATE = ? WHERE ID = ?",
				new Object[] { person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
}
