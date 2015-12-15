package com.lambda.bilan.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.helpers.EmailThread;
import com.lambda.bilan.helpers.MailModel;

//@Service("Mail")
public class MailMetier implements IMailMetier {
	private final static String TEMPLATE="template/mail-new-created-template.vm";
	
	//@Autowired
	EmailThread emailThread;
	
	@Override
	public void sendMailNewCollaborateur(Collaborateur collaborateur) {
		MailModel mailModel = new MailModel();
		mailModel.addModel(collaborateur.getNomUtilisateur());
		mailModel.addModel(collaborateur.getPasswordUtilisateur());
		emailThread.setModel(mailModel);
		emailThread.setEmail(collaborateur.getEmailUtilisateur());
		emailThread.setTemplate(TEMPLATE);
		emailThread.start();
	}

	@Override
	public void sendMailManagerRH() {
		// TODO Auto-generated method stub

	}

}
