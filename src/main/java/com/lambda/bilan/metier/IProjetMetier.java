package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Evaluateur;
import com.lambda.bilan.entities.Projet;

public interface IProjetMetier {
	
	public void addProjet(Projet projet );
	public void updateProjet(Projet projet );
	public void deleteProjet(Long id);
	public Projet getProjet(Long id);
	
	public List<Projet> getAllProjet();
	public List<Projet> getAllProjetOfEvaluateur(Evaluateur evaluateur);

}
