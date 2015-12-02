package com.lambda.bilan.domain;

import java.util.List;

import com.lambda.bilan.domain.helpers.PlanFormationRevised;
import com.lambda.bilan.entities.Action;

public class PlanAmelioration {
	
	private List<PlanFormationRevised> planFormations; 
	private List<Action> actions;
	
	public PlanAmelioration(List<PlanFormationRevised> planFormations, List<Action> actions) {
		super();
		this.planFormations = planFormations;
		this.actions = actions;
	}

	public List<PlanFormationRevised> getPlanFormations() {
		return planFormations;
	}

	public void setPlanFormations(List<PlanFormationRevised> planFormations) {
		this.planFormations = planFormations;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	
	
	
	
	
	
}
