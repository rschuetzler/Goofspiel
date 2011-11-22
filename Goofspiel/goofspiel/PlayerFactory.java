package goofspiel;

public class PlayerFactory {
	
	private static PlayerFactory instance = null;
	
	protected PlayerFactory(){
		
	}
	public static PlayerFactory getInstance(){
		if(instance==null){
			instance = new PlayerFactory();
		}
		return instance;
	}
	
	public Player makePlayer(String name){
		return new Player(name);
	}
}
