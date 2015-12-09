package com.lambda.bilan.metier;

import java.io.IOException;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;

public interface IGoogleAgendaMetier {
	 public Event createAllDayEvent(String Titre,String Description,DateTime date,String CalendarID)
			    throws IOException;
	 
	 public Boolean checkAuthorityToWrite(String CalendarID) throws IOException;
	    	

}
