package tech.stefanbruhns.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionsUtil {
	
    // ---------------------------------------------------------------------
    // EMPTY EVALUATIONS
    // ---------------------------------------------------------------------
	
    /**
     * Returns false if the given map is not null and has at least one element.
     * 
     * @param map
     * @return
     */
    public static final <K,V> boolean isEmpty(final Map<K,V> map) {
        return (map == null || map.isEmpty()) ? true : false;
    }

	/**
	 * Returns false if the given array is not null and has at least one element.
	 * 
	 * @param array
	 * @return
	 */
	public static final <T> boolean isEmpty(final T[] array) {
        return (array == null || array.length == 0) ? true : false;
    }    

    /**
     * Returns false if the given list is not null and has at least one element.
     * 
     * @param list
     * @return
     */
	public static final <T> boolean isEmpty(final List<T> list) {
        return (list == null || list.isEmpty()) ? true : false;
    }

	/**
	 * Returns false if the given set is not null and has at least one element.
	 * 
	 * @param set
	 * @return
	 */
    public static final <T> boolean isEmpty(final Set<T> set) {
        return (set == null || set.isEmpty()) ? true : false;
    }
    
    // ---------------------------------------------------------------------
    // CONVERSIONS
    // ---------------------------------------------------------------------

    /**
     * Return a shallow copy of the given Map as a TreeSet.
     * 
     * @param map
     * @return shallow copy of map
     */
    public static final <T> Set<T> toTreeSet(final Map<String, T> map) {
        final Set<T> set = new TreeSet<T>();

        if (!isEmpty(map)) {
	        for (final String i : map.keySet()) set.add(map.get(i));
        }

        return set;
    }

    /**
     * Return a shallow copy of the given Map as a HashSet.
     * 
     * @param map
     * @return shallow copy of map
     */
    public static final <T> Set<T> toHashSet(final Map<String, T> map) {
    	Set<T> set = new HashSet<T>(0);

        if (!isEmpty(map)) {
        	set = new HashSet<T>(map.size());
	        for (final String i : map.keySet()) set.add(map.get(i));
        }

        return set;
    }

    /**
     * Return a shallow copy of the given Map as a List.
     * 
     * @param map
     * @return
     */
    public static final <T> List<T> toList(final Map<String, T> map) {
        List<T> list = new ArrayList<T>(0); 

        if (!isEmpty(map)) {
        	list = new ArrayList<T>(map.size());
            for (final String i : map.keySet()) list.add(map.get(i));
        }

        return list;
    }
    
    
    /**
     * Return a shallow copy of the given Set as a List.
     * 
     * @param map
     * @return
     */
    public static final <T> List<T> toList(final Set<T> set) {
        List<T> list = new ArrayList<T>(0);
        
        if (!isEmpty(set)) {
        	list = new ArrayList<T>(set.size());
        	for (final T t : set) list.add(t);	
        }
        
        return list;
    }
    
    
    /**
     * Return a shallow copy of the given Array as a Set.
     * 
     * @param map
     * @return
     */
    public static final <T> Set<T> toSet(final T[] array) {
        Set<T> set = new HashSet<T>(0); 

        if (!isEmpty(array)) {
        	set = new HashSet<T>(array.length);
        	for (final T t : array) set.add(t);
        }

        return set;
    }

    /**
     * Return a map that holds the given list's items.
     * 
     * @param list
     * @return
     */
    public static Map<String, String> toMap(List<String> list) {
    	Map<String, String> m = new HashMap<String, String>(0);

    	if (!isEmpty(list)) {
    		m = new HashMap<String, String>(list.size());
    		for (String k : list) m.put(k, k);
    	}

    	return m;
    }

    // ---------------------------------------------------------------------
    // CONTAINS
    // ---------------------------------------------------------------------
    public static <T> boolean contains(boolean useList, final T[] array, T element) {
    	if (useList) {
	    	List<T> list = java.util.Arrays.asList(array);
	    	return list.contains(element);

    	} else {
    		return Arrays.stream(array).anyMatch(element::equals);	
    	}
    }

    // ---------------------------------------------------------------------
    // MANIPULATIONS
    // ---------------------------------------------------------------------

	public static List<Integer> removeDuplicates(List<Integer> l) {
		return l.stream().distinct().collect(Collectors.toList());
	}
}
