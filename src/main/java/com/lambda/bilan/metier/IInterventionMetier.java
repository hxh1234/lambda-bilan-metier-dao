package com.lambda.bilan.metier;

import java.util.Date;

import com.lambda.bilan.entities.Intervention;

public interface IInterventionMetier {
	
	public Intervention getInterventionOfCollaborateurByYear(Long IdCollaborateur,Date dateIntervention);

}
