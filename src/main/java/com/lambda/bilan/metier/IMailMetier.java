package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Utilisateur;

public interface IMailMetier {

	public void sendMailNewUtilisateur(Utilisateur utilisateur);
	public void sendMailsManagerRH();
	
}
