package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Utilisateur;


public interface InterventionDAO extends CrudRepository<Intervention, Long> {
	
}
