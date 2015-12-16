package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Mesure;
import com.lambda.bilan.helpers.LambdaException;

public interface IMesureMetier {

	public void addMesure(Mesure mesure)  throws LambdaException;
	public void updateMesure(Mesure mesure)  throws LambdaException;
	public void deleteMesure(Long id)  throws LambdaException;
}
