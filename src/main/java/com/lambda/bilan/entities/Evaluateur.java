package com.lambda.bilan.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "EVALUATEUR" )
public class Evaluateur extends Utilisateur implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	public Evaluateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
