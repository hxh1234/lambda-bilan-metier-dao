package com.lambda.bilan.test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.aries.blueprint.proxy.Collaborator;
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

	public List<Objectif> getAllObjectifOfCollaborateurByYear() throws ParseException {

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

		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateDebut, dateFin);

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
	
	public List<Intervention> getTopIntervention(){
		return interventionDAO.findTop6ByDateFinInterventionLessThanOrderByDateFinInterventionDesc(new Date());
	}
	
	public List<Objectif> findByCollaborateurAndDateCreationObjectifBetween(){
		Collaborateur collaborateur = collaborateurDAO.findOne(2L);
		Date dateBAP =dateBAPthisYear(collaborateur);	
		System.out.println(dateBAP+"  ----  "+datePlus(dateBAP) );
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, datePlus(dateBAP));
	
	}
	
	
	
	
	/******Utile*********/
	private Date dateBAPthisYear(Collaborateur collaborateur){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString;
		Date dateBAP=null;
		
		String dateEmbauche =collaborateur.getDateEmbaucheCollaborateur().toString();
		int moisEmbauche = Integer.parseInt(dateEmbauche.split("-")[1]) ;
		Calendar datenow = Calendar.getInstance();
		int moisNow= datenow.get(Calendar.MONTH) + 1;
		int anneeNow=datenow.get(Calendar.YEAR);
		try {
			if(moisNow <moisEmbauche){
				dateInString=anneeNow-1+"-"+moisEmbauche+"-01";
				System.out.println(dateInString+"------------------");
				dateBAP = sdf.parse(dateInString);
			}
			else{
				dateInString=anneeNow+"-"+moisEmbauche+"-01";
				System.out.println(dateInString+"------------------");
				dateBAP = sdf.parse(dateInString);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateBAP;
	}
	private Date datePlus(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 11);
		date = cal.getTime();
		return date;
	}
}
