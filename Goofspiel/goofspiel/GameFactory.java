package goofspiel;

public class GameFactory {
	
	private static GameFactory instance = null;
	
	protected GameFactory(){
		
	}
	
	public static GameFactory getInstance(){
		if(instance==null){
			instance = new GameFactory();
		}
		return instance;
	}
	
	public Game createGame(String type, String[] pNames){
		if (type == "carryover")
		{
			return new CarryoverGame(pNames);
		}else //if (type == "throwaway")
		{
			return new ThrowawayGame(pNames);
		}
		
	}
}
