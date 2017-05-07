package model;

public class PlayerSeason {
	
	String season;
	String teamAbbr;
	String league;
	int games;
	int points;
	short age;
		
	public PlayerSeason(String season){
		this.season = season;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getTeamAbbr() {
		return teamAbbr;
	}

	public void setTeamAbbr(String teamAbbr) {
		this.teamAbbr = teamAbbr;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public short getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = (short)age;
	}
	
	
}
