package com.lambda.bilan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;

public interface InterventionDAO extends CrudRepository<Intervention, Long> {
	
	public List<Intervention> findByDateFinInterventionBetweenAndCollaborateur( Date dateDebut,Date dateFin,Collaborateur collaborateur) throws Exception;
	public List<Intervention> findTop6ByDateFinInterventionLessThanOrderByDateFinInterventionDesc(Date date) throws Exception;
}
