//////////////////////////////////////////////////////////
//Author:Darshan Hosakote								//
//Date: 8/16/2017 8:54am								//
//Description : Project implements the card game - war. //
//Class: Card											//
//////////////////////////////////////////////////////////

package com.aquicore.war;

public class Card {

	private String suit;
	private int value;
	
	public static String suits[] = {"hearts","diamonds","clubs","spades"};
	
	//assumptions for J,Q,K,A as 11,12,13,14 for comparison 
	public static int values[] = {2,3,4,5,6,7,8,9,10,11,12,13,14};
								 //2,3,4,5,6,7,8,9,10,J,Q,K,A
	
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
