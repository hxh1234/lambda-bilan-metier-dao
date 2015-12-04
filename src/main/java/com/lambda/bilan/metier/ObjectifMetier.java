
package com.lambda.bilan.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.entities.Collaborateur;
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
	
	@Override
	public List<Objectif> getAllObjectifOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) {
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, datePlus(dateBAP));
	}
	
	
	
	/*
	 * Methode utile
	 */
	private Date datePlus(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 11);
		date = cal.getTime();
		return date;
	}

}
