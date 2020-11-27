package tech.stefanbruhns.utils.math;

import static tech.stefanbruhns.utils.collections.CollectionsUtil.contains;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class RandomUtilJTest extends RandomUtil {

	static final String[] fruits = new String[] {
			"apple", 
			"banana", 
			"cucumber", 
			"peach", 
			"cherry", 
			"mango", 
			"strawberry"
	};
	
	static final int[] integers = new int[] {
			67,
			63,
			90,
			0,
			11,
			-10,
			-20,
			46,
			13,
			654
	};

	@Test
	public void TEST_getRandomStringFromArray() {
		String f = getRandom(fruits);
		assertNotNull(f);
		assertTrue(contains(true, fruits, f));
		assertTrue(contains(false, fruits, f));
	}
	
//	@Test
//	public void TEST_getRandomInt() {
//		int n = getRandomInt(integers);
//		
//	}
}
