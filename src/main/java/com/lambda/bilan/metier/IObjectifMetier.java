package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Objectif;
import java.util.Date;
import java.util.List;

import com.lambda.bilan.entities.Collaborateur;

public interface IObjectifMetier {
	
	 ////CRUD des Objectifs:
	
		public void addObjectif(Objectif objectif);
		public void updateObjectif(Objectif objectif);
		public void deleteObjectif(Long id);
		public Objectif getObjectif(Long id);
		
		public List<Objectif> getAllObjectifOfCollaborateurByYear(Collaborateur collaborateur,Date dateIntervention);

}
