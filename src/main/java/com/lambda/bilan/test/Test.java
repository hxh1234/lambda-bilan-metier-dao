package com.lambda.bilan.test;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Objectif;

@Service
public class Test {

	@Autowired
	InterventionDAO interventionDAO;
	@Autowired
	ObjectifDAO objectifDAO;
	
	public List<Intervention> findByDateFinInterventionBetweenAndCollaborateur(){
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(28L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		Date dateDebut =new Date();
		java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime());
		Date dateFin=new Date();
		java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());
		return interventionDAO.findByDateFinInterventionBetweenAndCollaborateur(  sqlDateDebut, sqlDateFin, collaborateur);
	}
	
	public List<Objectif> getAllObjectifOfCollaborateurByYear() {
		
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(28L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		Date dateDebut =new Date();
		java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime());
		Date dateFin=new Date();
		java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());
		
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, sqlDateDebut, sqlDateFin);

	}
	
	
}
