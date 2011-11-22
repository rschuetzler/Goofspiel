import goofspiel.Deck;
import goofspiel.DeckFactory;
import goofspiel.CarryoverGame;

public class Goofspiel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DeckFactory df = DeckFactory.getInstance();
		Deck d = df.makeGoofspielDeck();
		System.out.println(d);
		
		d.shuffle();
		System.out.println(d);
		
		d.playCardByValue(10);
		System.out.println(d);
		
		d.playRandom();
		System.out.println(d);
		
		Game game = new CarryoverGame({"Ryan","Justin"});
		game.play();
	}

}
