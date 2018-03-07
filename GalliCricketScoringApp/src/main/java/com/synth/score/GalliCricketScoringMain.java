/**
 * 
 */
package com.synth.score;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.synth.score.service.GalliCricketScoringService;
import com.synth.score.service.impl.GalliCricketScoringServiceImpl;
import com.synth.score.util.GalliCricketConstant;

/**
 * Main Class of the GalliCricketScoring
 * Call the Services to calculate the total Score scored
 * 
 * @author Sukanta Misra
 * @version 1.0
 * @since 06/03/2018
 *
 */
public class GalliCricketScoringMain {	
	private static final Logger logger = Logger.getLogger(GalliCricketScoringMain.class);
	private static final GalliCricketScoringService galliCricketService = new GalliCricketScoringServiceImpl();
	private static Scanner scanner = new Scanner(System.in);
	private static List<String> _indivScoreCalculate = new ArrayList<String>();
    
	/**
	 * This is the main function that will do the following functionality step by step
	 *     1. Call the Utility function "getDataFromConsole" to read the Console data for the number of Balls Bowled
	 *     2. Again Call the "getDataFromConsole" to read the Console data for the individual Score
	 *     3. Call the "calculateTotalScore" to calculate the total Score scored	 *   
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		logger.debug("Start of Scoring System of Galli Cricket");		
		galliCricketScoreProcessing();		
		logger.debug("End of Scoring System of Galli Cricket");
	}
	
	/*
	 * This function does the following Functionality 
	 * 
	 *    1. Call the Utility function "getDataFromConsole" to read the Console data for the number of Balls Bowled
	 *    2. Again Call the "getDataFromConsole" to read the Console data for the individual Score
	 *    3. Call the "calculateTotalScore" to calculate the total Score scored	 
	 *    
	 */
    public static void galliCricketScoreProcessing() {  
    	
    	int noOfBallsBowled = scanner.nextInt();
    	int [] ballsBowled = new int[noOfBallsBowled];
    	logger.info(ballsBowled.length);
		
		
		for(int i=0; i< noOfBallsBowled; i++) {				
			_indivScoreCalculate.add(scanner.next());			
		}
		
		int totalScore = galliCricketService.getTotalScore(_indivScoreCalculate);
		logger.debug("Total Score : " + totalScore);
		
		int scoreToDeductForWicketFall = galliCricketService.decideWicketFall(_indivScoreCalculate);
		totalScore += scoreToDeductForWicketFall;
		logger.debug(GalliCricketConstant.WICKET_FALL + totalScore);
		
		
		int scoreToDeduct = galliCricketService.checkPreviousDeliveryScore(_indivScoreCalculate);
		totalScore += scoreToDeduct;
		logger.debug( GalliCricketConstant.DOT_BLL_WICKET + totalScore);
		
		logger.info( GalliCricketConstant.TOTAL_SCORE + totalScore);
	}
}
