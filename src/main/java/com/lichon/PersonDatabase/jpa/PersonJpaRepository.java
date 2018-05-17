package com.lichon.PersonDatabase.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lichon.PersonDatabase.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManger;
	
	public Person findById(int id) {
		return entityManger.find(Person.class, id);
	}
}
