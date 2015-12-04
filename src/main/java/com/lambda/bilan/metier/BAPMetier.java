package com.lambda.bilan.metier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.domain.BAP;
import com.lambda.bilan.entities.Collaborateur;

@Transactional
@Service("BAPMetier")
public class BAPMetier implements IBAPMetier {

	
	@Override
	public List<BAP> getAllBAPOfCollaborateur(Collaborateur collaborateur) {
		// 
		//Date 
		return null;
	}
	

}
