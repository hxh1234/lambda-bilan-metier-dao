
package com.lambda.bilan.metier;

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
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;


@Transactional
@Service("Objectif")
public class ObjectifMetier implements IObjectifMetier{

	@Autowired
	private ObjectifDAO objectifDAO;


	@Override
	public void addObjectif(Objectif objectif) throws LambdaException {
		try {
			objectifDAO.save(objectif);	
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.add.fail"));
		}	
	}

	@Override
	public void updateObjectif(Objectif objectif) throws LambdaException {
		try {
			objectifDAO.save(objectif);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.update.fail"));
		}		
	}

	@Override
	public void deleteObjectif(Long id) throws LambdaException {
		try {
			objectifDAO.delete(id);	
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.delete.fail"));
		}	
	}

	@Override
	public Objectif getObjectif(Long id) throws LambdaException {
		try {
			return objectifDAO.findOne(id);
		} catch (IllegalArgumentException  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.id.notfound"));
		}		
	}

	@Override
	public void updateObjectifs(List<Objectif> objectifs) throws LambdaException{
		try {
			objectifDAO.save(objectifs);
		} catch (Exception  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.update.fail"));
		}

	}

	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) throws LambdaException{
		try {
			return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur,DateHelper.dateSubtractYear(dateBAP) , dateBAP);
		}catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}
	}

	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurThisYear(Collaborateur collaborateur) throws LambdaException {
		try {
			Date dateBAP =DateHelper.dateBAPthisYear(collaborateur);
			return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, DateHelper.dateSubtractYear(dateBAP), dateBAP);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}	
	}

	@Override
	public FicheObjectifs getFicheObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP)  throws LambdaException{
		try {
			List<Objectif> objectifs = objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur,  DateHelper.dateSubtractYear(dateBAP),dateBAP);
			long noteFinal=0;
			for (Objectif objectif : objectifs) {
				for (Mesure mesure : objectif.getMesures()) {
					noteFinal+=mesure.getResultatMesure();
				}
			}	
			return new FicheObjectifs(objectifs, noteFinal);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}
	}







}
