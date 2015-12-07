package com.lambda.bilan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Evaluateur;
import com.lambda.bilan.entities.Projet;


public interface ProjetDAO extends CrudRepository<Projet, Long> {
	public List<Projet> findAllByEvaluateur(Evaluateur evaluateur);
}
