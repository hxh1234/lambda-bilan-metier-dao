package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Utilisateur;


public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long> {
	
}
