package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambda.bilan.entities.Utilisateur;


public interface ProjetDAO extends CrudRepository<Utilisateur, Long> {
	
}
