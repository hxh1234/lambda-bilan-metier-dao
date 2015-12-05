package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Projet;


public interface ProjetDAO extends CrudRepository<Projet, Long> {
	
}
