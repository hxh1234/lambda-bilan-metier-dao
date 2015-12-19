package com.lambda.bilan.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Utilisateur;
import com.lambda.bilan.helpers.EmailThread;
import com.lambda.bilan.helpers.MailModel;

@Component
@Scope("prototype")
public class MailMetier implements IMailMetier {
	private final static String TEMPLATE_NEW_USER="template/mail-new-created-template.vm";
	private final static String TEMPLATE_ALERT_MANAGERRH="template/mail-managerRH-alert-template.vm";

	@Autowired
	EmailThread emailThread;
	@Autowired
	CollaborateurDAO collaborateurDAO;

	@Override
	public void sendMailNewUtilisateur(Utilisateur utilisateur) {		
		MailModel model = new MailModel();
		model.addModel(utilisateur.getNomUtilisateur());
		model.addModel(utilisateur.getPasswordUtilisateur());
		emailThread.setModel(model);
		emailThread.setEmail(utilisateur.getEmailUtilisateur());
		emailThread.setTemplate(TEMPLATE_NEW_USER);
		emailThread.run();
	}

	@Override
	public void sendMailsManagerRH() {

		List<MailModel> models = new ArrayList<MailModel>();
		List<String> mails =new ArrayList<String>();

		boolean etat=false;
		MailModel mailModel;
		int i=0,j=0;
		for(Collaborateur collaborateur : collaborateurDAO.getAllCollaborateurBAP()){
			if(j==0){
				mailModel = new MailModel();
				mailModel.addModel(collaborateur.getManagerRH().getIdUtilisateur().toString());
				mailModel.addModel(collaborateur.getManagerRH().getNomUtilisateur());
				mailModel.addModel(Calendar.getInstance().getTime().toString());
				mailModel.addModel(collaborateur.getNomUtilisateur()+" "+collaborateur.getPrenomUtilisateur()+"  ID: #"+collaborateur.getIdUtilisateur());
				models.add(mailModel);
				mails.add(collaborateur.getManagerRH().getEmailUtilisateur());
			}
			do {
				if(models.get(i).getModels().get(0).equals(collaborateur.getManagerRH().getIdUtilisateur().toString())){
					models.get(i).getModels().set(3, models.get(i).getModels().get(3)+"<br/>"+collaborateur.getNomUtilisateur()+" "+collaborateur.getPrenomUtilisateur()+"  ID: #"+collaborateur.getIdUtilisateur());
					etat=true;
				}else{
					i++;
					mailModel = new MailModel();
					mailModel.addModel(collaborateur.getManagerRH().getIdUtilisateur().toString());
					mailModel.addModel(collaborateur.getManagerRH().getNomUtilisateur());
					mailModel.addModel(Calendar.getInstance().getTime().toString());
					mailModel.addModel(collaborateur.getNomUtilisateur()+" "+collaborateur.getPrenomUtilisateur()+"  ID: #"+collaborateur.getIdUtilisateur());
					models.add(mailModel);
					mails.add(collaborateur.getManagerRH().getEmailUtilisateur());
				}
			} while (etat==false);
			j=1;
		}
		
		emailThread.setModel(models);
		emailThread.setEmail(mails);
		emailThread.setTemplate(TEMPLATE_ALERT_MANAGERRH);
		emailThread.run();

	}

}
