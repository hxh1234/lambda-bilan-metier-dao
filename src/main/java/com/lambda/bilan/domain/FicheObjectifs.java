package com.lambda.bilan.domain;

import java.util.List;

import com.lambda.bilan.entities.Objectif;

public class FicheObjectifs {

	private List<Objectif> objectifs;
	private long noteFinal;
	
	
	public FicheObjectifs(List<Objectif> objectifs, long noteFinal) {
		super();
		this.objectifs = objectifs;
		this.noteFinal = noteFinal;
	}
	
	public List<Objectif> getObjectifs() {
		return objectifs;
	}
	public void setObjectifs(List<Objectif> objectifs) {
		this.objectifs = objectifs;
	}
	public long getNoteFinal() {
		return noteFinal;
	}
	public void setNoteFinal(long noteFinal) {
		this.noteFinal = noteFinal;
	}
	
	
}
