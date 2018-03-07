/**
 * 
 */
package com.synth.score.util;

/**
 * Utility Class for Galli Cricket App.
 * 
 * @author Sukanta Misra
 * @version 1.0
 * @since 06/03/2018
 *
 */
public class GalliCricketUtility {
	
	
	/**
	 * Convert a String to Integer
	 * 
	 * @param s
	 * @return Boolean Value
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
