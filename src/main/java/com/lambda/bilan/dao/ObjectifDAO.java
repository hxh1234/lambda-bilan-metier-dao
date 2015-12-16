package com.lambda.bilan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Objectif;


public interface ObjectifDAO extends CrudRepository<Objectif, Long> {
	
	public List<Objectif> findByCollaborateurAndDateCreationObjectifBetween(Collaborateur collaborateur, Date dateDebut,Date dateFin);
	
	
	@Query("select o from Objectif o where o.statutObjectif='refusé' and o.collaborateur in (select c from Collaborateur c where month(c.dateEmbaucheCollaborateur) = month(current_date()) and c.idManagerRH = ?1)")  
	public List<Objectif> getAllObjectifsRefusFromCollaborateurOfManagerRH(Long id);
}
