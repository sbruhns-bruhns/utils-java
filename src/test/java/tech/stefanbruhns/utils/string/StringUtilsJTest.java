package tech.stefanbruhns.utils.string;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringUtilsJTest extends StringUtil {

	@Test
	public void TEST_isSet() {
	    assertTrue(isSet("one"));
	    assertFalse(isSet(null));
	    assertFalse(isSet(""));
	    assertFalse(isSet("  "));
	}
	
	@Test
	public void TEST_multiply() {
		assertEquals(null, multiply(null, 5));
		assertEquals("", multiply("-", 0));
		assertEquals("-----", multiply("-", 5));
	}
	
	@Test
	public void TEST_addLeft() {
		assertEquals("-----one", addLeft("one", "-", 5));
	}
	
	@Test
	public void TEST_addRight() {
		assertEquals("one-----", addRight("one", "-", 5));
	}
	
	@Test
	public void TEST_addBoth() {
		assertEquals("-----one-----", addBoth("one", "-", 5));
	}

	@Test
	public void TEST_pad1() {
		assertEquals("...one", pad(true, "one", 6, "."));
		assertEquals("one...", pad(false, "one", 6, "."));
	}
	
	@Test
	public void TEST_pad2() {
		assertEquals("...one...", pad("one", ".", 3));
	}	

	@Test
	public void TEST_padLeft() {
		assertEquals("...one", padLeft("one", 6, '.'));
	}

	@Test
	public void TEST_padRight() {
		assertEquals("one...", padRight("one", 6, '.'));
	}
	
	@Test
	public void TEST_padBoth() {
		assertEquals("...one...", padBoth("one", ".", 9));
		assertEquals("..one...", padBoth("one", ".", 8));
		assertEquals("one", padBoth("one", ".", 2));
	}
	
	@Test
	public void TEST_getLastCharacters() {
		assertEquals(null, getLastCharacters(null, 5));
		assertEquals("one", getLastCharacters("one", 5));
		assertEquals("apple", getLastCharacters("one apple", 5));
	}	
}
