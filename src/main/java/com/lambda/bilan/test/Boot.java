package com.lambda.bilan.test;

import java.text.ParseException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lambda.bilan.dao.CollaborateurDAO;
import com.lambda.bilan.domain.BAP;
import com.lambda.bilan.domain.FeedBack;
import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.Evaluateur;
import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Objectif;
import com.lambda.bilan.entities.PlanFormation;
import com.lambda.bilan.entities.Projet;
import com.lambda.bilan.helpers.DateHelper;
import com.lambda.bilan.helpers.LambdaException;
import com.lambda.bilan.metier.IBAPMetier;
import com.lambda.bilan.metier.IFeedBackMetier;
import com.lambda.bilan.metier.IObjectifMetier;
import com.lambda.bilan.metier.IProjetMetier;
import com.lambda.bilan.metier.IUtilisateurMetier;
import com.lambda.bilan.metier.ProjetMetier;
import com.lambda.bilan.metier.UtilisateurMetier;

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
		IUtilisateurMetier utilisateurMetier = context.getBean(IUtilisateurMetier.class);

		//
		Test m = context.getBean(Test.class);
		IProjetMetier projetMetier =context.getBean(IProjetMetier.class);
		Collaborateur collaborateur=null;
		Evaluateur evaluateur=null;
		try {
			collaborateur=(Collaborateur) utilisateurMetier.getUtilisateur(2L);
			//System.out.println(collaborateur.getNomUtilisateur()+"    "+DateHelper.dateBAPthisYear(collaborateur));
			evaluateur=(Evaluateur) utilisateurMetier.getUtilisateur(10L);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<Projet> projets = projetMetier.getAllProjetOfCollaborateur(collaborateur);
			for (Projet projet : projets) {
				System.out.println(projet.getNomProjet());
			}
		} catch (LambdaException e) {
			System.out.println("1-*-*-*"+e.getMessage());
		} catch (Exception e) {
			System.out.println("3------"+e.getMessage());
		}
		/*for (Collaborateur collaborateur : m.getAllCollaborateurWithoutObjectif()){
			System.out.println(collaborateur.getIdUtilisateur()+"  "+collaborateur.getNomUtilisateur());
		}*/
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