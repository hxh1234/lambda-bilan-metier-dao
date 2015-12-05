package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.domain.BAP;

@Transactional
@Service("BAPMetier")
public class BAPMetier implements IBAPMetier {

	@Autowired
	private CollaborateurDAO collaborateurDAO;
	
	
	@Override
	public List<BAP> getAllBAPOfCollaborateur(Long idCollaborateur) {
		Date date =collaborateurDAO.findOne(idCollaborateur).getDateEmbaucheCollaborateur();
		
		return null;
	}
	

}
