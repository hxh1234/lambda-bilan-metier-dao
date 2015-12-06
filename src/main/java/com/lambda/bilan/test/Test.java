package com.lambda.bilan.test;

<<<<<<< HEAD
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.dao.ActionDAO;
import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.dao.PlanFormationDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.entities.PlanFormation;

@Service
public class Test {

	@Autowired
	InterventionDAO interventionDAO;
	@Autowired
	ObjectifDAO objectifDAO;
	@Autowired
	PlanFormationDAO formationDAO;
	@Autowired
	ActionDAO actionDAO;
	@Autowired
	CollaborateurDAO collaborateurDAO;

	public List<Intervention> findByDateFinInterventionBetweenAndCollaborateur() throws ParseException{
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2014-10-04";
		String dateInString2 = "2016-10-04";
		Date date = sdf.parse(dateInString);
		System.out.println(date);

		Date dateDebut =sdf.parse(dateInString);
		Date dateFin =sdf.parse(dateInString2);
		return interventionDAO.findByDateFinInterventionBetweenAndCollaborateur(  dateDebut, dateFin, collaborateur);
	}

	public List<Objectif> getAllObjectifOfCollaborateurByYear() {

		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		Date dateDebut =new Date();
		java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime());
		Date dateFin=new Date();
		java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());

		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, sqlDateDebut, sqlDateFin);

	}

	public List<PlanFormation> findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur() throws ParseException{

		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2014-10-04";
		String dateInString2 = "2016-10-04";
		Date date = sdf.parse(dateInString);
		System.out.println(date);

		Date dateDebut =sdf.parse(dateInString);
		Date dateFin =sdf.parse(dateInString2);
		return formationDAO.findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur(dateDebut, dateFin, collaborateur);
	}

	public void datetest(){
		Date date =collaborateurDAO.findOne(2L).getDateEmbaucheCollaborateur();

		String[] dateString =date.toString().split("-");
		Integer yearstart=Integer.parseInt(dateString[0]);
		Integer yearend=Integer.parseInt(dateString[0])+1;
		String month=dateString[1];
		while (yearstart.equals(5)) {
			String dateBAP =yearstart.toString()+"-"+month.toString()+" "+yearend.toString()+"-"+month.toString();

			System.out.println(dateBAP);
		}

	}
	
	public List<Collaborateur> findByIntervention_dateFinIntervention(){
		
		return collaborateurDAO.getAllCollaborateurWithoutProject();
	}
	public List<Collaborateur> getAllCollaborateurOfManagerRH(){
		return collaborateurDAO.getAllCollaborateurOfManagerRH(1L);
	}



=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.dao.ActionDAO;
import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.dao.PlanFormationDAO;
import com.lambda.bilan.entities.Action;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.entities.PlanFormation;

@Service
public class Test {

	@Autowired
	InterventionDAO interventionDAO;
	@Autowired
	ObjectifDAO objectifDAO;
	@Autowired
	PlanFormationDAO formationDAO;
	@Autowired
	ActionDAO actionDAO;
	
	public List<Intervention> findByDateFinInterventionBetweenAndCollaborateur(){
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		Date dateDebut =new Date();
		Date dateFin=new Date();
		return interventionDAO.findByDateFinInterventionBetweenAndCollaborateur(  dateDebut, dateFin, collaborateur);
	}
	
	public List<Objectif> getAllObjectifOfCollaborateurByYear() {
		
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		Date dateDebut =new Date();
		java.sql.Date sqlDateDebut = new java.sql.Date(dateDebut.getTime());
		Date dateFin=new Date();
		java.sql.Date sqlDateFin = new java.sql.Date(dateFin.getTime());
		
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, sqlDateDebut, sqlDateFin);

	}
	
	public List<PlanFormation> findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur() throws ParseException{
		
		Collaborateur collaborateur=new Collaborateur();
		collaborateur.setIdUtilisateur(2L);
		collaborateur.setAdresseUtilisateur("qfsdgrd");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm");
		String dateInString = "2014-10-04";
		String dateInString2 = "2016-10-04";
		Date date = sdf.parse(dateInString);
		System.out.println(date);
		
		Date dateDebut =sdf.parse(dateInString);
		Date dateFin =sdf.parse(dateInString2);
		return formationDAO.findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur(dateDebut, dateFin, collaborateur);
	}
	public List<Action> findByDateAction() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm");
		String dateInString = "2014-12-05";
		Date date = sdf.parse(dateInString);
		return actionDAO.findByDateAction(date);
	}
	
>>>>>>> branch 'master' of https://github.com/hxh1234/lambda-bilan-metier-dao.git
}
