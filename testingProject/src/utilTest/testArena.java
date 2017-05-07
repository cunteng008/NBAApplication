package utilTest;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import model.Arena;

public class testArena {

	@Test
	public void test() {
		Arena arena = new Arena("暨大体育馆");
		arena.setCapacity(2000);
		arena.setLocation("珠海前山");
		arena.setName("体育馆");
		arena.setStart_end("1998-2017");
		
		Assert.assertEquals(arena.getCapacity(), 2000);
		Assert.assertEquals(arena.getLocation(), "珠海前山");
		Assert.assertEquals(arena.getName(), "体育馆");
		Assert.assertEquals(arena.getStart_end(), "1998-2017");
	}

}
