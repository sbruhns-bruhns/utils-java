package tech.stefanbruhns.utils.base;

import static java.io.File.separator;
import static java.lang.System.lineSeparator;
public abstract class BaseUtil {

	//
	// String constants
	//
	public static final String LS = lineSeparator(); // system-dependent line separator
	public static final String FS = separator;
	public static final String COLON = ":";
	public static final String COMMA_STR = ",";
	public static final String COMMA_SPACE = ", ";
    public static final String CURLY_BRACE_OPEN_STR = "{"; 
    public static final String CURLY_BRACE_CLOSE_STR = "}";
	public static final String DOT = ".";
	public static final String EMPTY = ""; // empty String
	public static final String EQUAL = "=";
	public static final String HYPHEN = "-";
	public static final String PERCENT = "%";
	public static final String PIPE = "|";
	public static final String PLUS = "+";
	public static final String SEMICOLON = ";";
	public static final String TAB = "\t";
	public static final String US = "_"; // underscore
	public static final String WS = " "; // white space
	
    //
    // RegEx constants
    //
    public static final String REGEX_HYPHEN = "\\-";
    public static final String REGEX_PIPE = "\\|";
    public static final String REGEX_WHITE_SPACE = "\\s";
}
