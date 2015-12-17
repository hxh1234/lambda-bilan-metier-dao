package com.lambda.bilan.boot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.api.client.util.DateTime;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.helpers.DateHelper;
import com.lambda.bilan.helpers.EmailThread;
import com.lambda.bilan.helpers.GoogleAgendaThread;
import com.lambda.bilan.helpers.MailModel;
import com.lambda.bilan.metier.GoogleAgendaMetier;
import com.lambda.bilan.metier.MailMetier;




@EnableJpaRepositories(basePackages = {"com.lambda.bilan.dao"})
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.lambda.bilan" })
@EntityScan(basePackages = {"com.lambda.bilan.entities"})
@EnableTransactionManagement
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
		/*GoogleAgendaThread metier = SpringApplication.run(Boot.class, args).getBean(GoogleAgendaThread.class);
    	List<String> list = new ArrayList<String>();
    	list.add("lambda.bilan@gmail.com");
    	metier.setCalendarIDs(list);

    	metier.setDate(DateHelper.getCurrentDate());
    	metier.setTitre("massira335");
    	metier.setDescription("ok wakha33");
    	metier.start();*/
		/*	GoogleAgendaMetier g = SpringApplication.run(Boot.class, args).getBean(GoogleAgendaMetier.class);
    	    	try {
			System.out.println(g.checkAuthorityToWrite("elgh.jaouad@gmail.com"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
/*
		SpringApplication app = new SpringApplication(Boot.class);
		app.setLogStartupInfo(false);
		// on la lance
		ConfigurableApplicationContext context = app.run(args);
		try {
			EmailThread metier = context.getBean(EmailThread.class);
			MailMetier mailMetier = context.getBean(MailMetier.class);
			Collaborateur collaborateur = new Collaborateur();
			collaborateur.setEmailUtilisateur("anas.masaaf@gmail.com");
			collaborateur.setNomUtilisateur("MAsaaf");
			collaborateur.setPasswordUtilisateur("passssA123");
			
			mailMetier.sendMailNewCollaborateur(collaborateur);
			
			MailModel model = new MailModel();
			model.addModel(collaborateur.getNomUtilisateur());
			model.addModel(collaborateur.getPasswordUtilisateur());
			metier.setModel(model);
			metier.setEmail(collaborateur.getEmailUtilisateur());
			metier.setTemplate("template/mail-new-created-template.vm");
			metier.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
}
