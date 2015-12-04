package com.lambda.bilan.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.dao.NoteDAO;
import com.lambda.bilan.domain.FeedBack;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Note;

@Service("FeedBack")
public class FeedBackMetier implements IFeedBackMetier {

	@Autowired
	private NoteDAO noteDAO;
	@Autowired
	private InterventionDAO interventionDAO;

	@Override
	public List<FeedBack> getAllfeedBackOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP) {
		if(collaborateur==null || dateBAP==null){
			return null;
		}
		else{
			FeedBack feedBack;
			Date dateDebut = dateBAP;
			Date dateFin = datePlusYear(dateDebut);
			List<Note> notes;
			List<FeedBack> feedBacks = new ArrayList<FeedBack>();
			for(Intervention intervention : interventionDAO.findByDateFinInterventionBetweenAndCollaborateur(dateDebut, dateFin, collaborateur)){
				feedBack=new FeedBack();
				feedBack.setIntervention(intervention);
				notes = new ArrayList<Note>(noteDAO.findByIntervention(intervention));
				feedBack.setNotes(notes);

				int nbrThemeQualifies=0;
				int totalePoids=0;
				for (Note note : notes) {
					if(note.getQualification()!=null)
						nbrThemeQualifies++;
					else
						totalePoids+=note.getQualification().getPoidsQualification();
				}
				feedBack.setNbrThemeQualifies(nbrThemeQualifies);
				feedBack.setTotalePoids(totalePoids);
				feedBack.setNoteGlobale(totalePoids/nbrThemeQualifies);
				nbrThemeQualifies=0;
				totalePoids=0;

			}
			return feedBacks;
		}
	}



	/*
	 * Methode utile
	 */
	private Date datePlusYear(Date dateDebut){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateDebut);
		cal.add(Calendar.MONTH, 12);
		dateDebut = cal.getTime();
		return dateDebut;
	}

}
