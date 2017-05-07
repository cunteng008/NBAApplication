package utilTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


import util.Split;

public class SplitTest {

	@Test
	public void testSplitByComma() {
		String str = "7,Travis Diener,2008-2009,26,IND,NBA,55,206,2008-2009,"
				+ "NBA,Indiana Pacers,J. O'Brien ,1977,2014,38,2992,1474,1518,0,"
				+ "Indiana Pacers,,BankersLifeFieldhouse,,";
		String[] words = Split.splitByComma(str, 24);
		Assert.assertEquals(words[23],"");	
		Assert.assertEquals(words[22],"");
		Assert.assertEquals(words[20],"");
		Assert.assertEquals(words[1],"Travis Diener");	
		Assert.assertEquals(words[11],"J. O'Brien");
	}
}
