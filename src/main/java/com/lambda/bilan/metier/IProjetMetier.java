package com.lambda.bilan.metier;

import java.util.List;

import com.lambda.bilan.entities.Projet;

public interface IProjetMetier {
	
	public void addProjet(Projet projet );
	public void updateProjet(Projet projet );
	public void deleteProjet(Long id);
	public Projet getProjet(Long id);
	
	public List<Projet> getAllProjet();

}
