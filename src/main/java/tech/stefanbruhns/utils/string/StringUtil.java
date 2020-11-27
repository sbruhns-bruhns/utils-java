package tech.stefanbruhns.utils.string;

import org.apache.commons.lang3.StringUtils;

import tech.stefanbruhns.utils.base.BaseUtil;

public class StringUtil extends BaseUtil {
	
	/**
	 * Returns true if the given String is not null and not empty when trimmed.
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isSet(final String value) {
	    return (value == null || value.trim().isEmpty()) ? false : true; 
	}
	
    /**
     * Multiply the given String.
     * 
     * e.g.:
     * 
     * multiply(".", 5) >> "...."
     */
	public static String multiply(String s, int times) {
		if (s == null) {
			return null;
		} else if (times == 0) {
			return EMPTY;
		} else {
			return pad(false, s, s.length() * times, s);
		}
	}
	
    public static String addLeft(String s, String padStr, int times) {
    	return multiply(padStr, times) + s;
    }
    
    public static String addRight(String s, String padStr, int times) {
    	return s + multiply(padStr, times);
    }
    
    /**
     * Add given characters to the given String n times on both sides.
     * 
     * e.g.:
     * 
     * padBoth("Hi", 3, ".") >> "...Hi..."
     */
    public static String addBoth(String s, String padStr, int times) {
    	String padding = multiply(padStr, times);
    	return padding + s + padding; 
    }
	
    /**
     * Either left or right, pad the given String to the given size.
     * 
     * e.g.: 
     * 
     * pad(true, "Hi", 5, ".")  >> "...Hi"
     * pad(false, "Hi", 5, ".") >> "Hi..." 
     */
    public static String pad(boolean padLeft, String s, int size, String padStr) {
    	return padLeft ? StringUtils.leftPad(s, size, padStr) : StringUtils.rightPad(s, size, padStr); 
    }

	
    public static final String padLeft(String str, int size, char padChar) {
    	return StringUtils.leftPad(str, size, padChar);
    }
    
    public static final String padRight(String str, int size, char padChar) {
    	return StringUtils.rightPad(str, size, padChar);
    }
    
    /**
     * Pad the given String on both sides with n times the given pad character.
     * 
     * e.g.: padBoth("Hi", 3, ".") >> "...Hi..."
     * 
     * @param s
     * @param padStr
     * @param times
     * @return
     */
    public static String pad(String s, String padStr, int times) {
    	String padding = multiply(padStr, times);
    	return padding + s + padding; 
    }
    
    /**
     * Pad the given String on both sides to the given size.
     * 
     * e.g.:
     * 
     * padBothSides("300", 7, ".") >> "..300.."
     * padBothSides("300", 10, ".") >> "....300..."
     */
    public static String padBoth(String s, String padStr, int maxSize) {
    	if (s.length() >= maxSize) {
    		return s;
    		
    	} else {
    		int diff = maxSize - s.length();
    		int w = (int)Math.ceil((diff / 2f));
    		
    		if (diff % 2 == 0) { // even
    			return addRight(addLeft(s, padStr, w), padStr, w);

    		} else { // odd
    			return addRight(addLeft(s, padStr, w - 1), padStr, w);
    		}
    	}
    }
    
    /**
     * Return the last characters from the given String.
     * 
     * @param str
     * @param charCount number of characters to return (from the end)
     * @return
     */
    public static final String getLastCharacters(String str, int charCount) {
    	if (isSet(str) && str.length() > charCount) {
    		return str.substring(str.length() - charCount, str.length());

    	} else {
    		return str;
    	}
    }
}
