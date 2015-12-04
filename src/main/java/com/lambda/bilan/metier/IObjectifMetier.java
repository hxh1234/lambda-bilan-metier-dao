package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Objectif;

public interface IObjectifMetier {
	
	public List<Objectif> getAllObjectifOfCollaborateurByYear(Collaborateur collaborateur,Date dateIntervention);

}
