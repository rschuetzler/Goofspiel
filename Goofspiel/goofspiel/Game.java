package goofspiel;
import java.util.Scanner;


public class Game {
	private Deck p1deck;
	private Deck p2deck;
	private Deck gameDeck;
	private Player p1;
	private Player p2;
	private int p1Score;
	private int p2Score;
	
	public Game(String p1Name, String p2Name){
		DeckFactory df = DeckFactory.getInstance();
		this.p1deck = df.makeGoofspielDeck();
		this.p2deck = df.makeGoofspielDeck();
		this.gameDeck = df.makeGoofspielDeck();
		gameDeck.shuffle();
		this.p1Score = 0;
		this.p2Score = 0;
		PlayerFactory pf = PlayerFactory.getInstance();
		this.p1 = pf.makePlayer(p1Name);
		this.p2 = pf.makePlayer(p2Name);
	}
	
	public void playTurn(){
		
//		Console console = System.console();
		
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
	
	public void play(){
		while(gameDeck.getDeckSize()>0){
			playTurn();
		}
		System.out.println("");
		if (p2Score > p1Score){
			System.out.println(p2.getName() + " wins! Congratulations!");
		}else if (p1Score > p2Score){
			System.out.println(p1.getName() + " wins! Congratulations!");
		}else{
			System.out.println("It's a miracle! We have a draw.");
		}
	}
}
