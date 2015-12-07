package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Intervention;

public interface IInterventionMetier {
	
	public void assignProjet(Intervention intervention);
	public void defineIntervention(Intervention intervention);
	public List<Intervention> getTop6FinishedIntervention();
}
