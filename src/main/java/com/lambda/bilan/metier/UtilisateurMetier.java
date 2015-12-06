package com.lambda.bilan.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.dao.UtilisateurDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Utilisateur;

@Service
@Transactional
public class UtilisateurMetier implements IUtilisateurMetier {
	
	//------
	@Autowired
	private UtilisateurDAO utilisateurDao;
	
	@Autowired
	private CollaborateurDAO collaborateurDAO;
	
    //------
	@Override
	public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH) {
		return collaborateurDAO.getAllCollaborateurOfManagerRH( idManagerRH);
	}

	@Override
	public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet) {
		return collaborateurDAO.getAllCollaborateurOfProjet(idProjet);
	}
	
	@Override
	public List<Collaborateur> getAllCollaborateurWithoutProject() {
		return collaborateurDAO.getAllCollaborateurWithoutProject();
	}
	
	@Override
	public List<Collaborateur> getAllCollaborateurWithoutObjectif() {
		return collaborateurDAO.getAllCollaborateurWithoutObjectif();
	}

	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
		
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
		
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurDao.delete(id);
		
	}
	
	

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return utilisateurDao.findOne(id);
		
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		return Lists.newArrayList(utilisateurDao.findAll());
	}

	


	

}
