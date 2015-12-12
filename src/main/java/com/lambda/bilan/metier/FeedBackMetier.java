package com.lambda.bilan.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.InterventionDAO;
import com.lambda.bilan.dao.NoteDAO;
import com.lambda.bilan.domain.FeedBack;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Note;
import com.lambda.bilan.helpers.DateHelper;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;

@Service("FeedBack")
@Transactional(rollbackFor= LambdaException.class)
public class FeedBackMetier implements IFeedBackMetier {

	@Autowired
	private InterventionDAO interventionDAO;
	@Autowired
	private NoteDAO noteDAO;

	@Override
	public List<FeedBack> getAllfeedBackOfCollaborateurByYear(Collaborateur collaborateur, Date dateBAP)  throws LambdaException {
		try {
			FeedBack feedBack;
			Date dateDebut = DateHelper.dateSubtractYear(dateBAP);
			Date dateFin = dateBAP;
			List<Note> notes;
			List<FeedBack> feedBacks = new ArrayList<FeedBack>();
			for(Intervention intervention : interventionDAO.findByDateFinInterventionBetweenAndCollaborateur(dateDebut, dateFin, collaborateur)){
				feedBack=new FeedBack();
				notes =new ArrayList<Note>();
				feedBack.setIntervention(intervention);
				notes = intervention.getNotes();
				int nbrThemeQualifies=0;
				int totalePoids=0;
				for (Note note : notes) {
					if(note.getQualification()!=null){
						nbrThemeQualifies++;
						totalePoids+=note.getQualification().getPoidsQualification();
					}						
				}
				feedBack.setNbrThemeQualifies(nbrThemeQualifies);
				feedBack.setTotalePoids(totalePoids);
				feedBacks.add(feedBack);
				if(nbrThemeQualifies==0)
					feedBack.setNoteGlobale(0);
				else
				feedBack.setNoteGlobale(totalePoids/nbrThemeQualifies);
				nbrThemeQualifies=0;
				totalePoids=0;
			}
			return feedBacks;

		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("feedback.list.empty"));
		}
	}

	@Override
	public void addFeedBack(FeedBack feedBack) throws LambdaException {
		try {
			noteDAO.save(feedBack.getIntervention().getNotes());
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("feedback.add.fail"));
		}	
	}

}
