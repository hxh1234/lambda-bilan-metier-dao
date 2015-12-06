package com.lambda.bilan.metier;

import java.util.Date;

import com.lambda.bilan.domain.PlanAmelioration;
import com.lambda.bilan.entities.Collaborateur;

public interface IPlanAmeliorationMetier {
	
	public PlanAmelioration getPlanAmeliorationOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP);
	public void addPlanAmelioration(PlanAmelioration planAmelioration);


}
