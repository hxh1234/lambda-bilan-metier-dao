package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.domain.BAP;

public interface IBAPMetier {
	
	public List<BAP> getAllBAPOfCollaborateur(Long idCollaborateur);

}
