package model;

import java.util.ArrayList;

public class Team {
	
	String abbr;
	String name;	
	String league;
	int teamFrom;
	int teamTo;
	int years;
	int champions;
	int games;
	int losses;
	int wins;
	ArrayList<TeamSeason> teamSeasons ;
	
	public Team(String abbr,String name){
		this.abbr = abbr;
		this.name = name;
		teamSeasons = new ArrayList<TeamSeason>();
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTeamFrom() {
		return teamFrom;
	}

	public void setTeamFrom(int teamFrom) {
		this.teamFrom = teamFrom;
	}

	public int getTeamTo() {
		return teamTo;
	}

	public void setTeamTo(int teamTo) {
		this.teamTo = teamTo;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public int getChampions() {
		return champions;
	}

	public void setChampions(int champions) {
		this.champions = champions;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public ArrayList<TeamSeason> getTeamSeasons() {
		return teamSeasons;
	}

	public void addTeamToSeasons(TeamSeason teamSeason) {
		teamSeasons.add(teamSeason);
	}	
	
	
}
