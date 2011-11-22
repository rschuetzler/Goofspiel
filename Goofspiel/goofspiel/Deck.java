package goofspiel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public String toString(){
		String deckString = "";
		for (int i = 0; i<cards.size()-1;i++){
			deckString += cards.get(i).toString() + ", ";
		}
		deckString += cards.get(cards.size()-1).toString();
		return deckString;
	}
	
	/*
	 * The play method is used to remove a card from the deck. Returns the card
	 * if it is in the deck. Throws an IllegalArgumentException if not.
	 * 
	 * @requires: The value of the card to be played (int)
	 * @modifiers: removes the card from the deck
	 * @effects: returns the card played
	 */
	public Card playCardByValue(int value){
		
		for (Card card : cards){
			if (card.getValue() == value){
				cards.remove(card);
				return card;
			}
		}
		throw new IllegalArgumentException("This card is not in the deck");
		
	}
	
	public Card playCardByIndex(int index){
		Card card = cards.get(index);
		cards.remove(index);
		return card;
	}
	
	public Card playRandom(){
		// Get the random index
		Random rand = new Random();
		int min = 1;
		int max = cards.size();
		int randomIndex = rand.nextInt(max - min + 1) + min;
		
		if (randomIndex > cards.size()) {
			randomIndex = cards.size();
		}else if (randomIndex < 1){
			randomIndex = 1;
		}
		
		// Get the value of the random card and use the play method to play it
		// return the card using the play method.
		return playCardByIndex(randomIndex);
	}
	
	public int getDeckSize(){
		return cards.size();
	}
}
