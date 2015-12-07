
package com.lambda.bilan.metier;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.domain.FicheObjectifs;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Mesure;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.helpers.DateHelper;


@Transactional
@Service("Objectif")
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
	public void updateObjectifs(List<Objectif> objectifs){
		objectifDAO.save(objectifs);
	}
	
	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) {
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, DateHelper.datePlus11Month(dateBAP));
	}
	
	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurThisYear(Collaborateur collaborateur) throws ParseException {
		Date dateBAP =DateHelper.dateBAPthisYear(collaborateur);	
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, DateHelper.datePlus11Month(dateBAP));
	}
	
	@Override
	public FicheObjectifs getFicheObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP){
		List<Objectif> objectifs =objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, DateHelper.datePlus11Month(dateBAP));
		long noteFinal=0;
		for (Objectif objectif : objectifs) {
			for (Mesure mesure : objectif.getMesures()) {
				noteFinal+=mesure.getResultatMesure();
			}
		}	
		return new FicheObjectifs(objectifs, noteFinal);
	}
	
	





}
