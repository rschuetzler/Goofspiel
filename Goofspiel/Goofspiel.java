import goofspiel.Deck;
import goofspiel.DeckFactory;
import goofspiel.GameFactory;
import goofspiel.ThrowawayGame;
import goofspiel.Game;

public class Goofspiel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		DeckFactory df = DeckFactory.getInstance();
//		Deck d = df.makeGoofspielDeck();
//		System.out.println(d);
//		
//		d.shuffle();
//		System.out.println(d);
//		
//		d.playCardByValue(10);
//		System.out.println(d);
//		
//		d.playRandom();
//		System.out.println(d);
		
		GameFactory gf = GameFactory.getInstance();
		String[] pNames = {"Ryan","Justin"};
		Game game = gf.createGame("carryover", pNames);
		game.play();
//		System.out.println(pNames.length);
	}

}
