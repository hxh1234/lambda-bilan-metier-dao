package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.domain.BAP;
import com.lambda.bilan.entities.Collaborateur;

public interface IBAPMetier {
	
	public List<BAP> getAllBAPOfCollaborateur(Collaborateur collaborateur);

}
