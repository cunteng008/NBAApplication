package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Player;
import model.SingleDBton;

public class SearchUtil {
	
	public static List<Player> SearchPlayerRes(String searchKey,List<Player> playerList) {
		List<Player> res = new ArrayList<Player>();
		Pattern pattern = Pattern.compile(RegularExpressionRule(searchKey));
		
		for(Player player:playerList){
			Matcher matcher = pattern.matcher(player.getName());
			if(matcher.find()){
				res.add(player);
				continue;
			}
		}
		return res;
	}
	
	public static String RegularExpressionRule(String searchKey){
		String rule = ".*(?i)";  
		rule = rule + searchKey + ".*$";		
		return rule;		
	}
}
