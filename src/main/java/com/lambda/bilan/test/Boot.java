package com.lambda.bilan.test;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.entities.PlanFormation;

@EnableJpaRepositories(basePackages = {"com.lambda.bilan.dao"})
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.lambda.bilan" })
@EntityScan(basePackages = {"com.lambda.bilan.entities"})
@EnableTransactionManagement
public class Boot {

	public static void main(String[] args) throws ParseException {
		//SpringApplication.run(Boot.class, args);
		// on prépare la configuration
		SpringApplication app = new SpringApplication(Boot.class);
		app.setLogStartupInfo(false);
		// on la lance
		ConfigurableApplicationContext context = app.run(args);
		// métier
		//ManagerRHDAO managerRHDAO = context.getBean(ManagerRHDAO.class);

		//
		Test m = context.getBean(Test.class);
		for (Objectif objectif:   m.findByCollaborateurAndDateCreationObjectifBetween()) {
			System.out.println(objectif.getIdObjectif()+"  "+objectif.getDateCreationObjectif()+"   "+objectif.getNomObjectif());
		}
		//m.datetest();
		/*System.out.println(m.findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur());
		for (PlanFormation planFormation : m.findByObjectifs_dateCreationObjectifBetweenAndObjectifs_Collaborateur()) {
			System.out.println(planFormation.getIdPlanFormation());
		}
		 */
		//System.out.println(m.findByDateFinInterventionBetweenAndCollaborateur().get(0).getNomIntervention());
		/*for(Intervention intervention :m.findByDateFinInterventionBetweenAndCollaborateur()){
			System.out.println(intervention.getNomIntervention());
		}*/
		//for (Action action:m.findByDateAction())
			//System.out.println(action.getMessageAction());

	}
}