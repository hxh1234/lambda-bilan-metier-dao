package com.lambda.bilan.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lambda.bilan.dao.MesureDAO;
import com.lambda.bilan.entities.Mesure;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.helpers.PropretiesHelper;


@Transactional(rollbackFor= LambdaException.class)
@Service("Mesure")
public class MesureMetier implements IMesureMetier {

	@Autowired
	MesureDAO mesureDAO;
	
	@Override
	public void addMesure(Mesure mesure) throws LambdaException {
		try {
			mesureDAO.save(mesure);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("mesure.add.fail"));
		}
		
	}

	@Override
	public void updateMesure(Mesure mesure) throws LambdaException {
		try {
			mesureDAO.save(mesure);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("mesure.update.fail"));
		}
	}

	@Override
	public void deleteMesure(Long id) throws LambdaException {
		try {
			mesureDAO.delete(id);
		} catch (Exception e) {
			throw new LambdaException(PropretiesHelper.getText("mesure.delete.fail"));
		}
	}

}
