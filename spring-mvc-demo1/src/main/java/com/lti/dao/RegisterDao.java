package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Register;

@Repository  //represent dao class
public class RegisterDao {
@PersistenceContext
private EntityManager entityManager;
public void add(Register register) {
	entityManager.persist(register);
}
}
