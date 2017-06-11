package util;

import javax.swing.SwingUtilities;

import model.Arena;
import model.Player;
import model.PlayerSeason;
import model.SingleDBton;
import model.Team;
import model.TeamSeason;

/*
 * Rk,Player,Season,Age,TeamAbbr,Lg,G,PTS  0--7
 * TeamSeason,TeamLg,TeamName,TeamCoaches,TeamFrom,TeamTo,TeamYrs,TeamG,TeamW,TeamL,TeamChamp 8--18
 * ArenaTeam,ArenaStart-End,Arena,ArenaLocation,ArenaCapacity  19--23
 * */

public class MyParser {
	
	MyFileReader myFileReader;
	int ignoreLines = 0;  // 忽略的行数
	public  int progress = 0;
	public  int finish = 0;
				
	public void parse(String fileName,int ignoreLines){
		myFileReader = new MyFileReader(fileName);
		this.ignoreLines = ignoreLines;
		
		if(ignoreLines>0){			
			while(ignoreLines>0){
				progress++;
				if(myFileReader.hasNext()){					
					if(progress==1){
						finish = myStrToInt( myFileReader.getALineData());	
					}
				}
				ignoreLines--;
			}
		}
	
		
	}
	
	public void excuteParsing(){
		
		while(myFileReader.hasNext()){			
			progress++;
			String aLineData = myFileReader.getALineData();
			String[] words = Split.splitByComma(aLineData, 24);
				
			String playerName = words[1];  // 运动员名字
			String season = words[2];
			String ageStr =words[3]; // 因为目前age的数据为字符串,所以用Str后缀加以区分,下面如此
			String teamAbbr = words[4];
			String league = words[5];
			String gameStr = words[6];
			String pointsStr = words[7];
			
			if(season.equals("")){
				season = words[8];
			}
			if(league.equals("")){
				league = words[9];
			}
			String teamName = words[10];
			String teamCoaches = words[11];
			String teamFromStr = words[12]; 
			String teamToStr = words[13];
			String teamYearsStr = words[14];
			String teamGamesStr = words[15];
			String teamWinsStr = words[16];
			String teamLossesStr = words[17];
			String teamChampionsStr = words[18];
			if(teamName.equals("")){
				teamName = words[19];  // 文件里的ArenaTeam和teamName是一样的
			}
			
			String arenaStart_End = words[20];
			String arenaName = words[21];
			String arenaLocation = words[22];
			String arenaCapacityStr = words[23];
						
			// 解析并保存运动员信息到单例数据库
			if(!playerName.equals("")){				
				int i=0;
				for(;i<SingleDBton.instance().getPlayers().size();i++){
					if(SingleDBton.instance().getPlayers().get(i).getName().equals(playerName)){
						if(!season.equals("")){
							PlayerSeason playerSeason = new PlayerSeason(words[2]);
							
							playerSeason.setAge(myStrToInt(ageStr));
							playerSeason.setTeamAbbr(teamAbbr);
							playerSeason.setLeague(league);
							playerSeason.setGames(myStrToInt(gameStr));
							playerSeason.setPoints(myStrToInt(pointsStr));
							
							SingleDBton.instance().getPlayers().get(i).
									addSeason(playerSeason);
						}
						break;
					}										
				}
				// 若还没有还没有这个人
				if(i>=SingleDBton.instance().getPlayers().size()){
					Player player = new Player(playerName);
					
					if(!season.equals("")){
						PlayerSeason playerSeason = new PlayerSeason(words[2]);
											
						playerSeason.setAge(myStrToInt(ageStr));
						playerSeason.setTeamAbbr(teamAbbr);
						playerSeason.setLeague(league);
						playerSeason.setGames(myStrToInt(gameStr));
						playerSeason.setPoints(myStrToInt(pointsStr));
						
						player.addSeason(playerSeason);
					}
					
					SingleDBton.instance().getPlayers().add(player);
				}				
			}
			
			// 规定team信息必须有名字的全称的缩写，是为了让两种方式的查找都能找到team
			// 解析并保存球队信息到单例数据库
			if(!teamAbbr.equals("") || !teamName.equals("")){
				int i = 0;
				for(; i< SingleDBton.instance().getTeams().size();i++){
					if(SingleDBton.instance().getTeams().get(i).getAbbr().equals(teamAbbr) ||
							SingleDBton.instance().getTeams().get(i).getName().equals(teamName) ){
						
						Team tempTeams = SingleDBton.instance().getTeams().get(i);
						if(tempTeams.getTeamFrom()<0){
							SingleDBton.instance().getTeams().get(i).
								setTeamFrom(myStrToInt(teamFromStr));
						}
						if(tempTeams.getTeamTo()<0){
							SingleDBton.instance().getTeams().get(i).
								setTeamTo(myStrToInt(teamToStr));
						}
						if(tempTeams.getChampions()<0){
							SingleDBton.instance().getTeams().get(i).
								setChampions(myStrToInt(teamChampionsStr));
						}
						if(tempTeams.getGames()<0){
							SingleDBton.instance().getTeams().get(i).
								setGames(myStrToInt(teamGamesStr));
						}
						if(tempTeams.getWins()<0){
							SingleDBton.instance().getTeams().get(i).
								setWins(myStrToInt(teamWinsStr));
						}
						if(tempTeams.getLosses()<0){
							SingleDBton.instance().getTeams().get(i).
								setLosses(myStrToInt(teamLossesStr));
						}
						if(tempTeams.getYears()<0){
							SingleDBton.instance().getTeams().get(i).
								setYears(myStrToInt(teamYearsStr));
						}
						if(tempTeams.getLeague().equals("")){
							SingleDBton.instance().getTeams().get(i).
								setLeague(league);
						}
						
						int j=0;
						if(season.equals("")){
							break;
						}
						for(;j<tempTeams.getTeamSeasons().size();j++){
							if(tempTeams.getTeamSeasons().get(j).getSeason().equals(season)){	
								if(!playerName.equals("")){
									SingleDBton.instance().getTeams().get(i).getTeamSeasons().
										get(j).addPlayerNames(playerName);
								}
								if(!arenaName.equals("")){
									SingleDBton.instance().getTeams().get(i).getTeamSeasons().
										get(j).setArenaName(arenaName);
								}
								if(!teamCoaches.equals("")){
									SingleDBton.instance().getTeams().get(i).getTeamSeasons().
										get(j).setCoaches(teamCoaches);
								}
								break;	
							}
						}
						if(j>=tempTeams.getTeamSeasons().size()){
							TeamSeason teamSeason = new TeamSeason(season);
							teamSeason.setArenaName(arenaName);
							teamSeason.setCoaches(teamCoaches);
							teamSeason.addPlayerNames(playerName);
							SingleDBton.instance().getTeams().get(i).addTeamToSeasons(teamSeason);
						}
												
						break;
					}
				}
				if(i>=SingleDBton.instance().getTeams().size()){
					Team team = new Team(teamAbbr,teamName);
					team.setTeamFrom(myStrToInt(teamFromStr));
					team.setTeamTo(myStrToInt(teamToStr));
					team.setChampions(myStrToInt(teamChampionsStr));
					team.setGames(myStrToInt(teamGamesStr));
					team.setWins(myStrToInt(teamWinsStr));
					team.setLosses(myStrToInt(teamLossesStr));
					team.setYears(myStrToInt(teamYearsStr));
					team.setLeague(league);	
					
					if(!season.equals("")){
						TeamSeason teamSeason = new TeamSeason(season);
						teamSeason.setArenaName(arenaName);
						teamSeason.setCoaches(teamCoaches);
						teamSeason.addPlayerNames(playerName);
						team.addTeamToSeasons(teamSeason);
					}
										
					SingleDBton.instance().getTeams().add(team);
				}
			}
			
			// 解析并保存体育馆信息到单例数据库
			if(!arenaName.equals("")){
				int i = 0;
				for(; i< SingleDBton.instance().getArenas().size();i++){
					if(SingleDBton.instance().getArenas().get(i).getName().equals(arenaName)){
						
						int arenaCapacity = myStrToInt(arenaCapacityStr);
						
						if(arenaStart_End.equals("")){
							SingleDBton.instance().getArenas().get(i).setStart_end(arenaStart_End);
						}
						if(arenaLocation.equals("")){
							SingleDBton.instance().getArenas().get(i).setLocation(arenaLocation);
						}
						if(arenaCapacity>0){
							SingleDBton.instance().getArenas().get(i).setCapacity(arenaCapacity);
						}
						break;						
					}
				}
				// 若单例数据库还没存有体育馆
				if(i>= SingleDBton.instance().getArenas().size()){
					Arena arena = new Arena(arenaName);
					
					int arenaCapacity = myStrToInt(arenaCapacityStr);					
					arena.setStart_end(arenaStart_End);
				    arena.setLocation(arenaLocation);
					arena.setCapacity(arenaCapacity);	
					SingleDBton.instance().getArenas().add(arena);
				}					
			}                                                                                      			
		}
	}
	
	private int myStrToInt(String str){
		if(str.equals("")){
			return -1;
		}
		return Integer.parseInt(str);
	}
}
