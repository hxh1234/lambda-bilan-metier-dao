
package com.lambda.bilan.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.api.client.util.Lists;
import com.lambda.bilan.dao.CategorieDAO;
import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.domain.FicheObjectifs;
import com.lambda.bilan.entities.Categorie;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Mesure;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.helpers.DateHelper;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;
import com.lambda.bilan.helpers.StatutObjectif;


@Transactional(rollbackFor= LambdaException.class)
@Service("Objectif")
public class ObjectifMetier implements IObjectifMetier{

	@Autowired
	private ObjectifDAO objectifDAO;
	@Autowired
	private CategorieDAO categorieDAO;

	@Override
	public void addObjectif(List<Objectif> objectifs) throws LambdaException {
		try {
			objectifDAO.save(objectifs);	
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.add.fail"));
		}	
	}

	@Override
	public void updateObjectif(Objectif objectif) throws LambdaException {
		try {
			objectif.setStatutObjectif(StatutObjectif.VALIDER.toString());
			objectif.setDateCreationObjectif(new Date());
			objectifDAO.updateObjectif(objectif.getIdObjectif(),objectif.getNomObjectif(), objectif.getDescriptifObjectif(), objectif.getCategorie().getIdCategorie());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.update.fail"));
		}		
	}

	@Override
	public void deleteObjectif(Long id) throws LambdaException {
		try {
			objectifDAO.delete(id);	
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.delete.fail"));
		}	
	}

	@Override
	public Objectif getObjectif(Long id) throws LambdaException {
		try {
			return objectifDAO.findOne(id);
		} catch (IllegalArgumentException  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.id.notfound"));
		}		
	}

	@Override
	public void updateObjectifs(List<Objectif> objectifs) throws LambdaException{
		try {
			objectifDAO.save(objectifs);
		} catch (Exception  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.update.fail"));
		}

	}

	@Override
	public void validerObjectif(Long id) throws LambdaException {
		try {
			objectifDAO.validerObjectif(id);
		} catch (Exception  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.update.fail"));
		}

	}

	@Override
	public void refuserObjectif(Long id) throws LambdaException {
		try {
			Objectif objectif = objectifDAO.findOne(id);
			Integer compteur = objectif.getCompteurRejet()+1;
			if (compteur>3)
				throw new LambdaException(PropretiesHelper.getText("objectif.rejet.fail"));
			else
				objectifDAO.refuserObjectif(compteur,id);
		} catch (Exception  e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.rejet.fail"));
		}
	}

	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) throws LambdaException{
		try {
			return objectifDAO.findByCollaborateurAndDateCreationObjectifBetweenAndStatutObjectif(collaborateur,DateHelper.dateSubtractYear(dateBAP) , dateBAP,StatutObjectif.VALIDER.toString());
		}catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}
	}

	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurThisYear(Collaborateur collaborateur) throws LambdaException {
		try {
			Date dateBAP =DateHelper.dateBAPthisYear(collaborateur);
			return objectifDAO.findByCollaborateurAndDateCreationObjectifBetweenAndStatutObjectif(collaborateur, DateHelper.dateSubtractYear(dateBAP), dateBAP,StatutObjectif.VALIDER.toString());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}	
	}

	@Override
	public List<Objectif> getAllObjectifsRefusFromCollaborateurOfManagerRH(Long id) throws LambdaException {
		try {
			System.out.println("hiii");
			return objectifDAO.getAllObjectifsRefusFromCollaborateurOfManagerRH(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}	
	}

	@Override
	public FicheObjectifs getFicheObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP)  throws LambdaException{
		try {
			List<Objectif> objectifs = objectifDAO.findByCollaborateurAndDateCreationObjectifBetweenAndStatutObjectif(collaborateur,  DateHelper.dateSubtractYear(dateBAP),dateBAP,StatutObjectif.VALIDER.toString());
			long noteFinal=0;
			for (Objectif objectif : objectifs) {
				for (Mesure mesure : objectif.getMesures()) {
					noteFinal+=mesure.getResultatMesure();
				}
			}	
			return new FicheObjectifs(objectifs, noteFinal);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("objectif.list.empty"));
		}
	}

	@Override
	public List<Categorie> getAllCategorie() throws LambdaException {
		try {
			return Lists.newArrayList(categorieDAO.findAll());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("categorie.list.load.fail"));
		}

	}

}
