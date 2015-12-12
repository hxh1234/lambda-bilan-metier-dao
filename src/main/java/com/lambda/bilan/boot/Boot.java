package com.lambda.bilan.boot;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.api.client.util.DateTime;
import com.lambda.bilan.helpers.DateHelper;
import com.lambda.bilan.helpers.EmailThread;
import com.lambda.bilan.helpers.GoogleAgendaThread;
import com.lambda.bilan.helpers.MailModel;
import com.lambda.bilan.metier.GoogleAgendaMetier;




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
    	
    /*	EmailThread metier = SpringApplication.run(Boot.class, args).getBean(EmailThread.class);
    	try {
    		MailModel model = new MailModel();
    		model.addModel("Fene al3awd");
			metier.setModel(model);
			metier.setEmail("anas.masaaf@gmail.com");
			metier.setTemplate("template/collaborateur-new-created-template.vm");
			metier.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	
    }
}
