package goofspiel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public abstract class Game {
	protected Deck[] pDecks;
	protected Deck gameDeck;
	protected Player[] players;
	protected int[] scores;
	protected Player lastHandWinner;
	
	protected Game(String[] pNames){
		DeckFactory df = DeckFactory.getInstance();
		PlayerFactory pf = PlayerFactory.getInstance();
		
		this.gameDeck = df.makeGoofspielDeck();
		gameDeck.shuffle();
		
		pDecks = new Deck[pNames.length];
		players = new Player[pNames.length];
		scores = new int[pNames.length];
		
		for (int i = 0; i < pNames.length; i++){
//			System.out.println(pNames.length + " with i=" + i " and pDecks size" + pDecks.length);
			this.pDecks[i] = df.makeGoofspielDeck();
			this.players[i] = pf.makePlayer(pNames[i]);
			this.scores[i] = 0;
		}
		
	}
	
	protected abstract void playTurn();
	
	public void play(){
		while(gameDeck.getDeckSize()>0){
			playTurn();
		}
		System.out.println("");
		System.out.println(determineWinner());
	}
	
	private String determineWinner(){
		int[] sortedScores = new int[scores.length-1];
		System.arraycopy(scores, 0, sortedScores, 0, scores.length);
		Arrays.sort(sortedScores);
		
		// Determine the top score, and whether there is a single winner or a tie.
		int topScore = sortedScores[sortedScores.length-1];
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		for (int score : scores)
		{
			scoreList.add(score);
		}
		int index = Arrays.asList(scores).indexOf(topScore);
		int lastIndex = Arrays.asList(scores).lastIndexOf(topScore);
		if (index == lastIndex){
			return players[index].getName() + " wins!";
		}else{
			return players[index].getName() + " and " + players[lastIndex].getName() + " tied for victory!";
		}
		
	}
}
