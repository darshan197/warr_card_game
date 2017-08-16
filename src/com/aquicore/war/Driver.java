///////////////////////////////////////////////////////////////////////////
//Author:Darshan Hosakote								                 //
//Date: 8/16/2017 8:54am								                 //
//Description : Project implements the card game - war.                  //
//Class: Driver , drives the game, building deck,shuffling the deck,     //
//		 splitting the deck between player and computer and cards drawing//
///////////////////////////////////////////////////////////////////////////
package com.aquicore.war;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		System.out.println("***Let's****Play****War***");
		//System.out.println("Press Enter to Play");
		
		Scanner scanner = new Scanner(System.in);
		//String s = scanner.next();
		//System.out.println(s);
		System.out.println();
		System.out.println();
		System.out.print("Enter your name :   ");
		//Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Player p1 = new Player(name);
		Player p2 = new Player("Computer");

		Deck d = new Deck();

		d.buildDeck();//build deck
		d.shuffleDeck();
		//d.printDeck();
		splitCardsToPlayers(d.getDeck(), p1, p2);//deck is split between player and computer
												 //into 26 cards each
		System.out.println("Cards are shuffled and split , press any key to play");
		System.out.println( p1.getName() + " : "+ p1.getScore() +"    " + p2.getName() +" : "+ p2.getScore());
		//System.out.println("Cards are shuffled , press any key to play");
		promptEnterKey();
		
		while(true){
			System.out.println("------------------------------------------");
			
			if(p1.getCardsInHand().size() == 0 ) {
				System.out.println(p2.getName() + " wins");
				break;
			}
			else if(p2.getCardsInHand().size() == 0) {
				System.out.println(p1.getName() + " wins");
				break;
			}
			else if(p1.getCardsInHand().size() == 0 && p2.getCardsInHand().size() == 0){
				System.out.println("Match is drawn");
				break;
			}
			System.out.println(
					p1.getName()+"'s card : " + p1.getCardsInHand().get(0).show() + "   "+p2.getName() +"'s card : " + p2.getCardsInHand().get(0).show());
			
			determineWinner(p1,p2);
			
			System.out.println( p1.getName() + " : "+ p1.getScore() +"    " + p2.getName() +" : "+ p2.getScore());

			System.out.println();
			promptEnterKey();
			
		}
	}

	public static void promptEnterKey(){
		   System.out.println("Press \"ENTER\" to draw new card ");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}
	
	private static String determineWinner(Player p1, Player p2) {
		int flag = (p1.getCardsInHand().get(0).getValue() == p2.getCardsInHand().get(0).getValue()) ? 0
				: ((p1.getCardsInHand().get(0).getValue() > p2.getCardsInHand().get(0).getValue()) ? 1 : 2);
		String result = null;
		switch (flag) {
		
		case 1:
			p1Win(p1, p2);
			result = "p1";
			break;

		case 2:
			p2Win(p1, p2);
			result = "p2";
			break;
			
		case 0:
			result = tie(p1,p2);
			break;
		}
		p1.calculateScore();
		p2.calculateScore();
		return result;
	}

	//tie breaker/war when both the players draw same card
	private static String tie(Player p1, Player p2) {
		//to check if any player has cards less than or equal to 2
		if(p1.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p1.getName() +" has less than 3 cards");
			System.out.println(p2.getName() + " wins");
			System.exit(1);
		}
		if(p2.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p2.getName() +" has less than 3 cards");
			System.out.println(p1.getName() + " wins");
			System.exit(1);
		}
		
		ArrayList<Card> oldCards = new ArrayList<Card>();
		oldCards.add(p1.getCardsInHand().remove(0));
		oldCards.add(p2.getCardsInHand().remove(0));
		ArrayList<Card> hiddenCards = new ArrayList<Card>();
		hiddenCards.add(p1.getCardsInHand().remove(0));
		hiddenCards.add(p2.getCardsInHand().remove(0));
		String tieBreaker = determineWinner(p1,p2);
		if(tieBreaker.equals("p1")){
			p1.getCardsInHand().addAll(oldCards);
			p1.getCardsInHand().addAll(hiddenCards);
		}
		else if (tieBreaker.equals("p2")) {
			p2.getCardsInHand().addAll(oldCards);
			p2.getCardsInHand().addAll(hiddenCards);
		}
		return tieBreaker;
	}
	
	// if p1 win's , p1 retains its cards and gets cards from p2
	private static void p1Win(Player p1, Player p2) {
		if(p1.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p1.getName() +" has less than 3 cards");
			System.out.println(p2.getName() + " wins");
			System.exit(1);
		}
		if(p2.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p2.getName() +" has less than 3 cards");
			System.out.println(p1.getName() + " wins");
			System.exit(1);
		}
		p1.getCardsInHand().add(p2.getCardsInHand().remove(0));
		p1.getCardsInHand().add(p1.getCardsInHand().remove(0));
		
		
	}

	// if p2 win's , p2 retains its cards and gets cards from p2
	private static void p2Win(Player p1, Player p2) {
		if(p1.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p1.getName() +" has less than 3 cards");
			System.out.println(p2.getName() + " wins");
			System.exit(1);
		}
		if(p2.getCardsInHand().size() <= 2){
			System.out.println();
			System.out.println(p2.getName() +" has less than 3 cards");
			System.out.println(p1.getName() + " wins");
			System.exit(1);
		}
		p2.getCardsInHand().add(p1.getCardsInHand().remove(0));
		p2.getCardsInHand().add(p2.getCardsInHand().remove(0));
	}

	//split cards
	private static void splitCardsToPlayers(ArrayList<Card> cards, Player p1, Player p2) {
		ArrayList<Card> halfCards = new ArrayList<Card>(cards.subList(0, 26));
		cards.removeAll(halfCards);
		ArrayList<Card> otherHalfCards = cards;
		p1.setCardsInHand(halfCards);
		p2.setCardsInHand(otherHalfCards);
	}
	
	
}
