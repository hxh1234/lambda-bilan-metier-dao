package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.dao.EvaluateurDAO;
import com.lambda.bilan.dao.ManagerRHDAO;
import com.lambda.bilan.dao.UtilisateurDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Evaluateur;
import com.lambda.bilan.entities.ManagerRH;
import com.lambda.bilan.entities.Utilisateur;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;

@Service
@Transactional (rollbackFor= LambdaException.class)
public class UtilisateurMetier implements IUtilisateurMetier {

	@Autowired
	private UtilisateurDAO utilisateurDao;	
	@Autowired
	private CollaborateurDAO collaborateurDAO;
	@Autowired
	private ManagerRHDAO managerRHDAO;
	@Autowired
	private EvaluateurDAO evaluateurDAO;


	@Override
	public List<Collaborateur> getAllCollaborateurOfManagerRH(Long idManagerRH)  throws LambdaException {
		try {
			return collaborateurDAO.getAllCollaborateurOfManagerRH( idManagerRH);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("collaborateur.list.load.fail"));
		}
	}

	@Override
	public List<Collaborateur> getAllCollaborateurOfProjet(Long idProjet) throws LambdaException {
		try {
			return collaborateurDAO.getAllCollaborateurOfProjet(idProjet);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("collaborateur.list.load.fail"));
		}
	}

	@Override
	public List<Collaborateur> getAllCollaborateurWithoutProject() throws LambdaException {
		try {
			return collaborateurDAO.getAllCollaborateurWithoutProject();
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("collaborateur.list.load.fail"));
		}
	}

	@Override
	public List<Collaborateur> getAllCollaborateurWithoutObjectif() throws LambdaException {
		try {
			return  collaborateurDAO.getAllCollaborateurWithoutObjectif();
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("collaborateur.list.load.fail"));
		}
	}

	@Override
	public void addUtilisateur(Utilisateur utilisateur) throws LambdaException{
		try {
			utilisateurDao.save(utilisateur);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.add.fail"));
		}

	}


	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws LambdaException {
		try {
			if(utilisateur.getIdUtilisateur()==null)
				throw new LambdaException(PropretiesHelper.getText("utilisateur.update.fail"));
			else
				utilisateurDao.save(utilisateur);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.update.fail"));
		}
	}

	@Override
	public void deleteUtilisateur(Long id)throws LambdaException {
		try {
			utilisateurDao.delete(id);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.delete.fail"));
		}
	}


	@Override
	public Utilisateur getUtilisateur(Long id)  throws LambdaException {
		try {
			return utilisateurDao.findOne(id);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.id.notfound"));
		}
	}


	@Override
	public List<Utilisateur> getAllUtilisateur()throws LambdaException {
		try {
			return Lists.newArrayList(utilisateurDao.findAll());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.list.load.fail "));
		}
	}

	@Override
	public void departCollaborateur(Long id) throws LambdaException {
		try {
			Collaborateur collaborateur = collaborateurDAO.findOne(id);
			collaborateur.setDateDepartCollaborateur(new Date());
			collaborateur.setEtatCollaborateur(false);
			collaborateurDAO.save(collaborateur);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.list.load.fail "));
		}

	}

	@Override
	public List<Collaborateur> getAllOldCollaborateur() throws LambdaException {
		try {
			return collaborateurDAO.findByEtatCollaborateur(false);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.update.fail"));
		}

	}

	@Override
	public List<ManagerRH> getAllManagerRH() throws LambdaException {
		try {
			return Lists.newArrayList(managerRHDAO.findAll());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.list.load.fail"));
		}
	}

	@Override
	public List<Evaluateur> getAllEvaluateur() throws LambdaException {
		try {
			return Lists.newArrayList(evaluateurDAO.findAll());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("utilisateur.list.load.fail"));
		}
	}

}
