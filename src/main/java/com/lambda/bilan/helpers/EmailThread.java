/**
 * 
 */
package com.lambda.bilan.helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmailThread {
	
	@Autowired
	private EmailSender emailSender;
	private List<String> email;
	private List<MailModel> model;
	private String template;
	
	public void run() {
		try {
			
			System.out.println(">>SENDING START");//Debug
			
			//iterate over emails
			for(int i=0; i<email.size(); i++){
				//get data
				String email = this.email.get(i);
				MailModel model = this.model.get(i);
				
				//send emails
				if(email!=null){
					System.out.println(">>SENDING TO:" + email);
					emailSender.sendMail(email, template, model);
					System.out.println(">>SENT TO:" + email);
				}
				else
					System.out.println(">> ERROR :Email vide");
				
			}
			
			System.out.println(">>SENDING END");//Debug	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(">>Error !");
		}finally{
		}
	}

	//signal email
	public void setModel(MailModel model) {
		this.model = new ArrayList<MailModel>();
		this.model.add(model);
	}

	public void setEmail(String email) {
		this.email = new ArrayList<String>();
		this.email.add(email);
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	//several emails
	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public List<MailModel> getModel() {
		return model;
	}

	public void setModel(List<MailModel> model) {
		this.model = model;
	}
	
}
