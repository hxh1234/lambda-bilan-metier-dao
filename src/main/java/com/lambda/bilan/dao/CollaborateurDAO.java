package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Collaborateur;


public interface CollaborateurDAO extends CrudRepository<Collaborateur, Long> {
	
}
