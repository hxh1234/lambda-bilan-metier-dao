package com.lambda.bilan.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.entities.Objectif;

@Transactional
@Service
public class ObjectifMetier implements IObjectifMetier{

	@Autowired
	private ObjectifDAO objectifDAO;
	
	@Override
	public void addObjectif(Objectif objectif) {
		objectifDAO.save(objectif);		
	}

	@Override
	public void updateObjectif(Objectif objectif) {
		objectifDAO.save(objectif);		
	}

	@Override
	public void deleteObjectif(Long id) {
		objectifDAO.delete(id);	
	}

	@Override
	public Objectif getObjectif(Long id) {
			return objectifDAO.findOne(id);
	}

}
