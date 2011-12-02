package goofspiel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CarryoverGame extends Game{
	private int carryoverValue;
	
	public CarryoverGame(String[] pNames){
		super(pNames);
		this.carryoverValue = 0;
	}
	
	protected void playTurn(){
		Scanner in = new Scanner(System.in);
		
		Card thisTurnCard = gameDeck.playCardByIndex(0);
		
		int[] plays = new int[players.length];
		
		for (int i = 0; i < players.length; i++){
			Player player = players[i];
			Deck pDeck = pDecks[i];
			System.out.println("\nThe current card is: " + thisTurnCard + "\n");
			System.out.println(player.getName() + ", your current deck is: " + pDeck);
			System.out.println("What card would you like to play?");
			plays[i] = in.nextInt();
			pDeck.playCardByValue(plays[i]);
			
		}
		
		// Find the winner/winners
		int[] sortedPlays = new int[plays.length]; 
		System.arraycopy(plays, 0, sortedPlays, 0, plays.length);
		Arrays.sort(sortedPlays);
		int topPlay = sortedPlays[sortedPlays.length-1];
		ArrayList<Integer> playList = new ArrayList<Integer>();
		for (int play : plays)
		{
			playList.add(play);
		}
		int index = playList.indexOf(topPlay);
		int lastIndex = playList.lastIndexOf(topPlay);
		if (index == lastIndex) // 	If 1 winner, add carryover and current card to winner's score
		{
			scores[index] += carryoverValue + thisTurnCard.getValue();
			carryoverValue = 0;
		}else{ // If there is a tie, carry over the value into the next round
			carryoverValue += thisTurnCard.getValue();
		}
		
		
		
		
//		
//		if (p1cardvalue > p2cardvalue){
//			p1Score += thisTurnCard.getValue();
//			System.out.println("P1 wins this card");
//		}else if (p2cardvalue > p1cardvalue){
//			p2Score += thisTurnCard.getValue();
//			System.out.println("P2 wins this card");
//		}else{
//			System.out.println("\nDraw! Nobody wins this card.");
//		}
	}

}
