package com.lambda.bilan.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lambda.bilan.dao.ProjetDAO;
import com.lambda.bilan.entities.Projet;

@Transactional
@Service("Projet")
public class ProjetMetier implements IProjetMetier {
	
	@Autowired
	private ProjetDAO projetDAO;
	
	

	@Override
	public List<Projet> getAllProjet() {
		return Lists.newArrayList(projetDAO.findAll());
	}

	@Override
	public void addProjet(Projet projet) {
		projetDAO.save(projet);
	}

	@Override
	public void updateProjet(Projet projet) {
		projetDAO.save(projet);
	}

	@Override
	public void deleteProjet(Long id) {
		projetDAO.delete(id);
	}

	@Override
	public Projet getProjet(Long id) {
		return projetDAO.findOne(id);
	}

}
