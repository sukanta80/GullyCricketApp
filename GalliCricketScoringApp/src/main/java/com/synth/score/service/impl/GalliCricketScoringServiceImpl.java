/**
 * 
 */
package com.synth.score.service.impl;

import java.util.List;

import com.synth.score.service.GalliCricketScoringService;
import com.synth.score.util.GalliCricketConstant;

/**
 * Implementation call for the GalliCricketScoringService
 * 
 * @author Sukanta Misra
 * @version 1.0
 * @since 06/03/2018
 *
 */
public class GalliCricketScoringServiceImpl implements GalliCricketScoringService{

   /**
	 *  Calculate the Total Score
	 *  Received the List<String> as parameter to calculate the total score
	 *  returns the total Score as integer
	 *  
	 *  @param individualScore 
	 *  @return totalScore  
	 */
	public int getTotalScore(List<String> individualScore) {
		
		int totalScrore = 0;
		for(String score : individualScore) {
			if(!"w".equalsIgnoreCase(score)) {				
				totalScrore += Integer.parseInt(score);
			}
		}
		return totalScrore;
	}

	/**
	 *  Decide the fall of Wicket (If a input is w then it is considered as a Wicket)
	 *  Received the List<String> as parameter to calculate the total score
	 *  returns the total Score as integer
	 *  
	 *  @param individualScore 
	 *  @return scoreToDeduct  
	 */
	public int decideWicketFall(List<String> individualScore) {
		
		int scoreToDeduct = 0;
		for (String score : individualScore) {			
			if(GalliCricketConstant.WICKET_BALL.equalsIgnoreCase(score)) {
				scoreToDeduct += GalliCricketConstant.DEDUCT_SCORE;				
			}			
		}
		return scoreToDeduct;
	}

	/**
	 *  Compare the curent score with the next score.
	 *  If both are 0 then it is a wicket
	 *  Received the List<String> as parameter to calculate the total score
	 *  returns the score to Deduct based on wickets as integer
	 *  
	 *  @param individualScore 
	 *  @return scoreToDeduct  
	 */
	public int checkPreviousDeliveryScore(List<String> individualScore) {
		
		int scoreToDeduct = 0;
		
		for(int i =0;i<individualScore.size();i++) {
			for(int j=i+1;j<individualScore.size();j++) {
				if(individualScore.get(j).equals("1")) {
					break;
				}
				
				if(individualScore.get(i).equals(GalliCricketConstant.ZERO_VALUE) && individualScore.get(j).equals(GalliCricketConstant.ZERO_VALUE)) {
					scoreToDeduct += GalliCricketConstant.DEDUCT_SCORE;
					i++;
					break;
				}
				if(individualScore.get(i).equals(GalliCricketConstant.ONE_VALUE)) {
					break;
				}
			}
		}
		
		return scoreToDeduct;
	}

}
