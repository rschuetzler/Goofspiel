package goofspiel;

public class DeckFactory {
	
	private static DeckFactory instance = null;
	
	protected DeckFactory(){
		
	}
	public static DeckFactory getInstance(){
		if(instance==null){
			instance = new DeckFactory();
		}
		return instance;
	}
	
	public Deck makeGoofspielDeck(){
		Deck deck = new Deck();
		CardFactory cardMaker = CardFactory.getInstance();
		for (int i = 1; i <= 13; i++){
			Card card = cardMaker.makeCard(i);
			deck.addCard(card);
		}
		return deck;
	}
}
