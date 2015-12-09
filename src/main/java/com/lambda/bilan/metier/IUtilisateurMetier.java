package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Utilisateur;
import com.lambda.bilan.helpers.LambdaException;


public interface IUtilisateurMetier {
	
		//Les collaborateurs d'un Manager RH
		public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH) throws LambdaException;
		
		//Les collaborateurs intervenants dans un Projet
		public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet) throws LambdaException;
	
		//Les collaborateur qui en pas des projets
		public List<Collaborateur> getAllCollaborateurWithoutProject() throws LambdaException;
		
		//Les collaborateur qui en pas des objectifs
		public List<Collaborateur> getAllCollaborateurWithoutObjectif() throws LambdaException;
				
		public void addUtilisateur(Utilisateur utilisateur) throws LambdaException;
		public void updateUtilisateur(Utilisateur utilisateur) throws LambdaException;
		public void deleteUtilisateur(Long id) throws LambdaException;
		public Utilisateur getUtilisateur(Long id) throws LambdaException;
		public List<Utilisateur> getAllUtilisateur() throws LambdaException;

}
