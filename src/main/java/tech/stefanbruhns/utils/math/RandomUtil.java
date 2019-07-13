package tech.stefanbruhns.utils.math;

public class RandomUtil {
	/**
	 * Return a random element from the given array.
	 * 
	 * @param strArray
	 * @return
	 */
    public static final String getRandom(final String[] strArray) {
        return strArray[(int)Math.round(Math.random() * (strArray.length-1))];
    }

    /**
     * Return a random integer between 0 and max.
     * 
     * @param max
     * @return
     */
    public static final int getRandomInt(final int max) {
        return (int)Math.round(Math.random() * max);
    }    

    /**
     * Return a random integer between min and max.
     * 
     * @param min
     * @param max
     * @return
     */
    public static final int getRandomInt(final int min, final int max) {
        int diff = max - min;
        return min + (int)Math.round(Math.random() * diff);
    }
    
    /**
     * Return a random long between min and max.
     * 
     * @param min
     * @param max
     * @return
     */
    public static final long getRandomLong(final long min, final long max) {
        long diff = max - min;
        return min + (long)Math.round(Math.random() * diff);
    }
}
