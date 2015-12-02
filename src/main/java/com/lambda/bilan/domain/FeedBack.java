package com.lambda.bilan.domain;

import java.util.List;

import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Note;

public class FeedBack {
	
	private List<Note> notes;
	private Intervention intervention;
	private Integer nbrThemeQualifies;
	private Integer totalePoids;
	private long noteGlobale;
	public List<Note> getNotes() {
		return notes;
	}
	
	public FeedBack(List<Note> notes, Intervention intervention, Integer nbrThemeQualifies, Integer totalePoids,
			long noteGlobale) {
		super();
		this.notes = notes;
		this.intervention = intervention;
		this.nbrThemeQualifies = nbrThemeQualifies;
		this.totalePoids = totalePoids;
		this.noteGlobale = noteGlobale;
	}


	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	public Integer getNbrThemeQualifies() {
		return nbrThemeQualifies;
	}
	public void setNbrThemeQualifies(Integer nbrThemeQualifies) {
		this.nbrThemeQualifies = nbrThemeQualifies;
	}
	public Integer getTotalePoids() {
		return totalePoids;
	}
	public void setTotalePoids(Integer totalePoids) {
		this.totalePoids = totalePoids;
	}
	public long getNoteGlobale() {
		return noteGlobale;
	}
	public void setNoteGlobale(long noteGlobale) {
		this.noteGlobale = noteGlobale;
	}


	
}
