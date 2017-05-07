package utilTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import util.MyFileReader;

public class MyFileReaderTest {

	static MyFileReader myFileReader ;
	static String fileName = "D:/cmj/MyProject/eclipse/NBAprojectWorkspace/"
			+ "testingProject/res/testNBAData.txt";
	@BeforeClass
	public static void  testMyFileReader(){
	   
		
		myFileReader = new MyFileReader(fileName);
	}
	@Test
	public void testHasNext() {
		int lineCount = 0;
		while(myFileReader.hasNext()){
			lineCount++;
			if(lineCount==2){
				Assert.assertEquals(myFileReader.getALineData(),("Rk,Player,Season,Age,TeamAbbr,Lg,G,PTS,TeamSeason,TeamLg,"
						+ "TeamName,TeamCoaches,TeamFrom,TeamTo,TeamYrs,TeamG,TeamW,TeamL,TeamChamp,"
						+ "ArenaTeam,ArenaStart-End,Arena,ArenaLocation,ArenaCapacity"));
			}if(lineCount==10){
				Assert.assertEquals(myFileReader.getALineData(),("8,Ike Diogu,2008-2009,25,TOT,NBA,"
						+ "29,119,,,,,,,,,,,,,,,,"));
			}			
		}
		Assert.assertEquals(13, lineCount);		
		
		// 当传入的文件为不存在时
		fileName = "dd";
		lineCount = 0;
		while(myFileReader.hasNext()){
			lineCount++;
		}
		Assert.assertEquals(lineCount, 0);
		
		// 当传入的文件为null时
		fileName = null;
		lineCount = 0;
		while(myFileReader.hasNext()){
			lineCount++;
		}
		Assert.assertEquals(lineCount, 0);
	}

	@Test
	public void testSetFile() {
		// 设置为新的文件时
		fileName = "D:/cmj/MyProject/eclipse/NBAprojectWorkspace/"
				+ "NBAApplication/resource/NBAData.txt";
		int lineCount = 0;
		myFileReader.SetFile(fileName);
		while(myFileReader.hasNext()){
			lineCount++;
		}
		Assert.assertEquals(19199, lineCount);		
	}

}
