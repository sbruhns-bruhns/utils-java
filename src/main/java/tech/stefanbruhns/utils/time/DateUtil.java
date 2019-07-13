package tech.stefanbruhns.utils.time;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateUtil {
	
    /**
     * Common time zone identifiers
     */
	public static final String TZ_GMT = "GMT";
    public static final String TZ_EST = "America/New_York";
    
    /**
     * Common TimeZone instances
     */
    public static final TimeZone TIMEZONE_GMT = TimeZone.getTimeZone(TZ_GMT);
    
    /**
     * Commonly used date and time formats.
     */
    public static final String FORMAT_1 = "EEE MM/dd h:mma";  // Fri 11/09 11:45AM
	
    /**
     * Get SimpleDateFormat using GMT time zone and the given pattern.
     *
     * @param pattern   e.g.: "yyyyMMdd'T'HHmm"
     *
     * @return new SimpleDateFormat instance using GMT time zone.
     */
    public static SimpleDateFormat getDateFormatter(final String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setTimeZone(TIMEZONE_GMT);
        return sdf;
    }
}
