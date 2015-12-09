package com.lambda.bilan.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.helpers.LambdaException;


public interface CollaborateurDAO extends CrudRepository<Collaborateur, Long> {
	
	@Query("select c from Collaborateur c where c.managerRH.idUtilisateur=?1 and c.etatCollaborateur=TRUE")
	public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH) throws LambdaException;
	
	@Query("select i.collaborateur from Intervention i where i.projet.idProjet=?1")
	public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet) throws LambdaException;
	
	@Query("select c from Collaborateur c where c not in (select i.collaborateur from Intervention i where i.dateFinIntervention > current_date())")
	public List<Collaborateur> getAllCollaborateurWithoutProject() throws LambdaException;
	
	@Query("select c from Collaborateur c where c not in (select o.collaborateur from Objectif o)")
	public List<Collaborateur> getAllCollaborateurWithoutObjectif() throws LambdaException;
}
