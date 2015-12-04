package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Objectif;

public interface IObjectifMetier {
	
	 ////CRUD des Objectifs:
	
		public void addObjectif(Objectif objectif);
		public void updateObjectif(Objectif objectif);
		public void deleteObjectif(Long id);
		public Objectif getObjectif(Long id);

}
