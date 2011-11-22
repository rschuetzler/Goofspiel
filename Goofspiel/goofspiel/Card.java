package goofspiel;

public class Card {
	
	private int value;
	
	public Card(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String toString(){
		return String.valueOf(this.value);
	}
}
