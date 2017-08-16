//////////////////////////////////////////////////////////
//Author:Darshan Hosakote								//
//Date: 8/16/2017 8:54am								//
//Description : Project implements the card game - war. //
//Class: Deck											//
//////////////////////////////////////////////////////////
package com.aquicore.war;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {

	private ArrayList<Card> deck;
	
	public Deck(){
		this.deck = new ArrayList<Card>();
		
	}
		
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	public void drawCard(Card c) {
		this.deck.add(c);
	}
	
	//A deck of cards is built from 13 of each suits
	public void buildDeck() {	
		for(int i = 0 ; i< Card.suits.length ; i++){
			for(int j=0; j< Card.values.length ; j++) {
				Card card = new Card(Card.suits[i],Card.values[j]);
				deck.add(card);
			}
		}
	}
	
	//built deck is shuffled
	public void shuffleDeck() {
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
	}
	
	
	public void printDeck() {
		for(int i =0 ; i< deck.size()-1;i++){
			System.out.println("[ "+deck.get(i).getSuit() +"," + deck.get(i).getValue() +"]");
		}
	}
	
	//return deck size
	public int getDeckSize(){
		return this.deck.size();
	}
	
}




