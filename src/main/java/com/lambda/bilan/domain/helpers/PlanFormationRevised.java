package com.lambda.bilan.domain.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.entities.PlanFormation;

public class PlanFormationRevised {

	private Integer dureePlanFormation;
	private String moyensPlanFormation;
	private List<Map<String, Object>> objectifs;

	public PlanFormationRevised(PlanFormation planFormation) {
		if(planFormation!=null){
			this.dureePlanFormation=planFormation.getDureePlanFormation();
			this.moyensPlanFormation=planFormation.getMoyensPlanFormation();
			for(Objectif objectif : planFormation.getObjectifs()){
				objectifs.add(getMapForObjectif(objectif));
			}
		}
	}

	private Map<String, Object> getMapForObjectif(Objectif objectif){
		if(objectif==null)
			return null;

		Map<String, Object> hash = new HashMap<String, Object>();		
		hash.put("idObjectif", objectif.getIdObjectif());
		hash.put("dateCreationObjectif", objectif.getDateCreationObjectif());
		hash.put("nomObjectif", objectif.getNomObjectif());
		hash.put("descriptifObjectif", objectif.getDescriptifObjectif());
		hash.put("statutObjectif", objectif.getStatutObjectif());
		return hash;
	}

	public Integer getDureePlanFormation() {
		return dureePlanFormation;
	}
	public String getMoyensPlanFormation() {
		return moyensPlanFormation;
	}
	public List<Map<String, Object>> getObjectifs() {
		return objectifs;
	}






}
