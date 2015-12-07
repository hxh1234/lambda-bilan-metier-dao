package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Objectif;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.lambda.bilan.domain.FicheObjectifs;
import com.lambda.bilan.entities.Collaborateur;

public interface IObjectifMetier {
		
		public void addObjectif(Objectif objectif);
		public void updateObjectif(Objectif objectif);
		public void deleteObjectif(Long id);
		public Objectif getObjectif(Long id);
		public void updateObjectifs(List<Objectif> objectifs);
		
		public List<Objectif> getAllObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP);
		public List<Objectif> getAllObjectifsOfCollaborateurThisYear(Collaborateur collaborateur)throws ParseException;
		public FicheObjectifs getFicheObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP);
}
