/**
 * 
 */
package com.lambda.bilan.helpers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.api.client.util.DateTime;
import com.lambda.bilan.metier.IGoogleAgendaMetier;


@Component
@Scope("prototype")
public class GoogleAgendaThread extends Thread {
	
	@Autowired
	private IGoogleAgendaMetier metier;
	
	private List<String> calendarIDs;
	private String titre;
	private String description;
	private DateTime date;
	@Override
	public void run() {
		try {
			
			System.out.println(">>SENDING events START");//Debug
			
			//iterate over emails
			for(String calendarID : calendarIDs){
				//send emails
				System.out.println(">>SENDING TO:" + calendarID);
				metier.createAllDayEvent(titre, description, date, calendarID);
				System.out.println(">>SENT TO:" + calendarID);				
			}
					
			System.out.println(">>SENDING END");//Debug
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//this.destroy();
		}
	}
	public List<String> getCalendarIDs() {
		return calendarIDs;
	}
	public void setCalendarIDs(List<String> calendarIDs) {
		this.calendarIDs = calendarIDs;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}	
	
}
