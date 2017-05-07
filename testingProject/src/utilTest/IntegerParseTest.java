package utilTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class IntegerParseTest {

	// 测试表明空串不可为解析为整数
	@Test
	public void test() {
		String str = "";
		int strInt = Integer.parseInt(str);
		Assert.assertEquals(strInt,0);
		System.out.println(strInt);
	}

}
