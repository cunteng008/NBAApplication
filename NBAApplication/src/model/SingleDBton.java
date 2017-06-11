package model;

import java.util.ArrayList;

public class SingleDBton {
	
	private static SingleDBton theInstance = null;
	
	private ArrayList<Player> players ;
	private ArrayList<Team> teams ;
	private ArrayList<Arena> arenas;
	
	private SingleDBton(){
		players = new ArrayList<Player>();
		teams = new ArrayList<Team>();
		arenas = new ArrayList<Arena>();
	}
	
	public static SingleDBton instance(){
		if(theInstance == null){
			theInstance = new SingleDBton();
		}
		return theInstance;
	}
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public ArrayList<Arena> getArenas() {
		return arenas;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	
}
