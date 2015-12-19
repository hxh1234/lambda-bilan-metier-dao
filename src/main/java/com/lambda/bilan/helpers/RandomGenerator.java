package com.lambda.bilan.helpers;

import java.util.Random;

public class RandomGenerator {

	static final String CHAR_LIST = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static final String NUMBER_LIST = "0123456789";
	static Random rnd = new Random();

	public static String randomString(){
	   StringBuilder sb = new StringBuilder(6);
	   for( int i = 0; i < 6; i++ ) 
	      sb.append( CHAR_LIST.charAt( rnd.nextInt(CHAR_LIST.length()) ) );
	   return sb.toString();
	}

	public static String randomNumber(){
		   StringBuilder sb = new StringBuilder(6);
		   for( int i = 0; i < 6; i++ ) 
		      sb.append( CHAR_LIST.charAt( rnd.nextInt(NUMBER_LIST.length()) ) );
		   return sb.toString();
		}
}
