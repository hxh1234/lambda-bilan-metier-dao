
package com.lambda.bilan.metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.ObjectifDAO;
import com.lambda.bilan.domain.FicheObjectifs;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Mesure;
import com.lambda.bilan.entities.Objectif;


@Transactional
@Service("Objectif")
public class ObjectifMetier implements IObjectifMetier{

	@Autowired
	private ObjectifDAO objectifDAO;
	
	@Override
	public void addObjectif(Objectif objectif) {
		objectifDAO.save(objectif);		
	}

	@Override
	public void updateObjectif(Objectif objectif) {
		objectifDAO.save(objectif);		
	}

	@Override
	public void deleteObjectif(Long id) {
		objectifDAO.delete(id);	
	}

	@Override
	public Objectif getObjectif(Long id) {
			return objectifDAO.findOne(id);
	}
	
	@Override
	public void updateObjectifs(List<Objectif> objectifs){
		objectifDAO.save(objectifs);
	}
	
	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) {
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, datePlus(dateBAP));
	}
	
	@Override
	public List<Objectif> getAllObjectifsOfCollaborateurThisYear(Collaborateur collaborateur) {
		Date dateBAP =dateBAPthisYear(collaborateur);	
		return objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, datePlus(dateBAP));
	}
	
	@Override
	public FicheObjectifs getFicheObjectifsOfCollaborateurByYear(Collaborateur collaborateur,Date dateBAP){
		List<Objectif> objectifs =objectifDAO.findByCollaborateurAndDateCreationObjectifBetween(collaborateur, dateBAP, datePlus(dateBAP));
		long noteFinal=0;
		for (Objectif objectif : objectifs) {
			for (Mesure mesure : objectif.getMesures()) {
				noteFinal+=mesure.getResultatMesure();
			}
		}	
		return new FicheObjectifs(objectifs, noteFinal);
	}
	
	
	/*
	 * Methode utile
	 */
	private Date datePlus(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 11);
		date = cal.getTime();
		return date;
	}
	
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
				dateBAP = sdf.parse(dateInString);
			}
			else{
				dateInString=anneeNow+"-"+moisEmbauche+"-01";
				dateBAP = sdf.parse(dateInString);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateBAP;
	}



}
