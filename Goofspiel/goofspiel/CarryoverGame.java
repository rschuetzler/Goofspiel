package goofspiel;

import java.util.Scanner;

public class CarryoverGame extends Game{
	public CarryoverGame(String[] pNames){
		super(pNames);
		
	}
	
	protected void playTurn(){
		Scanner in = new Scanner(System.in);
		
		Card thisTurnCard = gameDeck.playCardByIndex(0);
		
		System.out.println("\nThe current card is: " + thisTurnCard + "\n");
		System.out.println(p1.getName() + ", your current deck is: " + p1deck);
		System.out.println("What card would you like to play?");
		
//		String p1card = console.readLine("What card would you like to play? ");
		int p1cardvalue = in.nextInt();
		System.out.println("\nThe current card is: " + thisTurnCard + "\n");
		System.out.println(p2.getName() + ", your current deck is: " + p2deck);
		System.out.println("What card would you like to play?");
//		String p2card = console.readLine("What card would you like to play? ");
		int p2cardvalue = in.nextInt();
		
		
//		int p1cardvalue = Integer.parseInt(p1card);
//		int p2cardvalue = Integer.parseInt(p2card);
		
		p1deck.playCardByValue(p1cardvalue);
		p2deck.playCardByValue(p2cardvalue);
		
		if (p1cardvalue > p2cardvalue){
			p1Score += thisTurnCard.getValue();
			System.out.println("P1 wins this card");
		}else if (p2cardvalue > p1cardvalue){
			p2Score += thisTurnCard.getValue();
			System.out.println("P2 wins this card");
		}else{
			System.out.println("\nDraw! Nobody wins this card.");
		}
	}

}
