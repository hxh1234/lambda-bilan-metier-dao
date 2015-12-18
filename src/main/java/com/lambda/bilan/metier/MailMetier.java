package com.lambda.bilan.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.helpers.EmailSender;
import com.lambda.bilan.helpers.EmailThread;
import com.lambda.bilan.helpers.MailModel;

@Service("EMails")
public class MailMetier implements IMailMetier {
	private final static String TEMPLATE_NEW_USER="template/mail-new-created-template.vm";
	private final static String TEMPLATE_ALERT_MANAGERRH="template/mail-managerRH-alert-template.vm";
	
	@Autowired
	EmailThread emailThread;
	@Autowired
	CollaborateurDAO collaborateurDAO;
	
	@Override
	public void sendMailNewCollaborateur(Collaborateur collaborateur) {		
		MailModel model = new MailModel();
		model.addModel(collaborateur.getNomUtilisateur());
		model.addModel(collaborateur.getPasswordUtilisateur());
		emailThread.setModel(model);
		emailThread.setEmail(collaborateur.getEmailUtilisateur());
		emailThread.setTemplate(TEMPLATE_NEW_USER);
		emailThread.start();
		emailThread.interrupt();
	}

	@Override
	public void sendMailsManagerRH() {
		
		List<MailModel> models = new ArrayList<MailModel>();
		List<String> mail ;
		
		int i=0;
		for(Collaborateur collaborateur : collaborateurDAO.getAllCollaborateurBAP()){
			models.get(i).addModel(collaborateur.getManagerRH().getNomUtilisateur());
			models.get(i).addModel(Calendar.getInstance().getTime().toString());
			models.get(i).addModel(collaborateur.getManagerRH().getNomUtilisateur());
			i++;
		}
		
		//model.addModel(collaborateur.getNomUtilisateur());
		//model.addModel(collaborateur.getPasswordUtilisateur());
		emailThread.setModel(models);
		//emailThread.setEmail(collaborateur.getEmailUtilisateur());
		emailThread.setTemplate(TEMPLATE_ALERT_MANAGERRH);
		emailThread.start();
		emailThread.interrupt();

	}

}
