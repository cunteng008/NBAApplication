package model;

import java.util.ArrayList;

public class TeamSeason {
	String season;
	String arenaName;
	String coaches;    //暂时不分开，后续考虑改变
	ArrayList<String> playerNames;
	
	public TeamSeason(String season){
		this.season = season;
		playerNames = new ArrayList<String>();
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getArenaName() {
		return arenaName;
	}

	public void setArenaName(String arenaName) {
		this.arenaName = arenaName;
	}

	public String getCoaches() {
		return coaches;
	}

	public void setCoaches(String coaches) {
		this.coaches = coaches;
	}

	public ArrayList<String> getPlayerNames() {
		return playerNames;
	}

	public void addPlayerNames(String playerName) {
		playerNames.add(playerName);
	}
	
	
}
