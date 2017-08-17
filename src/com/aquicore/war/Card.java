//////////////////////////////////////////////////////////
//Author:Darshan Hosakote								//
//Date: 8/17/2017 8:23am								//
//Description : Project implements the card game - war. //
//Class: Card											//
//////////////////////////////////////////////////////////

package com.aquicore.war;

public class Card {

	private String suit;
	private int value;              // "hearts","diamonds","clubs","spades"
									//'\u2764' '\u2666' '\u2663' ,'\u2660'
	public static String suits[] = {"\u2764","\u2666","\u2663","\u2660"};
	
	//assumptions for J,Q,K,A as 11,12,13,14 for comparison 
	public static int values[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
								 //2,3,4,5,6,7,8,9,10,J,Q,K,A
	
	public static String customSuits[] = {"\u2764","\u2764"};
	public static int customValues[] = {2,2,2,2,2,2};
	//constructor
	public Card(String suit , int value){
		this.suit = suit;
		this.value = value;
	}
	
	public String show(){
		return "[" + suit + "," + value + "]";
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public String getSuit(){
		return this.suit;
	}
	
}
