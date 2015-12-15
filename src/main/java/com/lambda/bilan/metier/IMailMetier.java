package com.lambda.bilan.metier;

import com.lambda.bilan.entities.Collaborateur;

public interface IMailMetier {

	public void sendMailNewCollaborateur(Collaborateur collaborateur);
	public void sendMailManagerRH();
	
}
