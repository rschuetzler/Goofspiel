package goofspiel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ThrowawayGame extends Game{
	
	public ThrowawayGame(String[] pNames){
		super(pNames);
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
		
		// Determine if there is only one winner, or if there is a tie. If tied,
		// nobody gets the points.
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
		if (index == lastIndex){
			scores[index] += thisTurnCard.getValue();
		}else{
			// Do nothing if there is a tie.
		}
	
	}

}
