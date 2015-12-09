package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.helpers.LambdaException;

public interface IInterventionMetier {
	
	public void assignProjet(Intervention intervention) throws LambdaException;
	public void defineIntervention(Intervention intervention) throws LambdaException;
	public List<Intervention> getTop6FinishedIntervention() throws LambdaException;
}
