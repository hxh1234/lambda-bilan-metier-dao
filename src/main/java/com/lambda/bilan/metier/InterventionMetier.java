package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;

@Service("Intervention")
@Transactional
public class InterventionMetier implements IInterventionMetier {

	@Autowired
	private InterventionDAO interventionDAO;


	@Override
	public void assignProjet(Intervention intervention) throws LambdaException {
		try {
			interventionDAO.save(intervention);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("intervention.add.fail"));
		}
	}

	@Override
	public void defineIntervention(Intervention intervention) throws LambdaException {
		
		try{
			Intervention intervention2 =interventionDAO.findOne(intervention.getIdIntervention());
			if(intervention2==null ){
				throw new LambdaException(PropretiesHelper.getText("intervention.update.fail"));
			} else if(intervention2.getProjet().getIdProjet().equals(intervention.getProjet().getIdProjet()) && intervention2.getCollaborateur().getIdUtilisateur().equals(intervention.getCollaborateur().getIdUtilisateur())) {
				interventionDAO.save(intervention);
			}
		} catch (IllegalArgumentException e) {
			throw new LambdaException(PropretiesHelper.getText("intervention.id.notfound"));
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("intervention.update.fail"));
		}
		
	}


	@Override
	public List<Intervention> getTop6FinishedIntervention() throws LambdaException {
		try {
			return interventionDAO.findTop6ByDateFinInterventionLessThanOrderByDateFinInterventionDesc(new Date());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("feedback.add.fail"));
		}
	}

}
