package utilTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.Arena;
import model.Player;
import model.PlayerSeason;
import model.SingleDBton;
import model.Team;
import util.MyParser;

public class MyParserTest {

	public static MyParser myParser = new MyParser();;
	static String fileName = "D:/cmj/MyProject/eclipse/NBAprojectWorkspace/"
			+ "testingProject/res/testNBAData.txt";
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testParse() {
				
		myParser.parse(fileName,2);		
		
		// 测试解析的运动员数据
		int playerNum = 0;
		int personSeasonsNum = 0;
		for(Player player : SingleDBton.instance().getPlayers()){			
			playerNum++;
			for(PlayerSeason personSeason: player.getSeasons()){
				personSeasonsNum++;
			}
		}		
		Assert.assertEquals(playerNum,9);
		Assert.assertEquals(personSeasonsNum,11);
		
		// 测试运动场数据
		int arenaNum = 0;
		for(Arena arena : SingleDBton.instance().getArenas()){			
			 arenaNum ++;		
		}	
		Assert.assertEquals(arenaNum, 5);
		
		// 测试球队
		int teamNum = 0;
		for(Team team : SingleDBton.instance().getTeams()){			
			 teamNum ++;			 
		}	
		Assert.assertEquals(teamNum,7);
		
		// 当忽略解析前3行时
//		myParser.parse(fileName,2);		
//		// 测试解析的运动员数据
//		playerNum = 0;
//		personSeasonsNum = 0;
//		for(Player player : SingleDBton.instance().getPlayers()){			
//			playerNum++;
//			for(PlayerSeason personSeason: player.getSeasons()){
//				personSeasonsNum++;
//			}
//		}		
//		System.out.println(personSeasonsNum);
//		Assert.assertEquals(playerNum,9);
//		Assert.assertEquals(personSeasonsNum,10);
	}
}
