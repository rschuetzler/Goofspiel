package goofspiel;

public class CardFactory {
	private static CardFactory instance = null;
	
	protected CardFactory(){
		
	}
	public static CardFactory getInstance(){
		if(instance==null){
			instance = new CardFactory();
		}
		return instance;
	}
	
	public Card makeCard(int value){
		return new Card(value);
	}
	
}
