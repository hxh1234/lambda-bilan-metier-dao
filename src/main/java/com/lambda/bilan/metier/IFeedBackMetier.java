package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import com.lambda.bilan.domain.FeedBack;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.helpers.LambdaException;

public interface IFeedBackMetier {
	
	public List<FeedBack> getAllfeedBackOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP) throws LambdaException; // *
}
