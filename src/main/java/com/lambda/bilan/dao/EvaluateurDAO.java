package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambda.bilan.entities.Evaluateur;
import com.lambda.bilan.entities.Utilisateur;


public interface EvaluateurDAO extends CrudRepository<Evaluateur, Long> {
	
}
