//////////////////////////////////////////////////////////
//Author:Darshan Hosakote								//
//Date: 8/17/2017 8:23am								//
//Description : Project implements the card game - war. //
//Class: Player											//
//////////////////////////////////////////////////////////

package com.aquicore.war;
import java.util.ArrayList;

public class Player {

	private String name;
	private int score;
	
	//number of cards with each player after splitting the deck
	private ArrayList<Card> cardsInHand;

	public Player(String name){
		this.name = name;
		this.score = 26;
	}
	
	public void setCardsInHand(ArrayList<Card> cards){
		this.cardsInHand = cards;
	}
	
	public ArrayList<Card> getCardsInHand(){
		return this.cardsInHand;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	//number of cards with any player after the play starts
	public void calculateScore(){
		this.score = this.cardsInHand.size();
		//System.out.println(this.cardsInHand.size());
	}
	
	public void addCard(Card c){
		this.cardsInHand.add(c);
	}
	
	
	public void printPlayerHand() {
		for(int i =0 ; i< cardsInHand.size();i++){
			System.out.println("[ "+cardsInHand.get(i).getSuit() +"," + cardsInHand.get(i).getValue() +"]");
		}
	}
	
	
	
	
		
}
