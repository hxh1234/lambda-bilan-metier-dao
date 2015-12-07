package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.entities.Intervention;

@Service("Intervention")
@Transactional
public class InterventionMetier implements IInterventionMetier {

	@Autowired
	private InterventionDAO interventionDAO;
	
	
	@Override
	public void assignProjet(Intervention intervention) {
		interventionDAO.save(intervention);
	}


	@Override
	public void defineIntervention(Intervention intervention) {
		intervention.setEtatIntervention(false);
		interventionDAO.save(intervention);
	}


	@Override
	public List<Intervention> getTop6FinishedIntervention() {
		return interventionDAO.findTop6ByDateFinInterventionLessThanOrderByDateFinInterventionDesc(new Date());
	}

}
