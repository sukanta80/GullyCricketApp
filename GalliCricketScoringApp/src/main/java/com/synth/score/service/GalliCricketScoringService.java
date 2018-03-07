/**
 * 
 */
package com.synth.score.service;

import java.util.List;

/**
 * Service Interface
 * 
 * @author Sukanta Misra
 * @version 1.0
 * @since 06/03/2018
 *
 */
public interface GalliCricketScoringService {
	
	public int getTotalScore(List<String> individualScore);
	
	public int decideWicketFall(List<String> individualScore);
	
	public int checkPreviousDeliveryScore(List<String> individualScore);

}
