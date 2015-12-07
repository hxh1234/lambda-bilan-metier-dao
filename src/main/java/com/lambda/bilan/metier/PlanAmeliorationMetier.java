package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.ActionDAO;
import com.lambda.bilan.dao.PlanFormationDAO;
import com.lambda.bilan.domain.PlanAmelioration;
import com.lambda.bilan.entities.Action;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.PlanFormation;
import com.lambda.bilan.helpers.DateHelper;

@Service
@Transactional
public class PlanAmeliorationMetier implements IPlanAmeliorationMetier {

	@Autowired
	private PlanFormationDAO planFormationDAO;
	@Autowired
	private ActionDAO actionDAO ;


	@Override
	public PlanAmelioration getPlanAmeliorationOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) {
		List<PlanFormation> planFormations; 
		List<Action> actions;
		planFormations=planFormationDAO.findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur(dateBAP, DateHelper.datePlus11Month(dateBAP), collaborateur);
		actions=actionDAO.findByDateActionBetweenAndCollaborateur(dateBAP, DateHelper.datePlus11Month(dateBAP), collaborateur);	
		return new PlanAmelioration(planFormations, actions);
	}

	@Override
	public void addPlanAmelioration(PlanAmelioration planAmelioration) {
		planFormationDAO.save(planAmelioration.getPlanFormations());
		actionDAO.save(planAmelioration.getActions());
	}

}
