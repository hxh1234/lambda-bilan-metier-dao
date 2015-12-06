package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Utilisateur;


public interface IUtilisateurMetier {
	
		//Les collaborateurs d'un Manager RH
		public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH);
		
		//Les collaborateurs intervenants dans un Projet
		public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet);
	
		//Les collaborateur qui en pas des projets
		public List<Collaborateur> getAllCollaborateurWithoutProject();
		
		//Les collaborateur qui en pas des objectifs
		public List<Collaborateur> getAllCollaborateurWithoutObjectif();
		
	    ////CRUD des utilisateurs:
		
		public void addUtilisateur(Utilisateur utilisateur);
		public void updateUtilisateur(Utilisateur utilisateur);
		public void deleteUtilisateur(Long id);
		public Utilisateur getUtilisateur(Long id);
		
		public List<Utilisateur> getAllUtilisateur();
		
		/*
		//Collaborateur
		public void addCollaborateur(Collaborateur collaborateur);
		public void updateCollaborateur(Collaborateur collaborateur);
		public void deleteCollaborateur(Long id);
		public void getCollaborateur(Long id);
	
		//Administrateur
		public void addAdministrateur(Administrateur administrateur);
		public void updateAdministrateur(Administrateur administrateur);
		public void deleteAdministrateur(Long id);
		public void getAdministrateur(Long id);
		
		//ManagerRH
		public void addManagerRH(ManagerRH managerRH);
		public void updateManagerRHr(ManagerRH managerRH);
		public void deleteManagerRH(Long id);
		public void getManagerRH(Long id);
	
		//Evaluateur
		public void addEvaluateur(Evaluateur evaluateur);
		public void updateEvaluateur(Evaluateur evaluateur);
		public void deleteEvaluateur(Long id);
		public void getEvaluateur(Long id); */


}
