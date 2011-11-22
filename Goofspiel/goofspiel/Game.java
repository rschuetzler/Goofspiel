package goofspiel;
import java.util.Arrays;
import java.util.Scanner;


public abstract class Game {
	private Deck[] pDecks;
	private Deck gameDeck;
	private Player[] players;
	private int[] scores;
	
	public Game(String[] pNames){
		DeckFactory df = DeckFactory.getInstance();
		PlayerFactory pf = PlayerFactory.getInstance();
		
		this.gameDeck = df.makeGoofspielDeck();
		gameDeck.shuffle();
		
		pDecks = new Deck[pNames.length-1];
		players = new Player[pNames.length-1];
		scores = new int[pNames.length-1];
		
		for (int i = 0; i < pNames.length; i++){
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
		System.arraycopy(scores, 0, sortedScores, 0, scores.length-1);
		Arrays.sort(sortedScores);
		
		// Determine the top score, and whether there is a single winner or a tie.
		int topScore = sortedScores[sortedScores.length-1];
		int index = Arrays.asList(scores).indexOf(topScore);
		int lastIndex = Arrays.asList(scores).lastIndexOf(topScore);
		if (index == lastIndex){
			return players[index].getName() + " wins!";
		}else{
			return players[index].getName() + " and " + players[lastIndex].getName() + " tied for victory!";
		}
		
	}
}
