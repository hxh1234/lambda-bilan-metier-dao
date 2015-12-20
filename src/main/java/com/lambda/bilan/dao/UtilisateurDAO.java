package com.lambda.bilan.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Utilisateur;


public interface UtilisateurDAO extends CrudRepository<Utilisateur, Long> {
	
	@Modifying
    @Query("UPDATE Utilisateur u SET u.passwordUtilisateur = ?1 WHERE u.idUtilisateur = ?2")
	public void updatePassword(String newPassword, Long id);
	
	@Modifying
    @Query("UPDATE Utilisateur u SET u.idCalendrierUtilisateur = ?2 WHERE u.idUtilisateur = ?1")
	public void updateIdCalendrier(Long idUtilisateur, String idCalendrierUtilisateur);
}
