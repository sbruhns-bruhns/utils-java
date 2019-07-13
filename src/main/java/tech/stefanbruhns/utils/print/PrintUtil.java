package tech.stefanbruhns.utils.print;

import org.apache.commons.lang3.StringUtils;

public class PrintUtil {
	
    public static final String padLeft(String str, int size, char padChar) {
    	return StringUtils.leftPad(str, size, padChar);
    }
    
    public static final String padRight(String str, int size, char padChar) {
    	return StringUtils.rightPad(str, size, padChar);
    }
}
