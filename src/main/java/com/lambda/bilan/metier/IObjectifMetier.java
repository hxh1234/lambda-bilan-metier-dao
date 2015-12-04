<<<<<<< HEAD
package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Objectif;

public interface IObjectifMetier {
	
	public List<Objectif> getAllObjectifOfCollaborateurByYear(Collaborateur collaborateur,Date dateIntervention);

}
=======
package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Objectif;

public interface IObjectifMetier {
	
	 ////CRUD des Objectifs:
	
		public void addObjectif(Objectif objectif);
		public void updateObjectif(Objectif objectif);
		public void deleteObjectif(Long id);
		public Objectif getObjectif(Long id);

}
>>>>>>> 8068d9ba146ae1e622f3601ef0b4f8ed112138cc
