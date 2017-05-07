package model;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<PlayerSeason> seasons = null;
	
	public Player(String name){
		this.name = name;
		seasons = new ArrayList<PlayerSeason>();
	}
	
	public String getName() {
		return name;
	}
	public ArrayList<PlayerSeason> getSeasons() {
		return seasons;
	}

	public void addSeason(PlayerSeason season) {
		seasons.add(season);
	}
	

		
}
