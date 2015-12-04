package com.lambda.bilan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.lambda.bilan.entities.Collaborateur;

import com.lambda.bilan.entities.Objectif;


public interface ObjectifDAO extends CrudRepository<Objectif, Long> {
	
	public List<Objectif> findByCollaborateurAndDateCreationObjectifBetween(Collaborateur collaborateur, Date dateDebut,Date dateFin);
	
}
