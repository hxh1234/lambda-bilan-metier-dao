package com.lambda.bilan.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.lambda.bilan.entities.Collaborateur;

public class DateHelper {

	private static final String DATE_FORMAT_SQL = "yyyy-MM-dd";

	public static Date dateBAPthisYear(Collaborateur collaborateur) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SQL);
		String dateInString;
		Date dateBAP;
		
		String dateEmbauche =collaborateur.getDateEmbaucheCollaborateur().toString();
		int moisEmbauche = Integer.parseInt(dateEmbauche.split("-")[1]) ;
		Calendar datenow = Calendar.getInstance();
		int moisNow= datenow.get(Calendar.MONTH) + 1;
		int anneeNow=datenow.get(Calendar.YEAR);
		
		if(moisNow <moisEmbauche){
			dateInString=anneeNow-1+"-"+moisEmbauche+"-01";
			dateBAP = sdf.parse(dateInString);
		}
		else{
			dateInString=anneeNow+"-"+moisEmbauche+"-01";
			dateBAP = sdf.parse(dateInString);
		}
		return dateBAP;
	}
	
	
	
	public static Date datePlus11Month(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 11);
		date = cal.getTime();
		return date;
	}

}
