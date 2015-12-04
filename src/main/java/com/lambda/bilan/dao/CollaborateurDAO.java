package com.lambda.bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.lambda.bilan.entities.Collaborateur;



public interface CollaborateurDAO extends CrudRepository<Collaborateur, Long> {
	
	@Query("select c from Collaborateur c where c.managerRH.idUtilisateur=?1")
	public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH);
	
	@Query("select i.collaborateur from Intervention i where i.projet.idProjet=?1")
	public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet);
}
